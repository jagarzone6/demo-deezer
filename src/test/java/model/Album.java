package model;

import java.net.URL;
import java.util.Date;
import java.util.List;

public class Album {
    private Integer id;
    private String title;
    private String upc;
    private URL link;
    private URL share;
    private URL cover;
    private URL cover_small;
    private URL cover_medium;
    private URL cover_big;
    private URL cover_xl;
    private Integer genre_id;
    private List genres;
    private String label;
    private Integer nb_tracks;
    private Integer duration;
    private Integer fans;
    private Integer rating;
    private Date release_date;
    private String record_type;
    private Boolean available;
    private Object alternative;
    private URL tracklist;
    private Boolean explicit_lyrics;
    private List contributors;
    private Artist artist;
    private List<Track> tracks;


    public void setTitle(String title){
        this.title = title;
    }
    public String getTitle(){
        return title;
    }


}
