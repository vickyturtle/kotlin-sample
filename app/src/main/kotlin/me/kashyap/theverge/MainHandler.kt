package me.kashyap.theverge

import android.app.Activity
import android.content.Context
import android.os.Bundle
import javax.inject.Inject

/**
 * Created on 3/24/2015.
 */
public class MainHandler : MainViewHandler {


    override fun onActivityPaused(activity: Activity?) {
        throw UnsupportedOperationException()
    }

    override fun onActivityStarted(activity: Activity?) {
        throw UnsupportedOperationException()
    }

    override fun onActivityDestroyed(activity: Activity?) {
        throw UnsupportedOperationException()
    }

    override fun onActivitySaveInstanceState(activity: Activity?, outState: Bundle?) {
        throw UnsupportedOperationException()
    }

    override fun onActivityStopped(activity: Activity?) {
        throw UnsupportedOperationException()
    }

    override fun onActivityCreated(activity: Activity?, savedInstanceState: Bundle?) {
        throw UnsupportedOperationException()
    }

    override fun onActivityResumed(activity: Activity?) {
        throw UnsupportedOperationException()
    }
}
