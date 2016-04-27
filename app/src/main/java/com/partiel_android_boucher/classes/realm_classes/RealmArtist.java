package com.partiel_android_boucher.classes.realm_classes;

import com.partiel_android_boucher.classes.Artist;

import io.realm.Realm;

/**
 * Created by boucherclement on 27/04/16.
 */
public class RealmArtist {

    public static void copyToRealm(Realm _realm, Artist _artist){
        _realm.beginTransaction();
        _realm.copyToRealm(_artist);
        _realm.commitTransaction();
    }

    public static void creatObjectFromJson(Realm _realm, String _json){
        _realm.beginTransaction();
        _realm.createObjectFromJson(Artist.class, _json);
        _realm.commitTransaction();
    }

}
