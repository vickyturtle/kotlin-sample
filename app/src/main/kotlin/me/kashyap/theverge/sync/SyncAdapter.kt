package me.kashyap.theverge.sync

import android.accounts.Account
import android.content.AbstractThreadedSyncAdapter
import android.content.ContentProviderClient
import android.content.Context
import android.content.SyncResult
import android.os.Bundle
import me.kashyap.theverge.RssApplication
import me.kashyap.theverge.rest.FeedStore
import javax.inject.Inject

/**
 * Created by vikas@fueled.com on 10/15/15.
 * copyright © Fueled
 */
class SyncAdapter(context: Context, autoInitialize: Boolean, allowParallelSyncs: Boolean) : AbstractThreadedSyncAdapter(context, autoInitialize, allowParallelSyncs) {

    @Inject
    lateinit var feedManager: FeedStore

    constructor(context: Context, autoInitialize: Boolean) : this(context, autoInitialize, false) {
        (context.applicationContext as RssApplication).appComponent?.inject(this)
    }

    /**
     * NOTE: Remember to check for multi process issue here,(shared pref and realm). check manifest if its running in
     * different process
     * Also, this runs in background thread
     */
    override fun onPerformSync(account: Account, extras: Bundle, authority: String, provider: ContentProviderClient,
                               syncResult: SyncResult) {
        feedManager.sync()
    }

    override fun onSyncCanceled() {
        super.onSyncCanceled()
    }
}
