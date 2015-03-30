package me.kashyap.theverge;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created on 3/23/2015.
 */
@Module
public class AppModule {

    private RssApplication application;

    public AppModule(RssApplication application) {
        this.application = application;
    }

    @Provides
    public Context provideAppContext() {
        return this.application;
    }
}
