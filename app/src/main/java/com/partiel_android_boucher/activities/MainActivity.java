package com.partiel_android_boucher.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

import com.partiel_android_boucher.R;
import com.partiel_android_boucher.classes.realm_classes.RealmAlbum;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SetUpTabBar();
    }

    private void SetUpTabBar(){
        TabHost tabHost = (TabHost) findViewById(R.id.tabHost);
        tabHost.setup();

        TabSpec tabAlbums = tabHost.newTabSpec("Albums");
        tabAlbums.setContent(R.id.tabAlbums);
        tabAlbums.setIndicator("Albums");

        TabSpec tabArtists = tabHost.newTabSpec("Artists");
        tabArtists.setIndicator("Artists");
        tabArtists.setContent(R.id.tabArtists);

        TabSpec tabGenres = tabHost.newTabSpec("Genres");
        tabGenres.setIndicator("Genres");
        tabGenres.setContent(R.id.tabGenres);

        tabHost.addTab(tabAlbums);
        tabHost.addTab(tabArtists);
        tabHost.addTab(tabGenres);
    }
}
