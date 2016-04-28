package com.partiel_android_boucher.controllers;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;
import com.partiel_android_boucher.classes.realm_classes.RealmTrack;
import com.partiel_android_boucher.tools.GlobalVariables;
import com.partiel_android_boucher.tools.RealmConfig;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;

public class TrackController {

    /**
     * Download all track with album id into Realm
     * @param _context
     * @param _aid
     */
    public static void downloadTracksWithAid(Context _context, int _aid) {
        String url = GlobalVariables.BASE_URL + GlobalVariables.ALBUMS_URI + "/" + _aid + GlobalVariables.TRACKS_URI;
        AQuery aq = new AQuery(_context);
        aq.ajax(url, JSONArray.class, new AjaxCallback<JSONArray>(){
            @Override
            public void callback(String url, JSONArray json, AjaxStatus status) {
                try {
                    
                    for (int i = 0; i < json.length(); i++) {
                        String object = json.getJSONObject(i).toString();
                        RealmTrack.createObjectFromJson(RealmConfig.realm, object);
                    }
                } catch (JSONException jse) {
                    jse.printStackTrace();
                }
            }
        });
    }

}
