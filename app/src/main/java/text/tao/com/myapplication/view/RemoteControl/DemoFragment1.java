//package text.tao.com.myapplication.view.RemoteControl;
//
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.support.v4.app.Fragment;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.View.OnLongClickListener;
//import android.view.ViewGroup;
//import mvp.tao.com.Main6;
//
//public class DemoFragment1
//  extends Fragment
//  implements OnLongClickListener
//{
//  public View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
//  {
//    return paramLayoutInflater.inflate(2130968640, paramViewGroup, false);
//  }
//
//  public boolean onLongClick(View paramView)
//  {
//    Tools.startDrag(paramView);
//    ((Main6)getActivity()).setDragInfo((DraggableInfo)paramView.getTag());
//    return false;
//  }
//
//  public void onViewCreated(View paramView, @Nullable Bundle paramBundle)
//  {
//    super.onViewCreated(paramView, paramBundle);
//    paramView.findViewById(2131689699).setTag(new DraggableInfo("", 2130903053, 0, 2));
//    paramView.findViewById(2131689703).setTag(new DraggableInfo("", 2130903064, 0, 0));
//    paramView.findViewById(2131689702).setTag(new DraggableInfo("", 2130903066, 0, 0));
//    paramView.findViewById(2131689700).setTag(new DraggableInfo("", 2130903052, 0, 3));
//    paramView.findViewById(2131689701).setTag(new DraggableInfo("", 2130903068, 0, 3));
//    paramView.findViewById(2131689699).setOnLongClickListener(this);
//    paramView.findViewById(2131689703).setOnLongClickListener(this);
//    paramView.findViewById(2131689702).setOnLongClickListener(this);
//    paramView.findViewById(2131689700).setOnLongClickListener(this);
//    paramView.findViewById(2131689701).setOnLongClickListener(this);
//  }
//}
//
//
///* Location:              /Users/bob/Downloads/mmm/dex2jar-0.0.9.15/classes_dex2jar.jar!/mvp/tao/com/view/RemoteControl/DemoFragment1.class
// * Java compiler version: 6 (50.0)
// * JD-Core Version:       0.7.1
// */