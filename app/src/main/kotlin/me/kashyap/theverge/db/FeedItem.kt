package me.kashyap.theverge.db

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.*

/**
 * Created by vikas@fueled.com on 1/28/2016.
 * copyright © Fueled
 */
open class FeedItem : RealmObject() {

    @PrimaryKey
    open var feedId: Long = 0L
    open var title: String = ""
    open var html: String = ""
    open var imageUrl: String = ""
    open var pageUrl: String = ""
    open var publishedAt: Date = Date()
    open var updatedAt: Date = Date()
}
