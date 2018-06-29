package text.tao.com.myapplication.push.ui;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import net.sf.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Flowable;
import text.tao.com.myapplication.AppApplication;
import text.tao.com.myapplication.MVPDemo.Api.bean.Bean2;
import text.tao.com.myapplication.MVPDemo.Api.bean.IndexBean;
import text.tao.com.myapplication.MVPDemo.Api.dagger2.DaggerActivityComponent;
import text.tao.com.myapplication.MVPDemo.Api.dagger2.DaggerServiceComponent;
import text.tao.com.myapplication.MVPDemo.Api.dagger2.ServiceModule;
import text.tao.com.myapplication.MVPDemo.retrofit2.RetrofitHelper;
import text.tao.com.myapplication.MVPDemo.rx.*;
import text.tao.com.myapplication.push.BaseP;
import text.tao.com.myapplication.push.Listener;
import text.tao.com.myapplication.push.Node;
import text.tao.com.myapplication.push.Node2;
import text.tao.com.myapplication.push.PushMessage;


/**
 * MrLiu253@163.com
 *
 * @time 2018/5/15
 */

public class BackService2 extends Service {


    BufferedReader reader;
    PrintWriter writer;


    Node mNode;
    boolean isHandshake = false;
    WeakReference<Socket> mWeakReference;
    /**
     * 读线程
     */
    private ReadThread mReadThread;


    private Listener listener;

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    private LocalBroadcastManager mLocalBroadcastManager;

    {
        DaggerServiceComponent.builder()
                .appComponent(AppApplication.getInstance().getAppComponent())
                .serviceModule(new ServiceModule(this))
                .build()
                .inject(this);

    }

    public BackService2() {
    }

    @Inject
    BaseP mBaseP;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    @Override
    public void onCreate() {
        super.onCreate();


//        mNode.refreshMid(mid);
//        mNode.refreshPmid(pmid);

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //对于每一个启动请求，都发送一个消息来启动一个处理
        //同时传入启动ID，以便任务完成后我们知道该终止哪一个请求。


        mNode = intent.getParcelableExtra("node");
        new InitSocketThread().start(); // 初始化socket
        mLocalBroadcastManager = LocalBroadcastManager.getInstance(this);
        //如果我们被杀死了，那从这里返回之后被重启
        return START_STICKY;
    }


    private class InitSocketThread extends Thread {

        @Override
        public void run() {
            super.run();
            initSocket();
        }
    }

    //初始化Socket
    private void initSocket() {

        String key = "liu";

        try {
            //连接服务器 并设置连接超时为5秒
            Socket socket = new Socket();
            socket.setKeepAlive(true);

            socket.setSoTimeout((30 + 15) * 1000);

            Log.i("aaa", "域名" + mNode.getHost() + "端口号" + mNode.getPort());
            socket.connect(new InetSocketAddress(mNode.getHost(), mNode.getPort()));

            mWeakReference = new WeakReference<Socket>(socket);

            //创建控制台用于输入。 得到输入的内容（reader.readLine()）
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

            // 发送请求协议头
            String heartbeatStr = "30";
            String protocol = "*3\r\n$3\r\nsub\r\n$" + key.length() + "\r\n" + key + "\r\n$" + heartbeatStr.length() + "\r\n" + heartbeatStr + "\r\n";

            writer.print(protocol);// 这里原本实现是没有加换行符的
            writer.flush();//刷新Io流

            String response = null;

            response = reader.readLine();

            if (response.startsWith("+")) {
                // 初始心跳
                isHandshake = true;
            } else if (response.startsWith("-")) {
                // 协议错误
//                throw new Exception("comet节点握手协议错误: " + response);
            } else {
                throw new IllegalArgumentException("无法识别comet返回协议: " + response);
            }

//            listener.onOpen();
//            listener.onOfflineMessage();//获取离线消息
            Node2 node2 = mBaseP.getP(key);
            Log.i("aaa", "得到的离线消息" + node2);

            mReadThread = new ReadThread(socket);
            mReadThread.start();


            String xin = reader.readLine();
            String line = null;

            while ((line = reader.readLine()) != null) {
                Log.i("aaa", "发送心跳之后" + xin + "====" + line);
                if (line.startsWith("+")) {
                    // 忽略心跳
                } else if (line.startsWith("$")) {
                    line = reader.readLine();
                    Log.i("aaa", "有没有消息" + line);
                    PushMessage message = (PushMessage) JSONObject.toBean(JSONObject.fromObject(line), PushMessage.class);
                    boolean isRefresh = false;
                    if (message.isPub()) {
                        isRefresh = mNode.refreshPmid(message.getMid());
                    } else if (!message.isPub()) {
                        isRefresh = mNode.refreshMid(message.getMid());

                    }
                    Log.i("aaa", "有没有消息" + isRefresh);
                    if (isRefresh) {
                        Log.i("aaa", "消息" + message);
//                            listener.onOnlineMessage(message);
                    }
                } else if (line.startsWith("-")) {
                    Log.i("aaa", "错误comet节点订阅协议错误" + line);
                }
            }
        }
//        catch (SocketException e) {
//            Log.i("aaa","SocketException"+e.getLocalizedMessage());
//            e.printStackTrace();
//        }
        catch (IOException e) {
            e.printStackTrace();
            Log.i("aaa", "IOException" + mWeakReference.get() + "===" + mWeakReference.get().isClosed());
            Log.i("aaa",
                    "\n是否连接成功过=" + mWeakReference.get().isConnected() +
                            "\nisBound=" + mWeakReference.get().isBound() +
                            "\nisClosed=" + mWeakReference.get().isClosed() +
                            "\nisInputShutdown=" + mWeakReference.get().isInputShutdown() +
                            "\nisOutputShutdown=" + mWeakReference.get().isOutputShutdown());
        }
//        catch (Exception e) {
//            e.printStackTrace();
//            Log.i("aaa","Exception"+e.getLocalizedMessage());
//        }
    }

