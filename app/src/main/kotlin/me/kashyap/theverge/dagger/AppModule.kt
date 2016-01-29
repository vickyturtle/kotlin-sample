package me.kashyap.theverge.dagger

import android.content.Context

import dagger.Module
import dagger.Provides
import me.kashyap.theverge.RssApplication

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
