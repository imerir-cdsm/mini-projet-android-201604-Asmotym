package com.partiel_android_boucher.controllers;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;
import com.partiel_android_boucher.classes.Artist;
import com.partiel_android_boucher.classes.realm_classes.RealmArtist;
import com.partiel_android_boucher.tools.GlobalVariables;

import java.util.ArrayList;
import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import io.realm.Realm;


public class ArtistController {
    private static ArrayList<Artist> artists;

    public static ArrayList<Artist> getAllArtists(Context _context){
        artists = new ArrayList<>();
        String url = GlobalVariables.BASE_URL+GlobalVariables.ARTISTS;
        AQuery aq = new AQuery(_context);
        aq.ajax(url, JSONArray.class, new AjaxCallback<JSONArray>(){
            @Override
            public void callback(String url, JSONArray json, AjaxStatus status) {
                try {
                    for (int i = 0; i < json.length(); i++){
                        JSONObject object = json.getJSONObject(i);
                        int pid = object.getInt("pid");
                        String fname = object.getString("fname");
                        String lname = object.getString("lname");
                        String infoUrl = object.getString("infoUrl");
                        String photoUrl = object.getString("photoUrl");
                        Artist artist = new Artist(pid, fname, lname, infoUrl, photoUrl);
                        Realm realm = Realm.getDefaultInstance();
                        RealmArtist.copyToRealm(realm, artist);
                        artists.add(artist);
                    }
                } catch (JSONException jse){
                    jse.printStackTrace();
                }
            }
        });
        return artists;
    }
}
