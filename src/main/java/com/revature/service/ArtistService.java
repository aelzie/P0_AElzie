package com.revature.service;

import com.revature.daos.ArtistDAO;
import com.revature.daos.ArtistDAOInterface;
import com.revature.models.Artist;

public class ArtistService
{
    private final ArtistDAOInterface artistDAO = new ArtistDAO();

    public Artist getArtistById(int id)
    {
        if (id > 0)
        {
            return artistDAO.getArtistById(id);
        }
        return null;
    }
    public boolean updateArtist(String name)
    {
        if (name == null)
        {
            return false;
        }
        String formattedName = "";

        char[] nameArray = name.toCharArray();

        formattedName += Character.toUpperCase(nameArray[0]);

        for (int i = 1; i < nameArray.length; i++)
        {
            if (nameArray[i-1] == ' ')
            {
                formattedName += Character.toUpperCase(nameArray[i]);
            } else
            {
                formattedName += nameArray[i];
            }
        }
        return false;
    }

    public Object getAllArtists() {
        return artistDAO.getAllArtists();
    }
}
