package me.kashyap.theverge.model

import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root
import theverge.model.FeedItem

/**
 * Created on 3/23/2015.
 */
[Root(name = "feed", strict = false)]
public class RssFeed {

    var title: String? = null;

    var feeds: List<FeedItem>? = null
        [ElementList(inline = true)] set
        [ElementList(inline = true)] get

}
