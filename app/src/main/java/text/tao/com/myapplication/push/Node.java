package text.tao.com.myapplication.push;

import android.os.Parcel;
import android.os.Parcelable;

public class Node implements Parcelable {
	private String key;
	private String host;
	private int port;
	private long mid;
	private long pmid;
	/**
	 * data : {"server":"192.168.3.36:6969"}
	 * msg : ok
	 * ret : 0
	 */

	private DataBean data;
	private String msg;
	private int ret;


	public Node(String key, String host, int port) {
		this(key, host, port, 0L, 0L);
	}

	public Node(String key, String host, int port, long mid, long pmid) {
		this.key = key;
		this.host = host;
		this.port = port;
		if (mid < 0 || pmid < 0) {
			throw new IllegalArgumentException("mid与pmid必须大于等于s0");
		}
		this.mid = mid;
		this.pmid = pmid;
	}

	protected Node(Parcel in) {
		key = in.readString();
		host = in.readString();
		port = in.readInt();
		mid = in.readLong();
		pmid = in.readLong();
		msg = in.readString();
		ret = in.readInt();
	}

	public static final Creator<Node> CREATOR = new Creator<Node>() {
		@Override
		public Node createFromParcel(Parcel in) {
			return new Node(in);
		}

		@Override
		public Node[] newArray(int size) {
			return new Node[size];
		}
	};

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public long getMid() {
		return mid;
	}

	public long getPmid() {
		return pmid;
	}

	public boolean refreshMid(long mid) {
		if (this.mid < mid) {
			this.mid = mid;
			return true;
		}
		return false;
	}

	public boolean refreshPmid(long pmid) {
		if (this.pmid < pmid) {
			this.pmid = pmid;
			return true;
		}
		return false;
	}

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

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(key);
		dest.writeString(host);
		dest.writeInt(port);
		dest.writeLong(mid);
		dest.writeLong(pmid);
		dest.writeString(msg);
		dest.writeInt(ret);
	}

	public static class DataBean {
		/**
		 * server : 192.168.3.36:6969
		 */

		private String server;

		public String getServer() {
			return server;
		}

		public void setServer(String server) {
			this.server = server;
		}
	}
}
