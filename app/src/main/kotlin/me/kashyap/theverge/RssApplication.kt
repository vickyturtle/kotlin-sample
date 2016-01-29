package me.kashyap.theverge

import android.accounts.Account
import android.accounts.AccountManager
import android.app.Application
import android.content.ContentResolver
import android.content.Context
import android.os.Bundle
import io.realm.Realm
import io.realm.RealmConfiguration
import me.kashyap.theverge.dagger.AppComponent

const val REALM_SCHEMA_VERSION = 1L
/**
 * Created on 3/23/2015.
 */
class RssApplication : Application() {
    val UPDATE_DURATION = 2 * 60 * 60L    //It should be in seconds and not in milliseconds
    val ACCOUNT = "Verge"

    var appComponent: AppComponent? = null
        private  set

    override fun onCreate() {
        super.onCreate()
        setUpDagger()
        setUpRealm()
        setUpSyncManager()
    }

    private fun setUpRealm() {
        val config = RealmConfiguration.Builder(this)
                .schemaVersion(REALM_SCHEMA_VERSION)
                .deleteRealmIfMigrationNeeded()
                .build()

        Realm.setDefaultConfiguration(config)
    }

    private fun setUpDagger() {
        appComponent = AppComponent.Initializer.init(this)
        appComponent?.inject(this)
    }

    private fun setUpSyncManager() {
        val authority = getString(R.string.content_authority)
        ContentResolver.addPeriodicSync(getAccount(), authority, Bundle.EMPTY, UPDATE_DURATION)
        ContentResolver.setSyncAutomatically(getAccount(), authority, true)

    }

    private fun getAccount(): Account {
        val accountType = getString(R.string.account_type)
        val account = Account(ACCOUNT, accountType)
        val accountManager = getSystemService(Context.ACCOUNT_SERVICE) as AccountManager
        accountManager.addAccountExplicitly(account, "password", Bundle.EMPTY)
        return account
    }
    companion object {

        internal fun getApp(context: Context): RssApplication {
            return context.applicationContext as RssApplication
        }
    }


}
