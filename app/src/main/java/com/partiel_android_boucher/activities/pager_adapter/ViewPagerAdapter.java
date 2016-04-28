package com.partiel_android_boucher.activities.pager_adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;


public class ViewPagerAdapter extends FragmentPagerAdapter {
    private static ArrayList<Fragment> fragmentsList;
    private static ArrayList<String> titlesList;

    public ViewPagerAdapter(FragmentManager fm){
        super(fm);
        fragmentsList = new ArrayList<>();
        titlesList = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return fragmentsList.size();
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentsList.get(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titlesList.get(position);
    }

    public void addFragment(Fragment _fragment, String _title){
        fragmentsList.add(_fragment);
        titlesList.add(_title);
    }
}
