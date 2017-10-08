package com.example.nickolas.vk.presenters;

import com.example.nickolas.vk.models.enteties.Message;
import com.example.nickolas.vk.models.remote.IDialogDataSource;
import com.example.nickolas.vk.utils.rx.RxRetryWithDelay;
import com.example.nickolas.vk.views.DialogView;

import java.util.List;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class DialogPresenter extends BasePresenter<DialogView> {

    IDialogDataSource dataSource;

    public DialogPresenter(IDialogDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void getHistory(int offset, int id) {
        subscribe(
                dataSource.getHistory(offset, id)
                        .retryWhen(new RxRetryWithDelay())
                        .map(responseBody -> {
                            List<Message> list = null;
                            return list;
                        })
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(getView()::showMessages)
        );
    }
}
