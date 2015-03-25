package me.kashyap.theverge.rest

import me.kashyap.theverge.model.RssFeed
import retrofit.http.GET
import retrofit.http.Query
import rx.Observable

/**
 * Created on 3/23/2015.
 */
public trait RssService {

    [GET("/rss/index.xml")]
    public fun fetchFeed([Query("page")] page : Int) : Observable<RssFeed>;
}