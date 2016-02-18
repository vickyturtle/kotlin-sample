package me.kashyap.theverge

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import me.kashyap.theverge.db.FeedItem
import theverge.model.TFeedItem
import java.util.*

/**
 * Created on 3/27/2015.
 */
class FeedAdapter(picasso: Picasso) : RecyclerView.Adapter<FeedAdapter.FeedViewHolder>() {

    var feeds: List<FeedItem> = ArrayList()

    var picasso: Picasso

    init {
        this.picasso = picasso
    }

    override fun onBindViewHolder(viewHolder: FeedViewHolder, position: Int) {
        val feedItem = feeds.get(position)
        viewHolder.feedTitle.text = feedItem.title;
        if (!TextUtils.isEmpty(feedItem.imageUrl)) {
            picasso.load(feedItem.imageUrl).fit().centerCrop().into(viewHolder.feedImage)
        } else {
            viewHolder.feedImage.setImageDrawable(null)
        }
        viewHolder.parent.setOnClickListener {
            val extra = FeedDetailsActivity.getExtra(feedItem.feedId)
            val context = viewHolder.parent.context
            val intent = Intent(context, FeedDetailsActivity::class.java)
            intent.putExtras(extra)
            context.startActivity(intent)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, type: Int): FeedViewHolder? {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.feed_row, viewGroup, false)
        return FeedViewHolder(view);
    }

    override fun getItemCount(): Int {
        return feeds.size
    }

    class FeedViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {

        var feedImage: ImageView
        var feedTitle: TextView
        var parent: View

        init {
            feedImage = itemView.findViewById(R.id.feedRowImage) as ImageView
            feedTitle = itemView.findViewById(R.id.feedText) as TextView
            parent = itemView.findViewById(R.id.feedRow)
        }
    }
}