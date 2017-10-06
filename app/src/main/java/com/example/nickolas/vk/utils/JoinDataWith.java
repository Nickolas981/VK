package com.example.nickolas.vk.utils;

import com.example.nickolas.vk.models.enteties.Dialog;

import java.util.List;

import okhttp3.ResponseBody;

/**
 * Created by Nickolas on 06.10.2017.
 */

public class JoinDataWith {

    public static List<Dialog> dataWithDialogs(ResponseBody data, List<Dialog> dialogs) {
        return dialogs;
    }

}
