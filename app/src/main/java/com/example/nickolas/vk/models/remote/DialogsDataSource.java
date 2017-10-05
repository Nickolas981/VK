package com.example.nickolas.vk.models.remote;

import com.example.nickolas.vk.api.VkApi;

import okhttp3.ResponseBody;
import rx.Observable;

/**
 * Created by Nickolas on 01.10.2017.
 */

public class DialogsDataSource implements IDialogsDataSource {

    private VkApi api;

    public DialogsDataSource(VkApi api){
        this.api = api;
    }

    @Override
    public Observable<ResponseBody> getDialogs(int offset, String token) {
        return api.getDialogs(offset, token, "5.68");
    }
}
