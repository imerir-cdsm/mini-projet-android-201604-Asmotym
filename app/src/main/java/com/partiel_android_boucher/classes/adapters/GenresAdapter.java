package com.partiel_android_boucher.classes.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.content.Context;
import android.widget.TextView;

import com.partiel_android_boucher.R;
import com.partiel_android_boucher.classes.Genre;
import com.partiel_android_boucher.classes.realm_classes.RealmAlbum;
import com.partiel_android_boucher.classes.realm_classes.RealmGenre;
import com.partiel_android_boucher.controllers.AlbumController;
import com.partiel_android_boucher.tools.RealmConfig;

import java.util.ArrayList;


/**
 * Created by boucherclement on 28/04/16.
 */
public class GenresAdapter extends BaseAdapter {
    LayoutInflater layoutInflater;
    Context context;
    ArrayList<Genre> genres;

    public GenresAdapter(Context _context, ArrayList<Genre> _genres) {
        this.context = _context;
        this.genres = _genres;

        layoutInflater = LayoutInflater.from(_context);
    }

    @Override
    public int getCount() {
        return genres.size();
    }

    @Override
    public Object getItem(int position) {
        return genres.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.tab_genres_item, parent, false);
        }

        TextView genreName = (TextView) convertView.findViewById(R.id.genresName);
        TextView genreNbAlbums = (TextView) convertView.findViewById(R.id.genresNbAlbums);

        Genre genre = genres.get(position);

        genreName.setText(genre.getName());
        if (RealmAlbum.getAllAlbum(RealmConfig.realm).size() == 0) {
            RealmAlbum.clearAlbums(RealmConfig.realm);
            AlbumController.downloadAllAlbums(this.context);
        }
        int nbAlbums = RealmGenre.getNbAlbumsByGenre(RealmConfig.realm, genre.getGid());
        if (nbAlbums < 2) {
            genreNbAlbums.setText(nbAlbums + " Album");
        } else {
            genreNbAlbums.setText(nbAlbums + " Albums");
        }


        return convertView;
    }
}
