package text.tao.com.myapplication.view.RemoteControl;

import android.content.ClipData;
import android.content.Intent;
import android.os.Build;
import android.view.View;
import android.view.View.DragShadowBuilder;

public class Tools
{
  public static final int ONE_BY_ONE_PIC = 0;
  public static final int ONE_BY_ONE_TEXT = 1;
  public static final int ONE_BY_TWO_PIC = 3;
  public static final int THREE_BY_THREE_PIC = 2;
  
  public static void startDrag(View paramView)
  {
    DraggableInfo localDraggableInfo = (DraggableInfo)paramView.getTag();
    if (localDraggableInfo == null) {
      localDraggableInfo = new DraggableInfo("Text", 0, 0, 1);
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("data", localDraggableInfo);
    ClipData localClipData = ClipData.newIntent("value", localIntent);
    DragShadowBuilder localDragShadowBuilder = new DragShadowBuilder(paramView);
    paramView.performHapticFeedback(0, 2);
    if (Build.VERSION.SDK_INT >= 24)
    {
      paramView.startDragAndDrop(localClipData, localDragShadowBuilder, null, 0);
      return;
    }
    paramView.startDrag(localClipData, localDragShadowBuilder, null, 0);
  }
}