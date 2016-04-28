package com.partiel_android_boucher.controllers;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;
import com.partiel_android_boucher.activities.fragment.ArtistsFragment;
import com.partiel_android_boucher.classes.Artist;
import com.partiel_android_boucher.classes.realm_classes.RealmArtist;
import com.partiel_android_boucher.classes.realm_classes.RealmGenre;
import com.partiel_android_boucher.tools.GlobalVariables;
import com.partiel_android_boucher.tools.RealmConfig;

import java.util.ArrayList;
import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import io.realm.Realm;


public class ArtistController {

    /**
     * Download all artists into Realm
     * @param _context
     */
    public static void downloadAllArtists(Context _context){
        String url = GlobalVariables.BASE_URL+GlobalVariables.ARTISTS;
        AQuery aq = new AQuery(_context);
        aq.ajax(url, JSONArray.class, new AjaxCallback<JSONArray>(){
            @Override
            public void callback(String url, JSONArray json, AjaxStatus status) {
                try {
                    for (int i = 0; i < json.length(); i++){
                        String object = json.getJSONObject(i).toString();
                        RealmArtist.creatObjectFromJson(RealmConfig.realm, object);
                    }
                } catch (JSONException jse){
                    jse.printStackTrace();
                }
            }
        });
    }
}
