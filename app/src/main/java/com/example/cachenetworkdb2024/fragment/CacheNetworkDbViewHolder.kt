package com.example.cachenetworkdb2024.fragment

import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.example.cachenetworkdb2024.R
import com.example.cachenetworkdb2024.databinding.CacheNetworkDbItemBinding

/**
 * ViewHolder for DevByte items. All work is done by data binding.
 */
class CacheNetworkDbViewHolder(val viewDataBinding: CacheNetworkDbItemBinding) :
    RecyclerView.ViewHolder(viewDataBinding.root) {
    companion object {
        @LayoutRes
        val LAYOUT = R.layout.cache_network_db_item
    }
}