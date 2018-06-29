package text.tao.com.myapplication.push;

import java.util.List;

public interface Listener {
	void onOpen();

	void onClose();

	void onOnlineMessage(PushMessage message);

	void onOfflineMessage(List<PushMessage> messages);

	void onError(Throwable e, String message);
}
