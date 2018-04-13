//package text.tao.com.myapplication.MVP;
//
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.support.v4.app.Fragment;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//import com.haibin.calendarview.Calendar;
//import com.haibin.calendarview.CalendarView;
//import com.haibin.calendarview.CalendarView.OnDateSelectedListener;
//
//public class ViewPager_V1
//  extends Fragment
//{
//  TextView text;
//  View view;
//
//  private void getView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup)
//  {
//    this.view = paramLayoutInflater.inflate(2130968630, paramViewGroup, false);
//    this.text = ((TextView)this.view.findViewById(2131689489));
//    CalendarView localCalendarView = (CalendarView)this.view.findViewById(2131689686);
//    localCalendarView.isYearSelectLayoutVisible();
//    localCalendarView.setOnDateSelectedListener(new CalendarView.OnDateSelectedListener()
//    {
//      public void onDateSelected(Calendar paramAnonymousCalendar, boolean paramAnonymousBoolean)
//      {
//        Log.i("aaa", "选择" + paramAnonymousCalendar);
//      }
//    });
//  }
//
//  public void onCreate(@Nullable Bundle paramBundle)
//  {
//    super.onCreate(paramBundle);
//  }
//
//  @Nullable
//  public View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
//  {
//    getView(paramLayoutInflater, paramViewGroup);
//    return this.view;
//  }
//
//  public void onDestroyView()
//  {
//    super.onDestroyView();
//  }
//}
//
//
///* Location:              /Users/bob/Downloads/mmm/dex2jar-0.0.9.15/classes_dex2jar.jar!/mvp/tao/com/MVP/ViewPager_V1.class
// * Java compiler version: 6 (50.0)
// * JD-Core Version:       0.7.1
// */