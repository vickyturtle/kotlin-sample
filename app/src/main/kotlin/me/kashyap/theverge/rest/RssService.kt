package me.kashyap.theverge.rest

import me.kashyap.theverge.model.RssFeed
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable

/**
 * Created on 3/23/2015.
 */
public interface  RssService {

    @GET("/rss/full.xml")
    public fun fetchFeed(@Query("page") page : Int) : Observable<RssFeed>;
}