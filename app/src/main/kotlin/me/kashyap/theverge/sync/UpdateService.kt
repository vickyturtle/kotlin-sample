package me.kashyap.theverge.sync

import android.app.Service
import android.content.Intent
import android.os.IBinder

import me.kashyap.theverge.Logger

/**
 * Created by vikas@fueled.com on 10/15/15.
 * copyright © Fueled
 */
class UpdateService : Service() {
    private val logger = Logger.getLogger(javaClass)
    /*
     * Instantiate the sync adapter object.
     */
    override fun onCreate() {
        /*
         * Create the sync adapter as a singleton.
         * Set the sync adapter as syncable
         * Disallow parallel syncs
         */
        logger.debug("Create update service")
        synchronized (sSyncAdapterLock) {
            if (sSyncAdapter == null) {
                sSyncAdapter = SyncAdapter(applicationContext, true)
            }
        }
    }

    /**
     * Return an object that allows the system to invoke
     * the sync adapter.

     */
    override fun onBind(intent: Intent): IBinder? {
        /*
         * Get the object that allows external processes
         * to call onPerformSync(). The object is created
         * in the base class code when the SyncAdapter
         * constructors call super()
         */
        logger.debug("On Bind service")
        return sSyncAdapter!!.syncAdapterBinder
    }

    companion object {

        private var sSyncAdapter: SyncAdapter? = null
        // Object to use as a thread-safe lock
        private val sSyncAdapterLock = Object()
    }

}
