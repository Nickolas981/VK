package com.example.nickolas.vk.views;

import com.vk.sdk.api.model.VKApiDialog;

import java.util.List;

public interface DialogsView extends BaseView {

    void showDialogs(List<VKApiDialog> dialogs);

}
