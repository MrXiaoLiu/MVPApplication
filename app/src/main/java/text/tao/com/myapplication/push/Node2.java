package text.tao.com.myapplication.push;

import java.util.ArrayList;
import java.util.List;

/**
 * MrLiu253@163.com
 *
 * @time 2018/5/15
 */

public class Node2 {


    /**
     * data : {"msgs":["{\"msg\":\"{\\\"test\\\":1}\",\"mid\":15263563079657832,\"gid\":0}","{\"msg\":\"{\\\"test\\\":1}\",\"mid\":15263563179414700,\"gid\":0}","{\"msg\":\"{\\\"test\\\":1}\",\"mid\":15263563203011872,\"gid\":0}"],"pmsgs":[]}
     * msg : ok
     * ret : 0
     */

    private DataBean data;
    private String msg;
    private int ret;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getRet() {
        return ret;
    }

    public void setRet(int ret) {
        this.ret = ret;
    }

    public static class DataBean {
        private List<PushMessage> msgs;
        private List<PushMessage> pmsgs;

        public List<PushMessage> getMsgs() {
            if (msgs == null) {
                return new ArrayList<>();
            }
            return msgs;
        }

        public void setMsgs(List<PushMessage> msgs) {
            this.msgs = msgs;
        }

        public List<PushMessage> getPmsgs() {
            if (pmsgs == null) {
                return new ArrayList<>();
            }
            return pmsgs;
        }

        public void setPmsgs(List<PushMessage> pmsgs) {
            this.pmsgs = pmsgs;
        }
    }
}
