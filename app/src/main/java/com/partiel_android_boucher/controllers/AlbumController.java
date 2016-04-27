package com.partiel_android_boucher.controllers;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;
import com.partiel_android_boucher.classes.Album;
import com.partiel_android_boucher.classes.Artist;
import com.partiel_android_boucher.classes.realm_classes.RealmAlbum;
import com.partiel_android_boucher.classes.realm_classes.RealmArtist;
import com.partiel_android_boucher.tools.GlobalVariables;

import java.util.ArrayList;
import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import io.realm.Realm;
import io.realm.RealmConfiguration;


public class AlbumController {
    private static ArrayList<Album> albums;
    private static Artist artist;

    public static ArrayList<Album> getAllAlbums(Context _context){
        albums = new ArrayList<>();
        String url = GlobalVariables.BASE_URL+GlobalVariables.ALBUMS_URI;
        AQuery aq = new AQuery(_context);
        aq.ajax(url, JSONArray.class, new AjaxCallback<JSONArray>(){

            @Override
            public void callback(String url, JSONArray json, AjaxStatus status) {
                try {
                    for (int i = 0; i < json.length(); i++){
                        JSONObject object = json.getJSONObject(i);
                        int aid = object.getInt("aid");
                        String title = object.getString("title");
                        int artist = object.getInt("artist");
                        int genre = object.getInt("genre");
                        String photoUrl = object.getString("photoUrl");
                        Album album = new Album(aid, title, artist, genre, photoUrl);
                        AlbumController.albums.add(album);
                        Realm realm = Realm.getDefaultInstance();
                        RealmAlbum.copyToRealm(realm, album);
                    }
                } catch (JSONException jse){
                    jse.printStackTrace();
                }
            }
        });
        return albums;
    }

    public static Artist getArtistByPid(Context _context, int _pid){
        String url = GlobalVariables.BASE_URL+GlobalVariables.ARTISTS_PID+_pid;
        AQuery aq = new AQuery(_context);
        aq.ajax(url, JSONObject.class, new AjaxCallback<JSONObject>(){
            @Override
            public void callback(String url, JSONObject json, AjaxStatus status) {
                try {
                    int pid = json.getInt("pid");
                    String fname = json.getString("fname");
                    String lname = json.getString("lname");
                    String infoUrl = json.getString("infoUrl");
                    String photoUrl = json.getString("photoUrl");
                    artist = new Artist(pid, fname, lname, infoUrl, photoUrl);
                    Realm realm = Realm.getDefaultInstance();
                    RealmArtist.copyToRealm(realm, artist);
                } catch (JSONException jse) {
                    jse.printStackTrace();
                }
            }
        });
        return artist;
    }

}
