package com.example.nickolas.vk.models.remote;

import okhttp3.ResponseBody;
import rx.Observable;

/**
 * Created by Nickolas on 01.10.2017.
 */

public interface IDialogsDataSource {

    Observable<ResponseBody> getDialogs(int offset, String tokken);
}
