package com.example.nickolas.vk.models.remote;

import android.app.Dialog;

import com.example.nickolas.vk.api.VkApi;
import com.vk.sdk.api.VKApi;

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
    public Observable<ResponseBody> getDialogs(int count, int offset) {
        return api.getDialogs(offset, count);
    }
}
