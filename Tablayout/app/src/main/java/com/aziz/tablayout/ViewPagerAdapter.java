package com.aziz.tablayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {


    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if(position==0){
            return new chatFragment();
        }
        if(position==1){
            return new StatusFragment();
        }
        return new CallFragment();

    }

    @Override
    public int getCount() {

        return 3;   //return number of fragement
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if(position==0){
            return "Chat";
        }
       if (position==1){
           return "Status";
       }
       return "Call";
    }
}
