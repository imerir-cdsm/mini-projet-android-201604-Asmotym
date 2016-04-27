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
    private static ArrayList<Album> albums;

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
                        System.out.println(i+" : "+object.toString());
                        int aid = object.getInt("aid");
                        String title = object.getString("title");
                        int artist = object.getInt("artist");
                        int genre = object.getInt("genre");
                        String photoUrl = object.getString("photoUrl");
                        AlbumController.albums.add(new Album(aid, title, artist, genre, photoUrl));
                    }
                } catch (JSONException jse){
                    jse.printStackTrace();
                }
            }
        });
        return albums;
    }

}
