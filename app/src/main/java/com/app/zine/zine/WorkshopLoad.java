package com.app.zine.zine;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ScrollView;

public class WorkshopLoad extends ScrollView{
    int[] image_array = new int[]{
            R.layout.mech,
            R.layout.aero,
            R.layout.matlab,
            R.layout.web,
            R.layout.algo,
            R.layout.ic,
            R.layout.sensor,
            R.layout.elec,
            R.layout.hack,
            R.layout.android,
            R.layout.opamp,
            R.layout.drive,
            R.layout.tfive,
            R.layout.arduino,
            R.layout.lfr
    };

    int pos;

    public WorkshopLoad(Context context, int position) {

        super(context);
        pos=position;
        initView(context);
    }


    private void initView(Context context) {
        View view = inflate(context, R.layout.workshop_view,this);
        LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        /*textView = (TextView) view.findViewById(R.id.txt);
        textView.setText(""+pos);*/

        ScrollView scrollView =view.findViewById(R.id.ll);
        assert inflater != null;
        View child=inflater.inflate(image_array[pos],null);
        scrollView.addView(child);


    }


}
