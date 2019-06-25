package zine.co.in;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;


public class ProjectLoad extends ScrollView{

    public static String[] name={"Hand Gesture Recognition","Automotive WheelChair","Autonomous Quadcopter","Prosthetic Arm","Gait Analysis","Human Computer Interface","Sun Tracker","Exoskeleton","Smart Grid"};

    int pos;

    public ProjectLoad(Context context, int position) {

        super(context);
        pos=position;
        initView(context);
    }

    private void initView(Context context) {
        View view = inflate(context, R.layout.project_view,this);
        /*textView = (TextView) view.findViewById(R.id.txt);
        textView.setText(""+pos);*/

        ScrollView scrollView =view.findViewById(R.id.ll);
        TextView child=new TextView(context);
        child.setText(name[pos]);
        child.setTextColor(getResources().getColor(R.color.black));
        child.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT));
        child.setGravity(Gravity.CENTER);
        child.setTypeface(null, Typeface.BOLD);
        child.setTextSize(25);
        scrollView.addView(child);


    }


}
