package com.revature.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.javalin.json.JsonMapper;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Type;

public class JavalinAppConfig
{

    Gson gson = new GsonBuilder().create();
    JsonMapper gsonMapper = new JsonMapper()
    {
        @NotNull
        @Override
        public <T> T fromJsonString(@NotNull String json, @NotNull Type targetType)
        {
            return JsonMapper.super.fromJsonString(json, targetType);
        }

        @NotNull
        @Override
        public String toJsonString(@NotNull Object obj, @NotNull Type type)
        {
            return JsonMapper.super.toJsonString(obj, type);
        }
    };


}
