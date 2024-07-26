package com.app.thestore.cart.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.app.thestore.cart.CartPrivateApi
import com.app.thestore.core.module.ApiProvider
import com.app.thestore.databinding.ViewAddToCartBinding
import com.app.thestore.shelf.data.model.ShelfProduct

class AddToCartView: ConstraintLayout {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    private val binding = ViewAddToCartBinding.inflate(
        LayoutInflater.from(context),
        this,
        true
    )

    private var product: ShelfProduct? = null

    override fun onFinishInflate() {
        super.onFinishInflate()

        binding.buttonAdd.setOnClickListener {
            product?.let {
                it.itemCount += 1
            }

            enableDisableButton()
            addRemoveItemToCart()
        }

        binding.buttonRemove.setOnClickListener {
            product?.let {
                it.itemCount -= 1
            }

            enableDisableButton()
            addRemoveItemToCart()
        }
    }

    private fun enableDisableButton() {
        product?.let {
            binding.buttonAdd.alpha = if (it.itemCount < it.availableItemCount) {
                1.0f
            } else {
                0.5f
            }
            binding.buttonAdd.isEnabled = (it.itemCount < it.availableItemCount)

            binding.buttonRemove.alpha = if (it.itemCount == 0) {
                1.0f
            } else {
                0.5f
            }
            binding.buttonRemove.isEnabled = (it.itemCount == 0)
        }
    }

    private fun addRemoveItemToCart() {
        product?.let {
            if (it.itemCount == 0) {
                ApiProvider.getFeatureApi(CartPrivateApi::class.java)?.removeAnItemItem(it)
            }

            if (it.itemCount == 1) {
                ApiProvider.getFeatureApi(CartPrivateApi::class.java)?.addAnItem(it)
            }
        }
    }
}