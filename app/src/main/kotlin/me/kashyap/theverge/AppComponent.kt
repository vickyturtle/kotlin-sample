package me.kashyap.theverge

import dagger.Component
import javax.inject.Singleton

/**
 * Created on 3/26/2015.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class, UiModule::class))
interface AppComponent {

    fun inject(activity: MainActivity)
    fun inject(application: RssApplication)

    object Initializer {
        internal fun init(rssApplication: RssApplication): AppComponent {
            return DaggerAppComponent.builder().appModule(AppModule(rssApplication)).build()

        }
    }

}
