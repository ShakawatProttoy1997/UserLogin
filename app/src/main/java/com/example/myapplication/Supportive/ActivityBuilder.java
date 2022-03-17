package com.example.myapplication.Supportive;


/* import com.nsu.classinsight.MainActivity; */

import com.example.myapplication.MainActivity;

//import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = {FragmentProvider.class})
    abstract MainActivity bindAuthActivity();

}
