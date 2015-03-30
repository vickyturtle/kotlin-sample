package me.kashyap.theverge;

import android.app.Activity;
import android.app.Application;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created on 3/26/2015.
 */
@Singleton
@Component(modules = {AppModule.class, UiModule.class})
public interface AppComponent {

    void inject(MainActivity activity);
    void inject(Application application);

    final class Initializer {
        static AppComponent init(RssApplication rssApplication) {
            return Dagger_AppComponent
                    .builder()
                    .appModule(new AppModule(rssApplication))
                    .build();

        }
    }

}
