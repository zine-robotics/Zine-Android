package zine.co.in;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Objects;

public class InfoActivity extends AppCompatActivity {

    static String[] s={
            "Zine is the robotics and research group of Malaviya National Institute of Technology, Jaipur with a motive to foster undergraduate students and provide them with a platform to learn, explore and bring their imaginations to life. Under the guidance of our mentor  Dr. Rajesh Kumar, HoD, Electrical engineering department, the group is motivated to improve and apply the technical skills of individuals to solve contemporary problems and foster the growth of the society and hence the nation in the field of technology. It has been one of the most active robotics and research group of MNIT since 2006. Since then our alumni have been our mentors and have provided constant support, irrespective of the fact that they are currently working in different firms and research projects in different parts of world. Zine has always added to its glory by participating and achieving in various national and international events, doing core research works and publishing research articles in reputed publications like IEEE journals etc.",
            "Dr. Rajesh Kumar received the Bachelor of Technology in Engineering degree with honors in Electrical Engineering, National Institute of Technology, Kurukshetra, India in 1994, Master of Engineering with honors in Power Engineering from  the Department of Electrical Engineering, Malaviya National Institute of Technology, Jaipur. India in 1997 and Ph.D. degree in Intelligent Systems from the University of Rajasthan, India in 2005. He is currently HOD of Electrical Department at Malaviya National Institute of Technology, Jaipur, India. He has been Research Fellow (A) at the Department of Electrical Engineering at National University of Singapore from 2009-2011. He has been Reader from 2005-2009, Senior Lecturer from 2000-2005 and Lecturer from 1995-2000 at Department of Electrical Engineering, Malaviya National National Institute of Technology. He  is the founder of ZINE student innovative group. His background is in the fields of Computational Intelligence, Artificial Intelligence, Power Engineering, Energy Harvesting and Management, Control Theory, Robotics, Automation, Bioinformatics."
    };
    static String[] s1={
            "Welcome To ZINE",
            "Dr. Rajesh Kumar"
    };
    static int[] i={
            R.drawable.logo,
            R.drawable.rajesh_sir

    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        SectionsPagerAdapter mSectionsPagerAdapter;
        ViewPager mViewPager;

        Toolbar toolbar =findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager = findViewById(R.id.container);

        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout =  findViewById(R.id.tabs);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));


    }




    public static class PlaceholderFragment extends Fragment {
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_info, container, false);
            TextView textView =  rootView.findViewById(R.id.section_label);
            TextView textView1=rootView.findViewById(R.id.info1);
            final ImageView imageView = rootView.findViewById(R.id.imageView);


            ValueAnimator animator= ValueAnimator.ofInt(0,255);
            animator.setDuration(1000);
            animator.setInterpolator(new DecelerateInterpolator());
            animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    imageView.setImageAlpha((int)animation.getAnimatedValue());
                }
            });

            assert getArguments() != null;
            imageView.setImageResource(i[(getArguments().getInt(ARG_SECTION_NUMBER))]);
            animator.start();
            textView1.setText(s1[(getArguments().getInt(ARG_SECTION_NUMBER))]);
            textView.setText(s[(getArguments().getInt(ARG_SECTION_NUMBER))]);
            return rootView;
        }
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return PlaceholderFragment.newInstance(position);
        }

        @Override
        public int getCount() {
            return 2;
        }
    }
}
