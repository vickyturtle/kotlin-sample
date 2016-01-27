package me.kashyap.theverge;

import dagger.Module;
import dagger.Provides;

/**
 * Created on 3/23/2015.
 */
@Module(includes = VergeModule.class)
public class UiModule {
    @Provides
    public MainViewHandler providesMainViewHandler() {
        return new MainHandler();
    }

}
