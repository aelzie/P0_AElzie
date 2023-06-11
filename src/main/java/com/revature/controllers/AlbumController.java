package com.revature.controllers;

import com.revature.models.Album;
import com.revature.service.AlbumService;
import io.javalin.http.Context;

import java.util.ArrayList;

public class AlbumController
{
    private final AlbumService albumService = new AlbumService();

    public void handleGetAll(Context ctx)
    {
        ArrayList<Album> albums = albumService.getAllAlbums();

        ctx.json(albums);
    }

    public void handleCreate(Context ctx)
    {
        Album albumToBeAdded = ctx.bodyAsClass(Album.class);
    }



    public void handleGetOne(Context ctx){
        ctx.status(405);
    }

    public void handleUpdate(Context ctx){
        ctx.status(405);
    }

    public void handleDelete(Context ctx){
        ctx.status(405);
        // Possible implementation activity
    }

}
