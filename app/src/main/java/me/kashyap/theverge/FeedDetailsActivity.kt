package me.kashyap.theverge

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.squareup.picasso.Picasso
import io.realm.Realm
import io.realm.RealmChangeListener
import kotlinx.android.synthetic.main.activity_feed_details.*
import kotlinx.android.synthetic.main.content_feed_details.*
import me.kashyap.theverge.db.FeedItem
import me.kashyap.theverge.rest.FeedStore
import javax.inject.Inject

private val EXTRA_CONTENT_ID = "EXTRA_CONTENT_ID"

class FeedDetailsActivity : AppCompatActivity() {

    @Inject lateinit var feedStore: FeedStore
    @Inject lateinit var picasso: Picasso

    var realm: Realm? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed_details)
        RssApplication.getApp(this).appComponent?.inject(this)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    override fun onStart() {
        super.onStart()
        realm = Realm.getDefaultInstance()
        setContent()
    }

    override fun onStop() {
        super.onStop()
        realm?.close()
    }

    private fun setContent() {
        val contentId = intent.getLongExtra(EXTRA_CONTENT_ID, 0)
        val feedItem = feedStore.queryFeed(realm!!, contentId)
        feedItem?.addChangeListener (object : RealmChangeListener {
            override fun onChange() {
                feedItem.removeChangeListener(this)
                onContentAvailable(feedItem)
            }

        })
    }

    private fun onContentAvailable(feedItem: FeedItem?) {
        toolbarLayout.title = feedItem!!.title
        toolbarLayout.setExpandedTitleColor(Color.TRANSPARENT)
        var html = "<h1>" + feedItem.title + "</h1>" + feedItem.html + "<br/><br/>"
//        webview.loadData(html, "text/html", "UTF-8")
        webview.loadDataWithBaseURL("file:///android_asset/", html, "text/html", "UTF-8", null)
        picasso.load(feedItem.imageUrl).fit().centerCrop().into(coverImage)
    }

    companion object Extras {
        fun getExtra(contentId: Long): Bundle {
            val bundle = Bundle()
            bundle.putLong(EXTRA_CONTENT_ID, contentId)
            return bundle
        }
    }
}
