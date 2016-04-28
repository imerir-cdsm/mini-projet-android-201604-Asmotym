package com.partiel_android_boucher.activities.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.partiel_android_boucher.R;
import com.partiel_android_boucher.activities.AlbumDetailsActivity;
import com.partiel_android_boucher.activities.MainActivity;
import com.partiel_android_boucher.classes.Album;
import com.partiel_android_boucher.classes.adapters.AlbumsAdapter;
import com.partiel_android_boucher.classes.realm_classes.RealmAlbum;
import com.partiel_android_boucher.classes.realm_classes.RealmArtist;
import com.partiel_android_boucher.controllers.AlbumController;
import com.partiel_android_boucher.tools.GlobalVariables;
import com.partiel_android_boucher.tools.RealmConfig;

import java.util.ArrayList;

import android.os.Handler;
import android.widget.Toast;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class AlbumsFragment extends Fragment {
    private static ListView albumsList;
    private ArrayList<Album> albums;
    private static View view;

    public AlbumsFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AlbumController.downloadAllAlbums(getContext());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tab_albums, container, false);
    }

    public void onResume() {
        super.onResume();
        view = getView();
        setUpAdapter(RealmAlbum.getAllAlbum(RealmConfig.realm));
    }

    public static void setUpAdapter(ArrayList<Album> _albums) {
        albumsList = (ListView) view.findViewById(R.id.albumsList);
        AlbumsAdapter albumsAdapter = new AlbumsAdapter(view.getContext(), _albums);
        albumsList.setAdapter(albumsAdapter);
        albumsList.setOnItemClickListener(new OnAlbumItemClickListener(albumsAdapter));
    }


}

class OnAlbumItemClickListener implements ListView.OnItemClickListener {
    private AlbumsAdapter albumsAdapter;

    public OnAlbumItemClickListener(AlbumsAdapter _albumsAdapter) {
        this.albumsAdapter = _albumsAdapter;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Album album = (Album) albumsAdapter.getItem(position);
        Toast.makeText(view.getContext(), album.getTitle(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(view.getContext(), AlbumDetailsActivity.class);
        intent.putExtra("aid", album.getAid());
        view.getContext().startActivity(intent);
    }

}