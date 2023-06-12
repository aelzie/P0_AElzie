package com.revature.service;

import com.revature.daos.AlbumDAO;
import com.revature.daos.AlbumDAOInterface;
import com.revature.models.Album;

import java.util.ArrayList;

public class AlbumService
{
    private final AlbumDAOInterface accountDAO = new AlbumDAO();
    public ArrayList<Album> handleGetAllAccounts() {return accountDAO.getAllAlbums();}
    private final AlbumDAOInterface albumDAO = new AlbumDAO();

    public ArrayList<Album> getAllAlbums()
    {
        return albumDAO.getAllAlbums();
    }

    public Album insertAlbum(Album album)
    {
        return albumDAO.insertAlbum(album);
    }
}