    //线程从套接字读取内容
    private class ReadThread extends Thread {

        private WeakReference<Socket> mWeakSocket;
        private boolean isStart = true;

        public ReadThread(Socket socket) {
            mWeakSocket = new WeakReference<Socket>(socket);
        }

        @Override
        public void run() {
            super.run();
//            PrintWriter writer = null;
            try {

//                writer = new PrintWriter(new OutputStreamWriter(mWeakSocket.get().getOutputStream()));
//                BufferedReader reader = new BufferedReader(new InputStreamReader(mWeakSocket.get().getInputStream()));

                //获取当前线程 并测试是否当前线程已被中断 中断返回true，否则返回false
                while (!Thread.currentThread().isInterrupted()) {
                    // 发送心跳
                    writer.print("h");// 这里原本实现是没有加换行符的
                    writer.flush();
                    try {
                        //使用枚举延时
                        TimeUnit.SECONDS.sleep(30);
                    } catch (InterruptedException e) {

                        Log.i("aaa", "InterruptedException=" + e.getLocalizedMessage());
                        System.err.println("Timer is stop");
                        break;
                    }
                }


//                String line = null;
//                while ((line = reader.readLine()) != null) {
//                    if (line.startsWith("+")) {
//                        // 忽略心跳
//                    } else if (line.startsWith("$")) {
//                        line = reader.readLine();
//                        PushMessage message = (PushMessage) JSONObject.toBean(JSONObject.fromObject(line), PushMessage.class);
//                        boolean isRefresh = false;
//                        if (message.isPub()) {
//                            isRefresh = mNode.refreshPmid(message.getMid());
//                        } else if (!message.isPub()) {
//                            isRefresh = mNode.refreshMid(message.getMid());
//
//                        }
//                        Log.i("aaa","有没有消息"+isRefresh);
//                        if (isRefresh) {
//                            Log.i("aaa","消息"+message);
//                            listener.onOnlineMessage(message);
//                        }
//                    } else if (line.startsWith("-")) {
//                        Log.i("aaa", "错误comet节点订阅协议错误" + line);
//                    }
//                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 心跳机制判断出socket已经断开后，就销毁连接方便重新创建连接
     *
     * @param mSocket
     */
    private void releaseLastSocket(WeakReference<Socket> mSocket) {
        try {
            if (null != mSocket) {
                Socket sk = mSocket.get();
                if (!sk.isClosed()) {
                    sk.close();
                }
                sk = null;
                mSocket = null;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("aaa", "onDestroy");
    }

    private class MsgBinder extends Binder {
        /**
         * 获取当前Service的实例
         *
         * @return
         */
        public BackService2 getService() {
            return BackService2.this;
        }
    }
}
