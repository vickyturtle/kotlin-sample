package me.kashyap.theverge.dagger

import dagger.Module
import dagger.Provides
import me.kashyap.theverge.MainHandler
import me.kashyap.theverge.MainViewHandler
import me.kashyap.theverge.rest.FeedStore

/**
 * Created on 3/23/2015.
 */
@Module(includes = arrayOf(VergeModule::class))
class UiModule {
    @Provides
    fun providesMainViewHandler(feedStore: FeedStore): MainViewHandler {
        return MainHandler(feedStore)
    }

}
