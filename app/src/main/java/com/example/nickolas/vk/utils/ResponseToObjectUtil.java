package com.example.nickolas.vk.utils;

import com.example.nickolas.vk.models.enteties.Dialog;
import com.example.nickolas.vk.models.enteties.Message;
import com.example.nickolas.vk.models.enteties.User;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import okhttp3.ResponseBody;

/**
 * Created by Nickolas on 05.10.2017.
 */

public class ResponseToObjectUtil {

    public static List<Dialog> parseToDialogList(ResponseBody response) {
        String res = null;
        List<Dialog> dialogs;
        try {
            res = response.string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        JsonParser parser = new JsonParser();
        JsonArray r = parser.parse(res).getAsJsonObject()
                .getAsJsonObject("response").getAsJsonArray("items");
        Type listType = new TypeToken<List<Dialog>>() {
        }.getType();
        dialogs = new Gson().fromJson(r, listType);
        return dialogs;
    }

    public static List<User> parseToUserList(ResponseBody response) throws IOException {
        String res = null;
        List<User> users;
        res = response.string();
        JsonParser parser = new JsonParser();
        JsonArray r = parser.parse(res).getAsJsonObject().getAsJsonArray("response");
        Type listType = new TypeToken<List<User>>() {
        }.getType();
        users = new Gson().fromJson(r, listType);
        return users;
    }

    public static List<Message> parseToMessageList(ResponseBody response) throws IOException {
        String res = response.string();
        List<Message> messages;
        JsonParser parser = new JsonParser();
        JsonArray r = parser.parse(res).getAsJsonObject()
                .getAsJsonObject("response").getAsJsonArray("items");
        Type listType = new TypeToken<List<Message>>() {
        }.getType();
        messages = new Gson().fromJson(r, listType);
        return messages;
    }

}
