package com.app.zine.zine;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;

public class MovieAdapter extends BaseAdapter {

    private int[] image_array;
    private Context mContext;

    MovieAdapter(Context mContext, int[] image_array) {
        this.mContext = mContext;
        this.image_array=image_array;
    }

    @Override
    public int getCount() {
        return image_array.length;
    }

    @Override
    public Object getItem(int i) {
        return image_array[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        View rowView = view;

        if(rowView==null)
        {
            rowView = LayoutInflater.from(mContext).inflate(R.layout.layout_item,parent,false);
            LayoutInflater inflater=(LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            FrameLayout frameLayout=rowView.findViewById(R.id.fl);

            assert inflater != null;
            View child= inflater.inflate(image_array[i],null);
            frameLayout.addView(child);

        }
        return rowView;

    }
}
