package com.example.nickolas.vk.views;

import com.example.nickolas.vk.models.enteties.Post;

import java.util.List;

/**
 * Created by Nickolas on 01.10.2017.
 */

public interface FeedView extends BaseView {

    void showList(List<Post> posts);

}
