package me.kashyap.theverge

import android.os.Bundle
import android.support.v7.app.ActionBarActivity
import android.util.Log

/**
 * Created on 3/26/2015.
 */
public abstract class BaseActivity : ActionBarActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("Base Activity", "onCreate called")
//        RssApplication.getApp(this).appComponent.inject(this)
    }
}