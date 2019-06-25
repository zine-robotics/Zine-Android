package zine.co.in;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class Faq extends Fragment{

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.faq,container,false);
    }
    public void onCreate(Bundle savedInstancesState)
    {
        super.onCreate(savedInstancesState);

    }
}
