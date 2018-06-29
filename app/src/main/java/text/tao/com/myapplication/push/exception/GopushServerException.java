package text.tao.com.myapplication.push.exception;

@SuppressWarnings("serial")
public class GopushServerException extends Exception {
	public GopushServerException() {
		super();
	}

	public GopushServerException(String message) {
		super(message);
	}

	public GopushServerException(String message, Throwable t) {
		super(message, t);
	}
}
