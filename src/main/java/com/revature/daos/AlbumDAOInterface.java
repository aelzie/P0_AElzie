package com.revature.daos;

import com.revature.models.Album;

import java.util.ArrayList;

public interface AlbumDAOInterface
{
    ArrayList<Album> getAllAlbums();

    Album insertAlbum(Album alb);
}
