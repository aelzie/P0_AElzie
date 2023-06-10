package com.revature.daos;

import com.revature.models.Artist;
import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ArtistDAO implements ArtistDAOInterface
{

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
            System.out.println("error getting Role");
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
