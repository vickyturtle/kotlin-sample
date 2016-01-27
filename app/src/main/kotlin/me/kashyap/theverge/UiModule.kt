package me.kashyap.theverge

import dagger.Module
import dagger.Provides

/**
 * Created on 3/23/2015.
 */
@Module(includes = arrayOf(VergeModule::class))
class UiModule {
    @Provides
    fun providesMainViewHandler(): MainViewHandler {
        return MainHandler()
    }

}
