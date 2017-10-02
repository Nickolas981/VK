package com.example.nickolas.vk.presenters;

import com.example.nickolas.vk.models.remote.IDialogsDataSource;
import com.example.nickolas.vk.utils.rx.RxRetryWithDelay;
import com.example.nickolas.vk.views.DialogsView;
import com.vk.sdk.api.model.VKApiDialog;
import com.vk.sdk.api.model.VKApiGetDialogResponse;

import java.util.List;

import rx.schedulers.Schedulers;


public class DialogsPresenter extends BasePresenter<DialogsView> {

    private final IDialogsDataSource dialogsDataSource;

    public DialogsPresenter(IDialogsDataSource dialogsDataSource) {
        this.dialogsDataSource = dialogsDataSource;
    }

    public void getDialogs(int limit, int offset, String tokken) {
        subscribe(dialogsDataSource.getDialogs(limit, offset, tokken)
                .retryWhen(new RxRetryWithDelay())
                .map(response -> {
                    List<VKApiDialog> list = null;
                    VKApiGetDialogResponse getDialogResponse =
                            (VKApiGetDialogResponse) response.parsedModel;
                    list = getDialogResponse.items;
                    return list;
                })
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .subscribe(getView()::showDialogs/*, new RxErrorAction(getView().getContext())*/));
    }


}
