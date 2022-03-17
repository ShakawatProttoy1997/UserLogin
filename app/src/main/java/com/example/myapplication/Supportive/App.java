package com.example.myapplication.Supportive;

import android.app.Activity;
import android.app.Application;

public class App extends Application implements HasActivityInjector {

    private static App sInstance;
    @Inject
    DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;
    private Object build;

    public static App getAppContext() {
        return sInstance;
    }

    private static synchronized void setInstance(App app) {
        sInstance = app;
    }

    @Override
    public DispatchingAndroidInjector<Activity> activityInjector() {
        return activityDispatchingAndroidInjector;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        setInstance(this);
       // DaggerAppComponent.builder().inject(this);

        AppLogger.init();

    }
}

