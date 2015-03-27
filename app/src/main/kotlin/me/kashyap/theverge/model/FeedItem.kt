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
) {

    public var content: String? = null
        [Element(name = "content")] set
        [Element(name = "content")] get


    var title: String? = null
    //    [Element(name = "title")] title: String?,
    //    [Element(name = "id")] id: String?

    var url: String? = null
        [Element(name = "id")] set
        [Element(name = "id")] get
}
