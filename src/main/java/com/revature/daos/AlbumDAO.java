package com.revature.daos;

import com.revature.models.Album;
import com.revature.utils.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;

public class AlbumDAO implements AlbumDAOInterface
{

    @Override
    public ArrayList<Album> getAllAlbums()
    {
        try(Connection conn = ConnectionUtil.getConnection())
        {
            String sql = "SELECT * FROM albums";

            Statement s = conn.createStatement();

            ResultSet rs = s.executeQuery(sql);

            ArrayList<Album> albumList = new ArrayList<>();

            ArtistDAO aDAO = new ArtistDAO();

            while(rs.next())
            {
                Album album = new Album(
                        rs.getInt("album_id"),
                        rs.getString("album_name"),
                        rs.getString("top_song"),
                        aDAO.getArtistById(rs.getInt("artist_id_fk"))
                );

                albumList.add(album);
            }
            return albumList;
        }
        catch(SQLException e)
        {
            System.out.println("Failed to get all albums");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Album insertAlbum(Album alb)
    {
        try(Connection conn = ConnectionUtil.getConnection())
        {
            String sql = "INSERT INTO albums (album_name, top_song, artist_id_fk) VALUES (?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, alb.getAlbum_name());
            ps.setString(2, alb.getTop_song());
            ps.setInt(3,alb.getArtist_id_fk());

            ps.executeUpdate();

            return alb;
        }
        catch(SQLException e)
        {
            System.out.println("Insert album failed!");
            e.printStackTrace();
        }

        return null;
    }
}
