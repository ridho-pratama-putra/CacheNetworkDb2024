package com.example.cachenetworkdb2024.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.cachenetworkdb2024.databinding.CacheNetworkDbItemBinding
import com.example.cachenetworkdb2024.model.VideoDomainModel

class CacheNetworkDbAdapter(val callback: VideoClickListener) : RecyclerView.Adapter<CacheNetworkDbViewHolder>() {

    /**
     * The videos that our Adapter will show
     */
    var videos: List<VideoDomainModel> = emptyList()
        set(value) {
            field = value
            // For an extra challenge, update this to use the paging library.

            // Notify any registered observers that the data set has changed. This will cause every
            // element in our RecyclerView to be invalidated.
            notifyDataSetChanged()
        }

    /**
     * Called when RecyclerView needs a new {@link ViewHolder} of the given type to represent
     * an item.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CacheNetworkDbViewHolder {
        val withDataBinding: CacheNetworkDbItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            CacheNetworkDbViewHolder.LAYOUT,
            parent,
            false
        )
        return CacheNetworkDbViewHolder(withDataBinding)
    }

    override fun getItemCount() = videos.size

    /**
     * Called by RecyclerView to display the data at the specified position. This method should
     * update the contents of the {@link ViewHolder#itemView} to reflect the item at the given
     * position.
     */
    override fun onBindViewHolder(holder: CacheNetworkDbViewHolder, position: Int) {
        holder.viewDataBinding.also {
            it.video = videos[position]
            it.videoCallback = callback
        }
    }

}