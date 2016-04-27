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

        layoutInflater = LayoutInflater.from(_context);
    }

    @Override
    public int getCount() {
        return albums.size();
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return albums.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.tab_albums_item, parent, false);
        }
        Album album = albums.get(position);

        ImageView albumImage = (ImageView) convertView.findViewById(R.id.albumImage);
        TextView title = (TextView) convertView.findViewById(R.id.albumTitle);
        TextView artist = (TextView) convertView.findViewById(R.id.albumArtist);

        //TODO Load image
        title.setText(album.getTitle());
        //TODO Get real artist name

        return convertView;
    }

    public class ViewHolder {
        public ImageView albumImage;
        public TextView titleAlbum;
        public TextView artistAlbum;
    }
}
