package zine.co.in;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.LinkagePager;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import me.crosswall.lib.coverflow.CoverFlow;
import me.crosswall.lib.coverflow.core.LinkagePagerContainer;
import me.crosswall.lib.coverflow.core.PageItemClickListener;

public class Project extends AppCompatActivity {
    public static int[] covers = {R.mipmap.hand,R.mipmap.chair,R.mipmap.quad,R.mipmap.arm,R.mipmap.gait,R.mipmap.hci,R.mipmap.sun,R.mipmap.exo,R.mipmap.grid};


    private LinkagePager pager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.project);

        LinkagePagerContainer customPagerContainer = findViewById(R.id.pager_container);
        customPagerContainer.setPageItemClickListener(new PageItemClickListener() {
            @Override
            public void onItemClick(View view, int i) {
                pager.setCurrentItem(i);
            }
        });

        final LinkagePager cover = customPagerContainer.getViewPager();

        PagerAdapter coverAdapter = new MyPagerAdapter();
        cover.setAdapter(coverAdapter);
        cover.setOffscreenPageLimit(5);

        new CoverFlow.Builder()
                .withLinkage(cover)
                .pagerMargin(0f)
                .scale(0.3f)
                .spaceSize(0f)
                .build();

        pager =findViewById(R.id.pager);

        MyListPagerAdapter adapter = new MyListPagerAdapter();

        pager.setOffscreenPageLimit(covers.length);
        pager.setAdapter(adapter);

        cover.setLinkagePager(pager);
        pager.setLinkagePager(cover);
    }
    class MyListPagerAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            return covers.length;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {

            ProjectLoad view = new ProjectLoad(Project.this,position);
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((View)object);
        }


        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == object;
        }
    }

    private class MyPagerAdapter extends PagerAdapter {

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            ImageView imageView=new ImageView(Project.this);
            imageView.setImageDrawable(getResources().getDrawable(covers[position]));
            /*view.setText("Item "+position);
            view.setGravity(Gravity.CENTER);
            view.setBackgroundColor(Color.argb(255, position * 50, position * 10, position * 50));*/
            //imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            container.addView(imageView);
            return imageView;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((View)object);
        }

        @Override
        public int getCount() {
            return covers.length;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return (view == object);
        }
    }
}
