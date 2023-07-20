package com.example.wedates;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.wedates.Fragments.Calls;
import com.example.wedates.Fragments.Chats;
import com.example.wedates.Fragments.Gruops;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if(position==0){
            return new Chats();
        }
        else if(position==1){
            return  new Calls();
        }
        return new Gruops();
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if(position==0){
            return "Chat";
        }else if(position==1){
            return "Call";
        }
        return "Group";
    }
}
