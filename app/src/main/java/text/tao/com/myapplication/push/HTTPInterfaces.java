package text.tao.com.myapplication.push;

import android.util.Log;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import text.tao.com.myapplication.push.exception.GopushServerException;
import text.tao.com.myapplication.push.utils.HTTPUtils;
import text.tao.com.myapplication.utils.HttpTask;
import text.tao.com.myapplication.utils.HttpUtils;


public class HTTPInterfaces {
    public Node getNode(String key, Proto proto) throws GopushServerException {
        if (key == null || key.trim().length() == 0 || proto == null) {
            throw new IllegalArgumentException("key 和 proto不能为空");
        }
        String response = null;
        try {
            response = HTTPUtils.get(String.format(GET_NODE, key, proto.getProto()));

            if (response.trim().length() == 0) {
                throw new GopushServerException("服务端响应内容为空");
            }

            JSONObject jo = JSONObject.fromObject(response);
            int ret = jo.getInt("ret");
            switch (RetCode.getRetCode(ret)) {
                case SUCCESS:
                    JSONObject data = jo.getJSONObject("data");
                    if (data == null) {
                        throw new GopushServerException("服务端报文有误 [" + response + "]");
                    }
                    String server = jo.getJSONObject("data").getString("server");
                    if (server == null || server.trim().length() == 0) {
                        throw new GopushServerException("服务端报文有误 [" + response + "]");
                    }
                    String[] args = server.split(":");

                    return new Node(key, args[0], Integer.parseInt(args[1]));
                case NOT_FOUND_NODE:
                    throw new GopushServerException("指定节点已经失效");
                default:
                    throw new GopushServerException("错误码: " + ret + ", " + jo.getString("message"));
            }
        } catch (Exception e) {
            throw new GopushServerException("连接异常", e);
        }
    }


    public void login(String string, final HttpUtils.OnHttpResultListener onHttpResultListener) {
        //采用传统代码实现
        HttpTask httpTask = new HttpTask(result -> {
            //解析JSON，查询数据库
            //..忽略100行代码
            onHttpResultListener.onResult(result);
        });
        httpTask.execute(string);

    }

    /**
     * 获取离线消息
     *
     * @param key 客户端key
     *            //	 * @param mid
     *            私有消息ID
     *            //	 * @param pmid
     *            公开消息ID
     * @return
     */

    String response;

    public List<PushMessage> getOfflineMessages(String key, Node node) throws GopushServerException {
        if (key == null || key.trim().length() == 0) {
            throw new IllegalArgumentException("key不可为空");
        } else if (node == null) {
            throw new IllegalArgumentException("node不可为空");
        }


        Log.i("aaa","11111"+String.format(GET_OFFLINE, key, node.getMid(), node.getPmid()));
        login(String.format(GET_OFFLINE, key, node.getMid(), node.getPmid()), new HttpUtils.OnHttpResultListener() {
                    @Override
                    public void onResult(String result) {
                        response = result;
                    }
                }
        );
        Log.i("aaa","222"+response);

        try {
            JSONObject jo = JSONObject.fromObject(response);
            int ret = jo.getInt("ret");
            switch (RetCode.getRetCode(ret)) {
                case SUCCESS:
                    JSONObject data = jo.getJSONObject("data");
                    if (data == null) {
                        throw new GopushServerException("服务端报文有误 [" + response + "]");
                    } else if (data.isEmpty()) {
                        return new LinkedList<PushMessage>();
                    }
                    List<PushMessage> messages = new LinkedList<PushMessage>();
                    JSONArray msgs = data.getJSONArray("msgs");
                    if (!msgs.isEmpty()) {
                        for (Iterator<?> it = msgs.iterator(); it.hasNext(); ) {
                            PushMessage message = (PushMessage) JSONObject.toBean((JSONObject) it.next(), PushMessage.class);
                            node.refreshMid(message.getMid());
                            messages.add(message);
                        }
                    }
                    msgs = data.getJSONArray("pmsgs");
                    if (!msgs.isEmpty()) {
                        for (Iterator<?> it = msgs.iterator(); it.hasNext(); ) {
                            PushMessage message = (PushMessage) JSONObject.toBean((JSONObject) it.next(), PushMessage.class);
                            node.refreshPmid(message.getMid());
                            messages.add(message);
                        }
                    }
                    return messages;
                case NOT_FOUND_NODE:
                    throw new GopushServerException("指定节点已经失效");
                default:
                    throw new GopushServerException("错误码: " + ret + ", " + jo.getString("message"));
            }
        }catch (Exception e ){
            Log.i("aaa","b报错"+e.getLocalizedMessage());
            throw new GopushServerException("连接异常", e);
        }


//		try {
//			response = HTTPUtils.get(String.format(GET_OFFLINE, key, node.getMid(), node.getPmid()));
//			if (response.trim().length() == 0) {
//				throw new GopushServerException("服务端响应内容为空");
//			}
//			JSONObject jo = JSONObject.fromObject(response);
//			int ret = jo.getInt("ret");
//			switch (RetCode.getRetCode(ret)) {
//			case SUCCESS:
//				JSONObject data = jo.getJSONObject("data");
//				if (data == null) {
//					throw new GopushServerException("服务端报文有误 [" + response + "]");
//				} else if (data.isEmpty()) {
//					return new LinkedList<PushMessage>();
//				}
//				List<PushMessage> messages = new LinkedList<PushMessage>();
//				JSONArray msgs = data.getJSONArray("msgs");
//				if (!msgs.isEmpty()) {
//					for (Iterator<?> it = msgs.iterator(); it.hasNext();) {
//						PushMessage message = (PushMessage) JSONObject.toBean((JSONObject) it.next(), PushMessage.class);
//						node.refreshMid(message.getMid());
//						messages.add(message);
//					}
//				}
//				msgs = data.getJSONArray("pmsgs");
//				if (!msgs.isEmpty()) {
//					for (Iterator<?> it = msgs.iterator(); it.hasNext();) {
//						PushMessage message = (PushMessage) JSONObject.toBean((JSONObject) it.next(), PushMessage.class);
//						node.refreshPmid(message.getMid());
//						messages.add(message);
//					}
//				}
//				return messages;
//			case NOT_FOUND_NODE:
//				throw new GopushServerException("指定节点已经失效");
//			default:
//				throw new GopushServerException("错误码: " + ret + ", " + jo.getString("message"));
//			}
//		} catch (IOException e) {
//			throw new GopushServerException("连接异常", e);
//		}
    }



    public HTTPInterfaces(String host, int port) {
        this("192.168.3.36", 8090, false);
    }

    public HTTPInterfaces(String host, int port, boolean isSSL) { // TODO 暂时不支持SSL
        String base = "http://" + host + ":" + port;
        GET_NODE = base + "/server/get?key=%s&proto=%d";
        GET_OFFLINE = base + "/msg/get?key=%s&mid=%d&pmid=%d";
    }

//	public static void main(String[] args) throws Exception {
//		HTTPInterfaces interfaces = new HTTPInterfaces("114.112.93.13", 80);
//		Node node = interfaces.getNode("Terry-Mao", Proto.TCP);
//		interfaces.getOfflineMessages("Terry-Mao", node);
//	}

    private final String GET_NODE;
    private final String GET_OFFLINE;
}
