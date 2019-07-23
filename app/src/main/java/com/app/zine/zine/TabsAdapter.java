package com.app.zine.zine;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class TabsAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;
    public TabsAdapter(FragmentManager fm, int NoofTabs){
        super(fm);
        this.mNumOfTabs = NoofTabs;
    }
    @Override
    public int getCount() {
        return mNumOfTabs;
    }
    @Override
    public Fragment getItem(int position){
        switch (position){
            case 0:
                SecondYear second = new SecondYear();
                return second;
            case 1:
                ThirdYear third = new ThirdYear();
                return third;
            case 2:
                FourthYear fourth = new FourthYear();
                return fourth;
            default:
                return null;
        }
    }
}