package com.example.user.firebase_database_save;

public class artisty {

    String artistid;
    String artistname;
    String artistgenre;


    public artisty(){


    }

    public artisty(String artistid, String artistname, String artistgenre) {
        this.artistid = artistid;
        this.artistname = artistname;
        this.artistgenre = artistgenre;
    }

    public String getArtistid() {
        return artistid;
    }

    public String getArtistname() {
        return artistname;
    }

    public String getArtistgenre() {
        return artistgenre;
    }
}
