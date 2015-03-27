package me.kashyap.theverge

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import theverge.model.FeedItem
import java.util.ArrayList

/**
 * Created on 3/27/2015.
 */
public class FeedAdapter : RecyclerView.Adapter<FeedAdapter.FeedViewHolder>() {

    var feeds: List<FeedItem> = ArrayList()


    override fun onBindViewHolder(viewHolder: FeedViewHolder, position: Int) {
        val feedItem = feeds.get(position)
        viewHolder.feedTitle.setText(feedItem.title);
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, type: Int): FeedViewHolder? {
        val view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.feed_row, viewGroup, false)
        return FeedViewHolder(view);
    }

    override fun getItemCount(): Int {
        return feeds.size()
    }

    public class FeedViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {

        var feedImage: ImageView
        var feedTitle: TextView

        init {
            feedImage = itemView.findViewById(R.id.feedRowImage) as ImageView
            feedTitle = itemView.findViewById(R.id.feedText) as TextView
        }
    }
}