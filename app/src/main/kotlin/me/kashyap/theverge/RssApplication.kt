package me.kashyap.theverge

import android.app.Application
import android.content.Context

/**
 * Created on 3/23/2015.
 */
class RssApplication : Application() {

    var appComponent: AppComponent? = null
        private  set

    override fun onCreate() {
        super.onCreate()
        appComponent = AppComponent.Initializer.init(this)
        appComponent?.inject(this)
    }

    companion object {

        internal fun getApp(context: Context): RssApplication {
            return context.applicationContext as RssApplication
        }
    }


}
