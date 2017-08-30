package model;

import java.net.URL;

public class Artist {
    private Integer id;
    private String name;
    private URL link;
    private URL share;
    private URL picture;
    private URL picture_small;
    private URL picture_medium;
    private URL picture_big;
    private URL picture_xl;
    private Integer nb_album;
    private Integer nb_fan;
    private Boolean radio;
    private URL tracklist;

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    
}
