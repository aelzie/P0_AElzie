package com.revature.daos;

import com.revature.models.Artist;

import java.util.ArrayList;

public interface ArtistDAOInterface
{
    Artist getArtistById(int id);

    boolean updateArtist(String artist_name);

    ArrayList<Artist> getAllArtists();
}

