package zine.co.in;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

public class Teamadapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] cn;
    private final String[] cb;
    private final String[] cm;
    private final Integer[] imageid;
    Teamadapter(Activity context,String[] cn,String[] cb,String[] cm,Integer[] imageid){
        super(context,R.layout.my_list,cn);
        this.context=context;
        this.cn=cn;
        this.imageid=imageid;
        this.cb=cb;
        this.cm=cm;
    }
    @NonNull
    @Override
    public View getView(int position, View view, @NonNull ViewGroup parent){
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.my_list,null,false);
        TextView name=rowView.findViewById(R.id.name);
        TextView branch=rowView.findViewById(R.id.branch);
        final TextView mobile=rowView.findViewById(R.id.mobile);
        ImageView image=rowView.findViewById(R.id.t1);

        name.setText(cn[position]);
        branch.setText(cb[position]);
        mobile.setText(cm[position]);
        image.setImageResource(imageid[position]);
        return rowView;
    }


}
