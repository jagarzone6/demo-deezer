package model;

import java.net.URL;

public class Track {
    private Integer id;
    private Boolean readable;
    private String title;
    private String title_short;
    private String title_version;
    private URL link;
    private Integer duration;
    private Integer rank;
    private Boolean explicit_lyrics;
    private URL preview;
    private Artist artist;
    private Album album;


    public void setId(Integer id){
        this.id = id;
    }
    public Integer getId(){
        return id;
    }

    public void setTitle(String title){
        this.title = title;
    }
    public String getTitle(){
        return title;
    }

    public void setAlbum(Album album){this.album = album;}
    public Album getAlbum() {return  album;}

    public void setArtist(Artist artist){this.artist = artist;}
    public Artist getArtist() {return  artist;}

}
