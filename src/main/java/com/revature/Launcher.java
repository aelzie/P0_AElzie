package com.revature;

import com.revature.daos.AlbumDAO;
import com.revature.daos.ArtistDAO;
import com.revature.models.Album;
import com.revature.utils.ConnectionUtil;
import com.revature.utils.JavalinAppConfig;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class Launcher
{
    public static void main(String[] args)
    {
        try(Connection conn = ConnectionUtil.getConnection())
        {
                System.out.println("Connection Success");
        }
        catch(SQLException e)
        {
            System.out.println("Connection Failed");
        }

        ArtistDAO aDAO = new ArtistDAO();

        System.out.println(aDAO.getArtistById(2));

        AlbumDAO albumDAO = new AlbumDAO();

        ArrayList<Album> albumArrayList = albumDAO.getAllAlbums();

        for(Album a : albumArrayList)
        {
            System.out.println(a);
        }

        JavalinAppConfig app = new JavalinAppConfig();

        app.start(7070);
    }
}
