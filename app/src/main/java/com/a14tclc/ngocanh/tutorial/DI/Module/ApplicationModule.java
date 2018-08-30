package com.a14tclc.ngocanh.tutorial.DI.Module;

import android.content.Context;

import com.a14tclc.ngocanh.tutorial.App.AApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Singleton
@Module
public class ApplicationModule {

    /**
     * Module provide method util, class util, object
     * Context, AApplication
     */
    private Context context;
    private AApplication aApplication;

    /**
     * Get value Context, AAplication from constructor
     * @return
     */

    public ApplicationModule(AApplication application, Context context) {
        this.aApplication = application;
        this.context = context;
    }

    @Provides
    public Context provideContext() {
        return context;
    }

    @Provides
    public AApplication provideAAplication() {
        return aApplication;
    }
}
