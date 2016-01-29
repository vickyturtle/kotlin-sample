package me.kashyap.theverge.rest

import android.net.Uri
import android.util.Log
import me.kashyap.theverge.db.FeedItem
import org.jsoup.Jsoup
import theverge.model.TFeedItem
import java.text.DateFormat

/**
 * Created by vikas@fueled.com on 1/28/2016.
 * copyright © Fueled
 */

fun toFeedItem(tFeedItem: TFeedItem, dateFormat: DateFormat): FeedItem {
    var feedItem = FeedItem()

    var document = Jsoup.parse(tFeedItem.content)
    val elements = document.getElementsByTag("img")
    if (!elements.isEmpty()) {
        feedItem.imageUrl = elements[0].attr("src")
        elements[0].remove()
    }

    feedItem.html = document.outerHtml()
    feedItem.publishedAt = dateFormat.parse(tFeedItem.published)
    feedItem.updatedAt = dateFormat.parse(tFeedItem.updated)
    feedItem.title = tFeedItem.title!!
    feedItem.pageUrl = tFeedItem.url!!

    val uri = Uri.parse(feedItem.pageUrl)
    val segments = uri.pathSegments
    val id = segments[segments.lastIndex - 1]
    feedItem.feedId = id.toLong()
    return feedItem
}