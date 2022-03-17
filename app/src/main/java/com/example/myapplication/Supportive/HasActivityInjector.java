package com.example.myapplication.Supportive;

import android.app.Activity;

interface HasActivityInjector {
    DispatchingAndroidInjector<Activity> activityInjector();
}
