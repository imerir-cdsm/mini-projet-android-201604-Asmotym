package com.partiel_android_boucher.activities.fragment;


import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.partiel_android_boucher.R;
import com.partiel_android_boucher.classes.Artist;
import com.partiel_android_boucher.controllers.ArtistController;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class ArtistsFragment extends Fragment {
    private ListView artistsList;
    private Realm realm;
    ArrayList<Artist> artists;

    public  ArtistsFragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder(container.getContext()).build();
        realm = Realm.getInstance(realmConfiguration);

        return inflater.inflate(R.layout.tab_artists, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();

        artists = ArtistController.getAllArtists(getContext());

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                artistsList = (ListView) getView().findViewById(R.id.artistsList);
            }
        }, 2000);
    }
}
