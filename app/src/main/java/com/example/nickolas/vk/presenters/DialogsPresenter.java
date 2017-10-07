package com.example.nickolas.vk.presenters;

import com.example.nickolas.vk.models.enteties.Dialog;
import com.example.nickolas.vk.models.remote.IDialogsDataSource;
import com.example.nickolas.vk.utils.JoinDataWith;
import com.example.nickolas.vk.utils.ResponseToObjectUtil;
import com.example.nickolas.vk.utils.rx.RxRetryWithDelay;
import com.example.nickolas.vk.views.DialogsView;

import java.util.List;

import okhttp3.ResponseBody;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;


public class DialogsPresenter extends BasePresenter<DialogsView> {

    private final IDialogsDataSource dialogsDataSource;

    public DialogsPresenter(IDialogsDataSource dialogsDataSource) {
        this.dialogsDataSource = dialogsDataSource;
    }

    public void getDialogs(int offset) {

        subscribe(dialogsDataSource.getDialogs(offset)
                .retryWhen(new RxRetryWithDelay())
                .map(ResponseToObjectUtil::parseToDialogList)
                .flatMap(new Func1<List<Dialog>, Observable<ResponseBody>>() {
                    @Override
                    public Observable<ResponseBody> call(List<Dialog> dialogs) {
                        return dialogsDataSource.getUsersData(dialogs);
                    }
                }, (dialogs, responseBody) -> JoinDataWith.Companion.dataWithDialogs(responseBody, dialogs))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getView()::showDialogs/*, new RxErrorAction(getView().getContext())*/));
    }


}
