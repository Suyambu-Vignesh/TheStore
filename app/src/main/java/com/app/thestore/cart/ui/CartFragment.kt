package com.app.thestore.cart.ui

import androidx.fragment.app.Fragment

class CartFragment: Fragment() {

    companion object {
        internal fun getCartFragment(): CartFragment {
            return CartFragment()
        }
    }
}