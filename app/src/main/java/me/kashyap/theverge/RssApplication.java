package me.kashyap.theverge;

import android.app.Application;
import android.content.Context;

/**
 * Created on 3/23/2015.
 */
public class RssApplication extends Application {

    AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = AppComponent.Initializer.init(this);
        appComponent.inject(this);
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    static RssApplication getApp(Context context) {
        return (RssApplication) context.getApplicationContext();
    }


}
