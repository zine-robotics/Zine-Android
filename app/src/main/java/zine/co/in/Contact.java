package zine.co.in;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


public class Contact extends Fragment{

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.contact,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        final View vt=super.getView();
        assert vt != null;


        CardView i=vt.findViewById(R.id.tanishk);
        CardView i1=vt.findViewById(R.id.vishal);
        CardView i2=vt.findViewById(R.id.devnath);
        CardView i3=vt.findViewById(R.id.kriti);


        i.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(getActivity(),"Call",Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        i1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(getActivity(),"Call",Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        i3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(getActivity(),"Call",Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        i2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(getActivity(),"Call",Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url="tel:918947892024";
                Intent i=new Intent(Intent.ACTION_DIAL, Uri.parse(url));
                startActivity(i);
            }
        });
        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url="tel:919909435279";
                Intent i=new Intent(Intent.ACTION_DIAL,Uri.parse(url));
                startActivity(i);
            }
        });
        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url="tel:919636080788";
                Intent i=new Intent(Intent.ACTION_DIAL,Uri.parse(url));
                startActivity(i);
            }
        });
        i3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url="tel:919828042882";
                Intent i=new Intent(Intent.ACTION_DIAL,Uri.parse(url));
                startActivity(i);
            }
        });

        super.onViewCreated(view, savedInstanceState);


    }
    public void onCreate(Bundle savedInstancesState)
    {
        super.onCreate(savedInstancesState);

    }
}
