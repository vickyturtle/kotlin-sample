package me.kashyap.theverge.dagger

import dagger.Component
import me.kashyap.theverge.MainActivity
import me.kashyap.theverge.RssApplication
import me.kashyap.theverge.sync.SyncAdapter
import javax.inject.Singleton

/**
 * Created on 3/26/2015.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class, UiModule::class))
interface AppComponent {

    fun inject(activity: MainActivity)
    fun inject(application: RssApplication)
    fun inject(adapter: SyncAdapter)

    object Initializer {
        internal fun init(rssApplication: RssApplication): AppComponent {
            return DaggerAppComponent.builder().appModule(AppModule(rssApplication)).build()

        }
    }

}
