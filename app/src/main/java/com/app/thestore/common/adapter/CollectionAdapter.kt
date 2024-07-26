package com.app.thestore.core.adapter

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import com.hannesdorfmann.adapterdelegates4.AdapterDelegatesManager
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter

internal fun getAdapter(delegateManager: AdapterDelegatesManager<List<CollectionItem>>) =
    AsyncListDifferDelegationAdapter(
        CollectionItemCallback(),
        delegateManager
    )

internal class CollectionItemCallback : DiffUtil.ItemCallback<CollectionItem>() {
    override fun areItemsTheSame(oldItem: CollectionItem, newItem: CollectionItem): Boolean {
        return oldItem == newItem
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: CollectionItem, newItem: CollectionItem): Boolean {
        return oldItem.hashCode() == newItem.hashCode()
    }

}