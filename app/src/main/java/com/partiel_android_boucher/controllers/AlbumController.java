package com.partiel_android_boucher.controllers;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;
import com.partiel_android_boucher.classes.Album;
import com.partiel_android_boucher.classes.Artist;
import com.partiel_android_boucher.classes.realm_classes.RealmAlbum;
import com.partiel_android_boucher.classes.realm_classes.RealmArtist;
import com.partiel_android_boucher.tools.GlobalVariables;
import com.partiel_android_boucher.tools.RealmConfig;

import java.util.ArrayList;
import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import io.realm.Realm;
import io.realm.RealmConfiguration;


public class AlbumController {

    public static void downloadAllAlbums(Context _context){
        String url = GlobalVariables.BASE_URL+GlobalVariables.ALBUMS_URI;
        AQuery aq = new AQuery(_context);
        aq.ajax(url, JSONArray.class, new AjaxCallback<JSONArray>(){

            @Override
            public void callback(String url, JSONArray json, AjaxStatus status) {
                try {
                    for (int i = 0; i < json.length(); i++){
                        String object = json.getJSONObject(i).toString();
                        RealmAlbum.creatObjectFromJson(RealmConfig.realm, object);
                    }
                } catch (JSONException jse){
                    jse.printStackTrace();
                }
            }
        });
    }

    public static void downloadArtistByPid(Context _context, int _pid){
        String url = GlobalVariables.BASE_URL+GlobalVariables.ARTISTS_PID+_pid;
        AQuery aq = new AQuery(_context);
        aq.ajax(url, JSONObject.class, new AjaxCallback<JSONObject>(){
            @Override
            public void callback(String url, JSONObject json, AjaxStatus status) {
                String object = json.toString();
                RealmArtist.creatObjectFromJson(RealmConfig.realm, object);
            }
        });
    }

}
