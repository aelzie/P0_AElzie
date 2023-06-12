package com.revature.models;

public class Album
{
    private int album_id;
    private String album_name;
    private String top_song;

    private Artist artist;

    private int artist_id_fk;


    public Album()
    {

    }

    public Album(int album_id, String album_name, String top_song, Artist artist)
    {
        this.album_id = album_id;
        this.album_name = album_name;
        this.top_song = top_song;
        this.artist = artist;
    }

    public Album(String album_name, String top_song, Artist artist)
    {
        this.album_name = album_name;
        this.top_song = top_song;
        this.artist = artist;
    }

    public Album(String album_name, String top_song, int artist_id_fk)
    {
        this.album_name = album_name;
        this.top_song = top_song;
        this.artist_id_fk = artist_id_fk;
    }

    public Album(int album_id, String album_name, String top_song, Artist artist, int artist_id_fk) {
        this.album_id = album_id;
        this.album_name = album_name;
        this.top_song = top_song;
        this.artist = artist;
        this.artist_id_fk = artist_id_fk;
    }

    public int getAlbum_id()
    {
        return album_id;
    }

    public void setAlbum_id(int album_id)
    {
        this.album_id = album_id;
    }

    public String getAlbum_name()
    {
        return album_name;
    }

    public void setAlbum_name(String album_name)
    {
        this.album_name = album_name;
    }

    public String getTop_song()
    {
        return top_song;
    }

    public void setTop_song(String top_song)
    {
        this.top_song = top_song;
    }

    public Artist getArtist()
    {
        return artist;
    }

    public void setArtist(Artist artist)
    {
        this.artist = artist;
    }

    public int getArtist_id_fk()
    {
        return artist_id_fk;
    }

    public void setArtist_id_fk(int artist_id_fk)
    {
        this.artist_id_fk = artist_id_fk;
    }

    @Override
    public String toString() {
        return "Album{" +
                "album_id=" + album_id +
                ", album_name='" + album_name + '\'' +
                ", top_song='" + top_song + '\'' +
                ", artist=" + artist +
                ", artist_id_fk=" + artist_id_fk +
                '}';
    }
}
