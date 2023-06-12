package com.revature.controllers;

import com.revature.service.ArtistService;
import io.javalin.http.Context;
import org.jetbrains.annotations.NotNull;

import static com.revature.utils.JavalinAppConfig.logger;

public class ArtistController
{
    private final ArtistService artistService = new ArtistService();



    public void handleGetAll(Context ctx)
    {
        ctx.json(artistService.getAllArtists());
        ctx.status(200);
        logger.info("Returned from <handleGetAll> : ");
    }


    public void handleCreate(Context ctx){
        ctx.status(405);
    }

    public void handleDelete(Context ctx)
    {
        ctx.status(405);

    }

    public void handleUpdate(@NotNull Context context)
    {
        //456
    }

    public void handleGetOne(@NotNull Context context)
    {
        //4156
    }
}
