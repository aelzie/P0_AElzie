package com.revature.controllers;

import com.revature.service.ArtistService;
import io.javalin.http.Context;

public class ArtistController
{
    private final ArtistService artistService = new ArtistService();



    public void handleGetAll(Context ctx)
    {
        ctx.status(405);
    }

    public void handleCreate(Context ctx){
        ctx.status(405);
    }

    public void handleDelete(Context ctx){
        ctx.status(405);

    }

}
