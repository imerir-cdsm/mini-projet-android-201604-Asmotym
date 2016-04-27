package com.partiel_android_boucher.classes.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.partiel_android_boucher.R;
import com.partiel_android_boucher.classes.Album;
import com.partiel_android_boucher.classes.realm_classes.RealmAlbum;

import org.json.JSONObject;

import java.util.ArrayList;

import io.realm.Realm;

/**
 * Created by boucherclement on 27/04/16.
 */
public class AlbumsAdapter extends BaseAdapter {
    LayoutInflater layoutInflater;
    ArrayList<Album> albums;
    Context context;
    AQuery aq;
    AjaxCallback<JSONObject> cb;
    Realm realm;

    public AlbumsAdapter(Context _context, Realm _realm, ArrayList<Album> _albums){
        this.context = _context;
        this.albums = _albums;
        this.realm = _realm;
    }

    @Override
    public int getCount() {
        return albums.size();
    }

    @Override
    public long getItemId(int position) {
        return albums.get(position).getAid();
    }

    @Override
    public Object getItem(int position) {
        return albums.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            viewHolder = new ViewHolder();

            viewHolder.albumImage = (ImageView) convertView.findViewById(R.id.albumImage);
            viewHolder.titleAlbum = (TextView) convertView.findViewById(R.id.albumTitle);
            viewHolder.artistAlbum = (TextView) convertView.findViewById(R.id.albumArtist);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Album album = albums.get(position);

        viewHolder.titleAlbum.setText(album.getTitle());
        viewHolder.artistAlbum.setText(RealmAlbum.getAlbumArtist(realm, album.getArtist()));

        return convertView;
    }

    public class ViewHolder {
        public ImageView albumImage;
        public TextView titleAlbum;
        public TextView artistAlbum;
    }
}
