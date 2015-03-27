package theverge.model

import android.text.Html
import android.util.Log
import org.jsoup.Jsoup
import org.simpleframework.xml.Element
import org.simpleframework.xml.Root
import java.io.InputStream
import javax.xml.parsers.DocumentBuilder

/**
 * Created on 3/23/2015.
 */
[Root(name = "entry", strict = false)]
data public class FeedItem (
) {

    public var imageurl: String? = null;

    public var content: String? = null
        [Element(name = "content")] get
        [Element(name = "content")] set(value) {
            $content = value
            val element: org.jsoup.nodes.Element? = Jsoup.parse(value).select("img").first();
            imageurl = element?.attr("src")
            if (imageurl == null) {
                imageurl = element?.attr("data-src")
            }
        }


    var title: String? = null
        [Element(name = "title")] set
        [Element(name = "title")] get

    var url: String? = null
        [Element(name = "id")] set
        [Element(name = "id")] get
}
