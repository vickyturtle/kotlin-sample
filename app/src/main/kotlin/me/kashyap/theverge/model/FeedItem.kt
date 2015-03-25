package theverge.model

import android.text.Html
import org.simpleframework.xml.Element
import org.simpleframework.xml.Root
import java.io.InputStream
import javax.xml.parsers.DocumentBuilder

/**
 * Created on 3/23/2015.
 */
[Root(name = "entry", strict = false)]
data public class FeedItem (
        title: String?,
        [Element(name = "id")] url: String
) {

    [Element(name = "content")]
    public var content: String? = null;


}
