package com.example.nickolas.vk.views;

import com.vk.sdk.api.model.VKApiDialog;

import java.util.List;

import okhttp3.ResponseBody;
import rx.Observable;

public interface DialogsView extends BaseView {

    Observable<ResponseBody> showDialogs(List<VKApiDialog> dialogs);

}
