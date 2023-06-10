package com.revature.daos;

import com.revature.models.Artist;

public interface ArtistDAOInterface
{
    Artist getArtistById(int id);

    boolean updateArtist(String artist_name);
}
