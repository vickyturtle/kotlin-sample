package me.kashyap.theverge

import android.content.Context

import dagger.Module
import dagger.Provides

/**
 * Created on 3/23/2015.
 */
@Module
class AppModule(private val application: RssApplication) {

    @Provides
    fun provideAppContext(): Context {
        return this.application
    }
}
