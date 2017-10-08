package com.example.nickolas.vk.views;

import com.example.nickolas.vk.models.enteties.Message;

import java.util.List;

/**
 * Created by Nickolas on 08.10.2017.
 */

public interface DialogView extends BaseView {

    void showMessages(List<Message> messages);

}
