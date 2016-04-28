package com.partiel_android_boucher.controllers;

import android.content.Context;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;
import com.partiel_android_boucher.activities.fragment.GenresFragment;
import com.partiel_android_boucher.classes.realm_classes.RealmGenre;
import com.partiel_android_boucher.tools.GlobalVariables;
import com.partiel_android_boucher.tools.RealmConfig;

import org.json.JSONArray;
import org.json.JSONException;

/**
 * Created by boucherclement on 28/04/16.
 */
public class GenreController {

    public static void downloadAllGenres(Context _context) {
        String url = GlobalVariables.BASE_URL + GlobalVariables.GENRES_URI;
        AQuery aq = new AQuery(_context);
        aq.ajax(url, JSONArray.class, new AjaxCallback<JSONArray>(){
            @Override
            public void callback(String url, JSONArray json, AjaxStatus status) {
                try {
                    for (int i = 0; i < json.length(); i++) {
                        String object = json.getJSONObject(i).toString();
                        RealmGenre.creatObjectFromJson(RealmConfig.realm, object);
                    }
                } catch (JSONException jse){
                    jse.printStackTrace();
                }
                GenresFragment.setUpAdapter(RealmGenre.getAllGenre(RealmConfig.realm));
            }
        });
    }

}
