package com.revature.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.revature.controllers.AlbumController;
import com.revature.controllers.ArtistController;
import io.javalin.Javalin;
import io.javalin.json.JsonMapper;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Type;

import static io.javalin.apibuilder.ApiBuilder.*;

public class JavalinAppConfig
{

    Gson gson = new GsonBuilder().create();
    JsonMapper gsonMapper = new JsonMapper()
    {
        @NotNull
        @Override
        public <T> T fromJsonString(@NotNull String json, @NotNull Type targetType)
        {
            return gson.fromJson(json,targetType);
        }

        @NotNull
        @Override
        public String toJsonString(@NotNull Object obj, @NotNull Type type)
        {
            return gson.toJson(obj,type);
        }
    };
    private final AlbumController albumController = new AlbumController();
    private final ArtistController artistController = new ArtistController();

    public static final Logger logger = LoggerFactory.getLogger(JavalinAppConfig.class);

    private Javalin app = Javalin.create(config -> config.jsonMapper(gsonMapper))
            .before("/*", ctx -> {
                logger.info("{} request has been sent to {}", ctx.method(), ctx.fullUrl());
            })
            .routes(() -> {
                path("albums", () -> {
                    // Method referencing
                    get(albumController::handleGetAll);
                    post(albumController::handleCreate);
                    path("{id}", () ->{
                        put(albumController::handleUpdate);
                        delete(albumController::handleDelete);
                        get(albumController::handleGetOne);
                    });
                });
                path("artists", () -> {
                    // Method referencing
                    get(artistController::handleGetAll);
                    post(artistController::handleCreate);
                    path("{id}", () ->{
                        put(artistController::handleUpdate);
                        delete(artistController::handleDelete);
                        get(artistController::handleGetOne);
                    });
                });
            });

    public void start(int port){
        app.start(port);
    }
}
