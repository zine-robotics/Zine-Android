package com.app.zine.zine;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

public class MainActivity extends AppCompatActivity {


    Home home;
    Faq faq;
    Query query;
    Contact contact;
    Register register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar =  findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        Typeface tf = Typeface.createFromAsset(getAssets(), "Megatron.otf");
        CollapsingToolbarLayout collapsingToolbarLayout=findViewById(R.id.toolbar_layout);
        collapsingToolbarLayout.setCollapsedTitleTypeface(tf);
        collapsingToolbarLayout.setExpandedTitleTypeface(tf);

        home = new Home();
        faq = new Faq();
        query = new Query();
        contact = new Contact();
        register = new Register();

        FloatingActionButton fab =  findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,InfoActivity.class);
                startActivity(intent);
            }
        });
        BottomBar bottomBar = findViewById(R.id.bottombar);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(int tabId) {

                switch (tabId){
                    case R.id.tab_home:replaceFragment(home);
                        break;
                    case R.id.tab_faq:replaceFragment(faq);
                        break;
                    case R.id.tab_query:replaceFragment(query);
                        break;
                    case R.id.tab_contact:replaceFragment(contact);
                        break;
                    case R.id.tab_register:replaceFragment(register);
                        break;
                    default:replaceFragment(home);
                }

            }
        });

    }

    private void replaceFragment(Fragment fragment){

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.layout,fragment);
        fragmentTransaction.commit();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity com.app.zine.zine AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.ws) {
            String url="http://www.zine.co.com.app.zine.zine";
            Intent i= new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        }
        else if(id==R.id.fb)
        {
            String url="https://www.facebook.com/ROBOTICS.ZINE/";
            Intent i= new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        }
        else if(id==R.id.insta)
        {
            String url="https://www.instagram.com/zine.robotics/";
            Intent i= new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

}
