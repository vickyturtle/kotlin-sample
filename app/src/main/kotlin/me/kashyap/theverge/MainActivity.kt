package me.kashyap.theverge

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.squareup.picasso.Picasso
import io.realm.Realm
import io.realm.RealmChangeListener
import kotlinx.android.synthetic.main.activity_main.*
import me.kashyap.theverge.db.FeedItem
import me.kashyap.theverge.rest.FeedStore
import me.kashyap.theverge.rest.RssService
import rx.Subscription
import java.util.*
import javax.inject.Inject


class MainActivity : BaseActivity() {

    var service: RssService? = null
        @Inject set

    var handler: MainViewHandler? = null
        @Inject set

    var picasso: Picasso? = null
        @Inject set

    @Inject lateinit var feedStore: FeedStore

    private val logger = Logger.getLogger(javaClass)
    private var feedAdapter: FeedAdapter? = null
    private var subscription: Subscription? = null
    private var realm: Realm? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        RssApplication.getApp(this).appComponent?.inject(this)
        feedAdapter = FeedAdapter(picasso!!)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = feedAdapter
        logger.debug("on create")
        feedStore.forceSync().subscribe ({ success ->
            logger.debug("fetched feed $success")
            if (success) {
                fetchFeed()
            }
        })
        { throwable ->
            logger.warn(throwable)
            Toast.makeText(this, throwable.message, Toast.LENGTH_LONG).show()
        }
    }

    override fun onStart() {
        super.onStart()
        progressBar.visibility = View.VISIBLE
        realm = Realm.getDefaultInstance()
        fetchFeed()
    }

    override fun onStop() {
        super.onStop()
        subscription?.unsubscribe()
        feedAdapter?.feeds = ArrayList()
        realm?.close();
    }

    override fun onResume() {
        super.onResume();
        Log.d("MainActivity", " On Resume Called :$service ,$handler")
        //        var subscription: Subscription = Subscription();
    }

    private fun fetchFeed() {
        var queryFeeds = feedStore.queryFeeds(realm!!)
        queryFeeds?.addChangeListener(object : RealmChangeListener {
            override fun onChange() {
                queryFeeds.removeChangeListener(this)
                onFeedAvailable(queryFeeds)
            }
        })
    }

    override fun onPause() {
        super.onPause()
    }

    fun onFeedAvailable(feeds: List<FeedItem>) {
        Log.d("MainActivity", " feed : " + feeds.size)
        progressBar.visibility = View.GONE
        feedAdapter?.feeds = feeds
        feedAdapter?.notifyDataSetChanged()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item!!.itemId
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }
}
