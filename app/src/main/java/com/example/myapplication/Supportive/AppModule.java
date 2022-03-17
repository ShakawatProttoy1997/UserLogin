package com.example.myapplication.Supportive;
import android.app.Application;
import android.content.Context;

@Module
public class AppModule {

    private Object ApiService;
    private boolean apiServiceClass;
    private Object retrofit;
    private Object AppConstants;
    private Object CoreApiHandler;

    @Provides
    @ApiInfo
    String provideApiKey(PreferencesHelper preferencesHelper) {
        return preferencesHelper.getAccessToken();
    }

    @Provides
    @Singleton
    <Retrofit>
    boolean provideRetrofit(OkHttpClient okHttpClient) {
        Retrofit retrofit;
        //  boolean b = !( ApiService<=retrofit.getClass ().Class>apiServiceClass = ApiService.class;
        return Boolean.parseBoolean (null);
    }

    @Provides
    @Singleton
    <CoreApiHandler>
    CoreApiHandler provideCoreApiHandler() {
        //CoreApiHandler //coreApiHandler = new CoreApiHandler();
        CoreApiHandler coreApiHandler = null;
        return  coreApiHandler;
    }


    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application;
    }

    void provideDatabaseName() {
        //return AppConstants.DB_NAME;
    }


    DbHelper provideDbHelper(AppDbHelper appDbHelper) {
        return appDbHelper;
    }


    void provideGson() {
        //return (Gson) new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
    }


    void providePreferenceName() {
        //return AppConstants.PREF_NAME;
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(AppPreferencesHelper appPreferencesHelper) {
        return (PreferencesHelper) appPreferencesHelper;
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }

}

