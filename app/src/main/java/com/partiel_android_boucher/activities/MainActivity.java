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
import com.partiel_android_boucher.classes.realm_classes.RealmAlbum;
import com.partiel_android_boucher.classes.realm_classes.RealmArtist;
import com.partiel_android_boucher.classes.realm_classes.RealmGenre;
import com.partiel_android_boucher.tools.RealmConfig;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmConfiguration;


public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.pager);
        setUpPager(viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);

        RealmConfig.configure(MainActivity.this);
        /*RealmAlbum.clearAlbums(RealmConfig.realm);
        RealmArtist.clearArtist(RealmConfig.realm);
        RealmGenre.clearGenre(RealmConfig.realm);*/
    }

    private void setUpPager(ViewPager _viewPager){
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new AlbumsFragment(), "Albums");
        viewPagerAdapter.addFragment(new ArtistsFragment(), "Artists");
        viewPagerAdapter.addFragment(new GenresFragment(), "Genres");
        viewPager.setAdapter(viewPagerAdapter);
    }

}
