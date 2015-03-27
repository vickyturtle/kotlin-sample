package me.kashyap.theverge;

import javax.inject.Singleton;

import dagger.Component;
import me.kashyap.theverge.rest.RssService;

/**
 * Created on 3/26/2015.
 */
@Singleton
@Component(modules = {UiModule.class})
public interface UiComponent {
    RssService getRssService();

    MainViewHandler getMainHandler();
}
