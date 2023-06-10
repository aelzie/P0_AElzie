package com.revature.daos;

import com.revature.models.Album;

import java.lang.reflect.Array;

public interface AlbumDAOInterface
{
    ArrayList<Album> getAllAlbums();

    Album insertAlbum(Album alb)
}
