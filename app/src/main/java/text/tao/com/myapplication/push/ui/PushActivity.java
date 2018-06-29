package text.tao.com.myapplication.push.ui;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;
import android.view.View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import text.tao.com.myapplication.MVPDemo.BaseActivity;
import text.tao.com.myapplication.R;
import text.tao.com.myapplication.push.GoPushCli;
import text.tao.com.myapplication.push.Listener;
import text.tao.com.myapplication.push.Node;
import text.tao.com.myapplication.push.PushMessage;


/**
 * MrLiu253@163.com
 *
 * @time 2018/5/14
 */

public class PushActivity extends BaseActivity<PushView, PushPresenter> implements View.OnClickListener, PushView {




    private ThreadLocal<GoPushCli> local = new ThreadLocal<GoPushCli>();

    Node mNode;

    Socket socket = null;
    public Handler myHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 0x11) {
                Bundle bundle = msg.getData();
                Log.i("aaa", "Handler中的消息+" + bundle.getString("msg"));


                final GoPushCli cli = local.get();

                Thread  heartbeatTask = new Thread(new HeartbeatTask()); // 准备定时心跳任务
                heartbeatTask.start();
                cli.start(false, 1526277492, 1526277492, mNode);

                Log.i("aaa", "获取节点失败" + cli.isGetNode());
                Log.i("aaa", "握手失败" + cli.isHandshake());
            }
        }

    };
    private BackService2 mBackService2;
//    ServiceConnection conn = new ServiceConnection() {
//        @Override
//        public void onServiceConnected(ComponentName name, IBinder service) {
//
//            mBackService2 =  service.getService();
//        }
//
//        @Override
//        public void onServiceDisconnected(ComponentName name) {
//
//        }
//    };
    @Inject
    PushPresenter mPresenter;

    @Override
    protected void onitiv(Bundle paramBundle) {

        setContentView(R.layout.activity_push);

        findViewById(R.id.button1).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);

        set();
        mPresenter.login("ni");

    }

    @Override
    public PushPresenter createPresenter() {
        return this.mPresenter;
    }

    @Override
    public PushView createView() {
        return this;
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                set();
                break;
            case R.id.button2:
                Log.i("aaa", "local.get()=" + local.get());
                break;
        }
    }

    private void text(String protocol) {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
            // 发送请求协议
            writer.print(protocol);// 这里原本实现是没有加换行符的
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void set() {
        local.set(new GoPushCli("192.168.3.36", 8090, "ni", 10000, new Listener() {
            @Override
            public void onOpen() {
                Log.i("aaa", "onOpen");
            }

            @Override
            public void onClose() {
                Log.i("aaa", "onClose");
            }

            @Override
            public void onOnlineMessage(PushMessage message) {
                Log.i("aaa", "online message: "
                        + message.getMsg());
            }

            @Override
            public void onOfflineMessage(List<PushMessage> messages) {
                if (messages != null)
                    for (PushMessage message : messages) {
                        Log.i("aaa", "offline message: " + message.getMsg());
                    }
            }

            @Override
            public void onError(Throwable e, String message) {

                Log.i("aaa", "错误" + message);
            }
        }));
    }

    @Override
    public void complete() {
        Log.i("aaa", "请求完成");
    }

    @Override
    public void showError(String paramString) {
        Log.i("aaa", "请求出错" + paramString);
    }

    @Override
    public void onLoginResult(Node node) {
        Log.i("aaa", "请求完成");


        mNode = node;

        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //启动线程 向服务器发送和接收信息
//                new MyThread(node).start();
                Intent intent = new Intent(PushActivity.this,BackService2.class);
                intent.putExtra("node",mNode);
//                bindService(intent,conn, Context.BIND_AUTO_CREATE);
                startService(intent);
            }
        });


//        cli.destory();
    }


    class MyThread extends Thread {

        public Node node;

        public MyThread(Node str) {
            node = str;
        }

        @Override
        public void run() {
            //定义消息
            Message msg = new Message();
            msg.what = 0x11;
            Bundle bundle = new Bundle();
            bundle.clear();
            try {
                //连接服务器 并设置连接超时为5秒
                socket = new Socket();
                socket.setKeepAlive(true);
                socket.setSoTimeout((10000 + 15) * 1000);
                socket.connect(new InetSocketAddress(node.getHost(), node.getPort()));

                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));


                String heartbeatStr = "10000";
                String protocol = "*3\r\n$3\r\nsub\r\n$" + node.getKey().length() + "\r\n" + node.getKey() + "\r\n$" + heartbeatStr.length() + "\r\n" + heartbeatStr + "\r\n";

                // 发送请求协议
                writer.print(protocol);// 这里原本实现是没有加换行符的
                writer.flush();


                String response = reader.readLine();
                Log.i("aaa", "这个是" + response);
                if (response.startsWith("+")) {
                    // 初始心跳
                    boolean isHandshake = true;
                } else if (response.startsWith("-")) {
                    // 协议错误
                    throw new Exception("comet节点握手协议错误: " + response);
                } else {
                    throw new IllegalArgumentException("无法识别comet返回协议: " + response);
                }

                bundle.putString("msg", "完成");
                msg.setData(bundle);
                myHandler.sendMessage(msg);
            } catch (SocketTimeoutException aa) {
                Log.i("aaa", "连接错误" + aa.getLocalizedMessage());
                //连接超时 在UI界面显示消息
                bundle.putString("msg", "服务器连接失败！请检查网络是否打开");
                msg.setData(bundle);
                //发送消息 修改UI线程中的组件
                myHandler.sendMessage(msg);
            } catch (IOException e) {
                e.printStackTrace();
                bundle.putString("msg", "IOException");
                msg.setData(bundle);
                myHandler.sendMessage(msg);
                Log.i("aaa", "连接错误" + e.getLocalizedMessage());
            } catch (Exception e) {
                e.printStackTrace();
                bundle.putString("msg", "Exception");
                msg.setData(bundle);
                myHandler.sendMessage(msg);
                Log.i("aaa", "总的连接错误" + e.getLocalizedMessage());
            }
        }
    }

    private class HeartbeatTask implements Runnable {

        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                // 发送心跳
                text("h");
                try {
                    TimeUnit.SECONDS.sleep(10000);
                } catch (InterruptedException e) {
                    System.err.println("Timer is stop");
                    break;
                }
            }
        }
    }
}
