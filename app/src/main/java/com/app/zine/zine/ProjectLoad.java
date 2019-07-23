package com.app.zine.zine;
import android.content.Context;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;


public class ProjectLoad extends ScrollView{

    int[] image_array = new int[]{

            R.layout.bci,
            R.layout.quad,
            R.layout.chair,
            R.layout.arm,
            R.layout.gait,
            R.layout.hci,
            R.layout.sun,
            R.layout.grid,
            R.layout.exo,
            R.layout.hand
    };

    int pos;

    public ProjectLoad(Context context, int position) {

        super(context);
        pos=position;
        initView(context);
    }


    private void initView(Context context) {
        View view = inflate(context, R.layout.project_view,this);
        LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        /*textView = (TextView) view.findViewById(R.id.txt);
        textView.setText(""+pos);*/

        ScrollView scrollView =view.findViewById(R.id.ll);
        assert inflater != null;
        View child=inflater.inflate(image_array[pos],null);
        scrollView.addView(child);


    }
}
