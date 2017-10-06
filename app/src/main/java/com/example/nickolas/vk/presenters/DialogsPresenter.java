package com.example.nickolas.vk.presenters;

import com.example.nickolas.vk.models.remote.IDialogsDataSource;
import com.example.nickolas.vk.utils.ResposeToObjectUtil;
import com.example.nickolas.vk.utils.rx.RxRetryWithDelay;
import com.example.nickolas.vk.views.DialogsView;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class DialogsPresenter extends BasePresenter<DialogsView> {

    private final IDialogsDataSource dialogsDataSource;

    public DialogsPresenter(IDialogsDataSource dialogsDataSource) {
        this.dialogsDataSource = dialogsDataSource;
    }

    public void getDialogs(int offset, String token) {

        subscribe(dialogsDataSource.getDialogs(offset, token)
                .retryWhen(new RxRetryWithDelay())
                .map(ResposeToObjectUtil::parseToDialogList)
//                .flatMap(dialogsDataSource::getUsersData, (dialogs, responseBody) -> {
//
//                })
//                .flatMap(new Func1<List<Dialog> dialogs, Observable<? extends String>>() {
//                    @Override
//                    public Observable<? extends String> call(String responseFromServiceA) {
//                        //make second request based on response from ServiceA
//                        return dialogsDataSource.getUsersData(responseFromServiceA);
//                    }
//                }, new Func2<String, String, Observable<String>>() {
//                    @Override
//                    public Observable<String> call(String responseFromServiceA, String responseFromServiceB) {
//                        //combine results
//                        return Observable.just("here is combined result!");
//                    }
//                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getView()::showDialogs/*, new RxErrorAction(getView().getContext())*/));
    }


}
