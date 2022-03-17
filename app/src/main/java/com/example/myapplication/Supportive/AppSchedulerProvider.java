
package com.example.myapplication.Supportive;

public class AppSchedulerProvider implements SchedulerProvider {

    private AppSchedulerProvider Schedulers;

    @Override
    public Scheduler computation() {
        return Schedulers.computation();
    }

    @Override
    public Scheduler io() {
        return Schedulers.io();
    }

    @Override
    public Scheduler ui() {
        return AndroidSchedulers.mainThread();
    }
}