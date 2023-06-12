package com.revature.daos;

import com.revature.models.Artist;
import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ArtistDAO implements ArtistDAOInterface
{
    public ArrayList<Artist> getAllArtists() {
        ArrayList<Artist> artists = new ArrayList<>();

        try(Connection conn = ConnectionUtil.getConnection()) {

            String sql = "SELECT * FROM artists";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();

            while(resultSet.next()) {
                int artistId = resultSet.getInt("artist_id");
                String artistName = resultSet.getString("artist_name");

                Artist artist = new Artist(artistId, artistName);
                artists.add(artist);
            }
            return artists;

        } catch(SQLException e) {
            System.out.println("Get All Artists Failed");
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    @Override
    public Artist getArtistById(int id)
    {
        try(Connection conn = ConnectionUtil.getConnection())
        {
            String sql = "SELECT * FROM artists WHERE artist_id = ?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if(rs.next())
            {
                Artist artist = new Artist(
                        rs.getInt("artist_id"),
                        rs.getString("artist_name")
                );

                return artist;
            }
        }
        catch(SQLException e)
        {
            System.out.println("Get By Id Failed");
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean updateArtist(String artist_name)
    {
        try(Connection conn = ConnectionUtil.getConnection())
        {
            String sql = "UPDATE artist SET artist_name = ?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, artist_name);

            ps.executeUpdate();

            return true;
        }
        catch(SQLException e)
        {
            System.out.println("Update failed!");
            e.printStackTrace();
        }

        return false;
    }
}
