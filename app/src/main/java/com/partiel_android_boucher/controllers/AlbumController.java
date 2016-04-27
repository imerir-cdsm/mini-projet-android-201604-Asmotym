package com.partiel_android_boucher.controllers;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;
import com.partiel_android_boucher.classes.Album;
import com.partiel_android_boucher.tools.GlobalVariables;

import java.util.ArrayList;
import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class AlbumController {

    public static void getAllAlbums(Context _context){
        final ArrayList<Album> albums;
        String url = GlobalVariables.BASE_URL+GlobalVariables.ALBUMS_URI;
        System.out.println(url);
        AQuery aq = new AQuery(_context);
        aq.ajax(url, JSONArray.class, new AjaxCallback<JSONArray>(){
            @Override
            public void callback(String url, JSONArray json, AjaxStatus status) {
                System.out.println(json);
                try {

                } catch (JSONException jse){
                    jse.printStackTrace();
                }
            }
        });
    }

}
