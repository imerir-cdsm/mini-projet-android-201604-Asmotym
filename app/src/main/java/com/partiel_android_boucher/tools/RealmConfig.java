package com.partiel_android_boucher.tools;

import io.realm.RealmConfiguration;
import io.realm.Realm;
import android.content.Context;

/**
 * Created by boucherclement on 28/04/16.
 */
public class RealmConfig {
    public static RealmConfiguration realmConfiguration;
    public static Realm realm;

    public static void configure(Context _context){
        realmConfiguration = new RealmConfiguration.Builder(_context).deleteRealmIfMigrationNeeded().build();
        Realm.setDefaultConfiguration(realmConfiguration);
        realm = Realm.getDefaultInstance();
    }
}
