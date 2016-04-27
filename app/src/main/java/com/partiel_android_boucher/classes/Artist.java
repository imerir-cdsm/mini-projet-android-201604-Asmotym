package com.partiel_android_boucher.classes;

import io.realm.RealmObject;

/**
 * Created by boucherclement on 27/04/16.
 */
public class Artist extends RealmObject {
    private int pid;
    private String fname;
    private String lname;
    private String infoUrl;
    private String photoUrl;

    public Artist(){

    }

    public Artist(int _pid, String _fname, String _lname, String _infoUrl, String _photoUrl){
        setPid(_pid);
        setFname(_fname);
        setLname(_lname);
        setInfoUrl(_infoUrl);
        setPhotoUrl(_photoUrl);
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getInfoUrl() {
        return infoUrl;
    }

    public void setInfoUrl(String infoUrl) {
        this.infoUrl = infoUrl;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}
