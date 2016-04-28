package com.partiel_android_boucher.classes;

import io.realm.RealmObject;

/**
 * Created by boucherclement on 27/04/16.
 */
public class Genre extends RealmObject {
    private int gid;
    private String name;

    public Genre(){

    }

    public Genre(int _gid, String _name){
        setGid(_gid);
        setName(_name);
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
