package com.partiel_android_boucher.activities.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.partiel_android_boucher.R;
import com.partiel_android_boucher.activities.MainActivity;
import com.partiel_android_boucher.classes.Album;
import com.partiel_android_boucher.classes.adapters.AlbumsAdapter;
import com.partiel_android_boucher.controllers.AlbumController;

import java.util.ArrayList;
import android.os.Handler;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class AlbumsFragment extends Fragment {
    private ListView albumsList;
    private Realm realm;
    private ArrayList<Album> albums;

    public AlbumsFragment(){

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

        return inflater.inflate(R.layout.tab_albums, container, false);
    }

    public void onResume(){
        super.onResume();

        albums = AlbumController.getAllAlbums(getContext());

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                albumsList = (ListView) getView().findViewById(R.id.albumsList);
                AlbumsAdapter albumsAdapter = new AlbumsAdapter(getView().getContext(), realm, albums);
                albumsList.setAdapter(albumsAdapter);
            }
        }, 2000);
    }
}