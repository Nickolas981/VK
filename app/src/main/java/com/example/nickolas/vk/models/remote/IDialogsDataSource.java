package com.example.nickolas.vk.models.remote;

import com.vk.sdk.api.VKResponse;

import rx.Observable;

/**
 * Created by Nickolas on 01.10.2017.
 */

public interface IDialogsDataSource {

    Observable<VKResponse> getDialogs(int count, int offset, String tokken);
}
