package com.app.thestore.shelf.ui.delegate

import android.view.View
import com.app.thestore.R
import com.app.thestore.common.adapter.CollectionItem
import com.app.thestore.databinding.ViewShelfDetailBinding
import com.app.thestore.databinding.ViewShelfProductBinding
import com.app.thestore.shelf.data.model.ShelfProduct
import com.bumptech.glide.Glide
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

fun getShelfProductAdapterDelegate(clickListener: (Int) -> Unit) =
    adapterDelegateViewBinding<ShelfProduct, CollectionItem, ViewShelfProductBinding>(
        { layoutInflater, parent ->
            ViewShelfProductBinding.inflate(layoutInflater, parent, false)
        }
    ) {
        bind {
            binding.root.setOnClickListener {
                clickListener.invoke(
                    this.getBindingAdapterPosition()
                )
            }
            item.image?.let {
                Glide.with(binding.imageShelfProduct)
                    .load(it)
                    .centerCrop()
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(binding.imageShelfProduct)
            }

            binding.textShelfProductName.text = item.title

            item.price?.let {
                binding.textPrice.visibility = View.VISIBLE
                binding.textPrice.text = getString(R.string.price, it.toString())
            } ?: run {
                binding.textPrice.visibility = View.INVISIBLE
            }

            item.rating?.rate?.let {
                binding.textRatting.visibility = View.VISIBLE
                binding.textRatting.text = it.toString()
            } ?: run {
                binding.textRatting.visibility = View.INVISIBLE
            }
        }
    }

fun getProductDetailAdapterDelegate() =
    adapterDelegateViewBinding<ShelfProduct, CollectionItem, ViewShelfDetailBinding>(
        { layoutInflater, parent ->
            ViewShelfDetailBinding.inflate(layoutInflater, parent, false)
        }
    ) {
        bind {
            item.image?.let {
                Glide.with(binding.imageProduct)
                    .load(it)
                    .centerCrop()
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(binding.imageProduct)
            }

            binding.textProductName.text = item.title

            item.price?.let {
                binding.textProductPrice.visibility = View.VISIBLE
                binding.textProductPrice.text = getString(R.string.price, it.toString())
            } ?: run {
                binding.textProductPrice.visibility = View.INVISIBLE
            }

            item.rating?.rate?.let {
                binding.textProductRatting.visibility = View.VISIBLE
                binding.textProductRatting.text = it.toString()
            } ?: run {
                binding.textProductRatting.visibility = View.INVISIBLE
            }

            item.description?.let {
                binding.textProductDetail.visibility = View.VISIBLE
                binding.textProductDetail.text = it
            } ?: run {
                binding.textProductDetail.visibility = View.INVISIBLE
            }
        }
    }