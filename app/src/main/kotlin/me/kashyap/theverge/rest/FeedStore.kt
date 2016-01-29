package me.kashyap.theverge.rest

import javax.inject.Inject
import javax.inject.Singleton

import io.realm.Realm
import io.realm.RealmChangeListener
import io.realm.RealmQuery
import io.realm.RealmResults
import me.kashyap.theverge.Logger
import me.kashyap.theverge.db.FeedItem
import me.kashyap.theverge.model.TRssFeed
import rx.Observable
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.functions.Action1
import rx.functions.Func1
import rx.schedulers.Schedulers
import theverge.model.TFeedItem
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by vikas@fueled.com on 1/28/2016.
 * copyright © Fueled
 */
@Singleton
class FeedStore
@Inject
constructor(private val rssService: RssService) {

    private val dateFormatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZZZZZ", Locale.US)
    private val logger = Logger.getLogger(javaClass)

    fun sync() {
        //Should be done on same thread else service will end
        rssService.fetchFeed(1).subscribe({ tRssFeed -> saveFeeds(tRssFeed) }) { }
    }

    private fun saveFeeds(tRssFeed: TRssFeed) {
        var feeds = ArrayList<FeedItem>()
        for (tFeedItem in tRssFeed.feeds) {
            feeds.add(toFeedItem(tFeedItem, dateFormatter))
        }
        val realm = Realm.getDefaultInstance()
        realm.beginTransaction()
        realm.copyToRealmOrUpdate(feeds)
        realm.commitTransaction()
        realm.close()
    }

    fun forceSync(): Observable<Boolean> {
//        return Observable.create<Boolean> {
            logger.debug("Subscribed to rss fetch")
            return rssService.fetchFeed(1)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .flatMap<Boolean> (Func1<me.kashyap.theverge.model.TRssFeed, rx.Observable<kotlin.Boolean>> { t ->
                        logger.debug("response available")
                        saveFeeds(t!!)
                        Observable.just(true)
                    })
//        }
    }

    fun queryFeeds(): RealmResults<FeedItem>? {
        val realm = Realm.getDefaultInstance()
        val count = realm.where(FeedItem::class.java).count()
        val feedItems = realm.where(FeedItem::class.java).findAllAsync()
        return feedItems
    }
}
