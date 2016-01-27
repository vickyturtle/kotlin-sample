package me.kashyap.theverge.model

import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root
import theverge.model.FeedItem
import java.util.ArrayList

/**
 * Created on 3/23/2015.
 */
@Root(name = "feed", strict = false)
class RssFeed {

    var title: String? = null;

    var feeds: List<FeedItem> = ArrayList()
        @ElementList(inline = true) set
        @ElementList(inline = true) get

}
