package com.partiel_android_boucher.activities;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

import com.partiel_android_boucher.R;
import com.partiel_android_boucher.activities.fragment.AlbumsFragment;
import com.partiel_android_boucher.activities.fragment.ArtistsFragment;
import com.partiel_android_boucher.activities.fragment.GenresFragment;
import com.partiel_android_boucher.activities.pager_adapter.ViewPagerAdapter;
import com.partiel_android_boucher.classes.Album;
import com.partiel_android_boucher.classes.adapters.AlbumsAdapter;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmConfiguration;


public class MainActivity extends AppCompatActivity {
    ListView albumsList;
    Realm realm;
    ViewPager viewPager;
    FragmentPagerAdapter pagerAdapter;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.pager);
        setUpPager(viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setUpPager(ViewPager _viewPager){
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new AlbumsFragment(), "Albums");
        viewPagerAdapter.addFragment(new ArtistsFragment(), "Artists");
        viewPagerAdapter.addFragment(new GenresFragment(), "Genres");
        viewPager.setAdapter(viewPagerAdapter);
    }

}
