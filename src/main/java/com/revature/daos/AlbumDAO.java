package com.revature.daos;

import com.revature.models.Album;
import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AlbumDAO implements AlbumDAOInterface
{

    @Override
    public ArrayList<Album> getAllAlbums()
    {
        try(Connection conn = ConnectionUtil.getConnection()) {

            ArrayList<Album> albums = new ArrayList<>();
            String sql = "SELECT * FROM albums";
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet resultSet = ps.executeQuery();

            AlbumDAO accountDAO = new AlbumDAO();
            ArtistDAO artistDAO = new ArtistDAO();

            while(resultSet.next()) {
                int albumId = resultSet.getInt("album_id");
                String albumName = resultSet.getString("album_name");
                String topSong = resultSet.getString("top_song");
                int artistId = resultSet.getInt("artist_id");


                Album album = new Album(albumId, albumName, topSong, artistDAO.getArtistById(artistId), artistId);
                albums.add(album);
            }

            return albums;

        } catch (SQLException e) {
            System.out.println("Get All Albums Failed");
            e.printStackTrace();
        }

        return new ArrayList<>();
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
