package me.kashyap.theverge

import android.app.Activity
import android.content.Context
import android.os.Bundle
import io.realm.RealmChangeListener
import me.kashyap.theverge.rest.FeedStore
import rx.Observable
import javax.inject.Inject

/**
 * Created on 3/24/2015.
 */
public class MainHandler @Inject constructor(private val feedStore: FeedStore) : MainViewHandler {


    override fun onActivityPaused(activity: Activity?) {
    }

    override fun onActivityStarted(activity: Activity?) {
    }

    override fun onActivityDestroyed(activity: Activity?) {
    }

    override fun onActivitySaveInstanceState(activity: Activity?, outState: Bundle?) {
    }

    override fun onActivityStopped(activity: Activity?) {
    }

    override fun onActivityCreated(activity: Activity?, savedInstanceState: Bundle?) {
    }

    override fun onActivityResumed(activity: Activity?) {

    }
}
