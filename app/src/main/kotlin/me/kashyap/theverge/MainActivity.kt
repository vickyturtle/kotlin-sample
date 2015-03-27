package me.kashyap.theverge

import android.support.v7.app.ActionBarActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import me.kashyap.theverge.model.RssFeed
import me.kashyap.theverge.rest.RssService
import retrofit.RestAdapter
import rx.Scheduler
import rx.Subscription
import rx.android.schedulers.AndroidSchedulers
import rx.functions.Action1
import rx.schedulers.Schedulers
import javax.inject.Inject
import kotlinx.android.synthetic.activity_main.recyclerView
import theverge.model.FeedItem


public class MainActivity : BaseActivity() {

    public var service: RssService? = null
        [Inject] set

    public var handler: MainViewHandler? = null
        [Inject] set

    private var feedAdapter = FeedAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.setLayoutManager(LinearLayoutManager(this))
        recyclerView.setAdapter(feedAdapter)
    }

    override fun onResume() {
        super.onResume();
        Log.d("MainActivity", " On Resume Called ")
        service = getUiComponent().getRssService();
        //        var subscription: Subscription = Subscription();
        service?.fetchFeed(1)
                ?.subscribeOn(Schedulers.newThread())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe({ feed: RssFeed ->
                    onFeedAvailable(feed)
                },
                        { e: Throwable ->
                            Log.w("MainActivity", "error ocurred :" + e)
                        })

    }

    fun onFeedAvailable(feed: RssFeed) {
        Log.d("MainActivity", " feed : " + feed.feeds.size())
        feedAdapter.feeds = feed.feeds
        feedAdapter.notifyDataSetChanged()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item!!.getItemId()
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }
}
