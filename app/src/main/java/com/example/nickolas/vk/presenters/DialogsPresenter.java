package com.example.nickolas.vk.presenters;

import com.example.nickolas.vk.models.enteties.Dialog;
import com.example.nickolas.vk.models.remote.IDialogsDataSource;
import com.example.nickolas.vk.utils.rx.RxRetryWithDelay;
import com.example.nickolas.vk.views.DialogsView;

import java.io.IOException;
import java.util.List;

import rx.android.schedulers.AndroidSchedulers;
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
                    List<Dialog> list = null;

//                    VKResponse response1 = response.string();

                    try {
                        System.out.println("sdasdsadasdasdasdasd" + response.string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return list;
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getView()::showDialogs/*, new RxErrorAction(getView().getContext())*/));
    }


}
