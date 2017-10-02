package com.example.nickolas.vk.di.scopes;

public class Scopes {

    public static final String ACTIVITY = "activity";
    public static final String SERVICE = "service";
    public static final String FRAGMENT = "fragment";
    public static final String VIEW = "view";

    private Scopes() {
        throw new AssertionError("Unable to instantiate");
    }
}
