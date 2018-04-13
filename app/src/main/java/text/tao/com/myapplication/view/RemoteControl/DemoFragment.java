//package text.tao.com.myapplication.view.RemoteControl;
//
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.support.v4.app.Fragment;
//import android.support.v7.widget.GridLayoutManager;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.AdapterView;
//import android.widget.AdapterView.OnItemLongClickListener;
//import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItem;
//import java.util.ArrayList;
//import java.util.List;
//import mvp.tao.com.Main6;
//
//public class DemoFragment
//  extends Fragment
//{
//  private int[] pic1 = { 2130903072, 2130903073, 2130903054, 2130903071, 2130903074, 2130903075, 0, 2130903057, 2130903060, 2130903058 };
//  private int[] pic2 = { 2130903063, 2130903067, 2130903061, 2130903062, 2130903065, 2130903059, 2130903051, 2130903055, 2130903056, 2130903069 };
//
//  public View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
//  {
//    return paramLayoutInflater.inflate(2130968639, paramViewGroup, false);
//  }
//
//  public void onViewCreated(View paramView, @Nullable Bundle paramBundle)
//  {
//    super.onViewCreated(paramView, paramBundle);
//    RecyclerView localRecyclerView = (RecyclerView)paramView.findViewById(2131689693);
//    localRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 5));
//    localRecyclerView.setHasFixedSize(true);
//    int i = FragmentPagerItem.getPosition(getArguments());
//    ArrayList localArrayList = new ArrayList();
//    if (i == 0)
//    {
//      int m = 0;
//      if (m < this.pic1.length)
//      {
//        if (this.pic1[m] == 0) {
//          localArrayList.add(new DraggableInfo("Text", 0, m, 1));
//        }
//        for (;;)
//        {
//          m++;
//          break;
//          localArrayList.add(new DraggableInfo("", this.pic1[m], m, 0));
//        }
//      }
//    }
//    else
//    {
//      if (i == 2) {
//        for (int k = 0; k < this.pic2.length; k++) {
//          localArrayList.add(new DraggableInfo("", this.pic2[k], k, 0));
//        }
//      }
//      if (i == 3) {
//        for (int j = 0; j < 10; j++) {
//          localArrayList.add(new DraggableInfo(String.valueOf(j), 0, j, 1));
//        }
//      }
//    }
//    final MyAdapter localMyAdapter = new MyAdapter(getActivity(), localArrayList);
//    localRecyclerView.setAdapter(localMyAdapter);
//    localMyAdapter.setOnItemLongClickListener(new OnItemLongClickListener()
//    {
//      public boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
//      {
//        paramAnonymousView.setTag(localMyAdapter.getItem(paramAnonymousInt));
//        Tools.startDrag(paramAnonymousView);
//        ((Main6)DemoFragment.this.getActivity()).setDragInfo(localMyAdapter.getItem(paramAnonymousInt));
//        return false;
//      }
//    });
//  }
//}
//
//
///* Location:              /Users/bob/Downloads/mmm/dex2jar-0.0.9.15/classes_dex2jar.jar!/mvp/tao/com/view/RemoteControl/DemoFragment.class
// * Java compiler version: 6 (50.0)
// * JD-Core Version:       0.7.1
// */