package me.kashyap.theverge

import android.os.Bundle
import android.support.v7.app.ActionBarActivity
import dagger.ObjectGraph

/**
 * Created on 3/23/2015.
 */
public open class BaseActivity : ActionBarActivity() {

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState);
        (getApplication() as RssApplication).getObjectGraph().inject(this);
    }
}