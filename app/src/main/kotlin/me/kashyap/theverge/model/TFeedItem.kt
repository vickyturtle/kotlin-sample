package theverge.model

import org.jsoup.Jsoup
import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

/**
 * Created on 3/23/2015.
 */
@Root(name = "entry", strict = false)
data public class TFeedItem(val imageUrl: String? = null) {

    var imageurl: String? = null;

    var content: String? = null
        @Element(name = "content") get
        @Element(name = "content") set(value) {
            field = value    //Set the value
            val element: org.jsoup.nodes.Element? = Jsoup.parse(value).select("img").first();
            imageurl = element?.attr("src")
            if (imageurl == null) {
                imageurl = element?.attr("data-src")
            }
        }


    var title: String? = null
        @Element(name = "title") set
        @Element(name = "title") get

    var url: String? = null
        @Element(name = "id") set
        @Element(name = "id") get

    var published: String? = null
        @Element(name = "published") set
        @Element(name = "published") get

    var updated: String? = null
        @Element(name = "updated") set
        @Element(name = "updated") get
}
