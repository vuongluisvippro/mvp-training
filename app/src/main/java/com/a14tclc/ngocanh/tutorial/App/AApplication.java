package com.a14tclc.ngocanh.tutorial.App;

import android.app.Application;

import com.a14tclc.ngocanh.tutorial.DI.Component.ApplicationComponent;
import com.a14tclc.ngocanh.tutorial.DI.Component.DaggerApplicationComponent;
import com.a14tclc.ngocanh.tutorial.DI.Module.ApplicationModule;

public class AApplication extends Application {

    // Singoton Pattern
    public static AApplication sInstance;
    private ApplicationComponent mApplicationComponent;

    public static AApplication getInstance() {
        if (sInstance == null) {
            sInstance = new AApplication();
        }
        return sInstance;
    }

    @Override
    public void onCreate() {
        // Initialize what you want to do before launch app
        // Call Api
        // Establish theme
        // Establish language
        super.onCreate();
        sInstance = this;
        init();
    }

    private void init() {
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this, this))
                .build();
    }
}
