package com.revature.controllers;

import com.revature.models.Album;
import com.revature.service.AlbumService;
import io.javalin.http.Context;

import static com.revature.utils.JavalinAppConfig.logger;

public class AlbumController
{
    private final AlbumService albumService = new AlbumService();

    public void handleGetAll(Context ctx)
    {
        try
        {
            ctx.json(albumService.getAllAlbums());
            ctx.status(200);
            logger.info("Returned from <handleGetAll> : ");
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new RuntimeException(e);
        }
}

    public void handleCreate(Context ctx)
    {
        Album album = ctx.bodyAsClass(Album.class);
        Album result = albumService.insertAlbum(album);

        if (result != null)
        {
            ctx.status(201);
            ctx.json(result);
        } else
        {
            ctx.status(400);
            logger.warn("<handleCreate> method failed (AlbumController)");
        }
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
