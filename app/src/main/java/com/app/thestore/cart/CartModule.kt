package com.app.thestore.cart

import android.content.Context
import com.app.thestore.cart.defaultapi.DefaultCartPublicApi
import com.app.thestore.core.api.ApiRegistry
import com.app.thestore.core.module.Module

class CartModule : Module {
    override fun onAttach(context: Context, apiRegistry: ApiRegistry) {
        apiRegistry.registerApi(
            CartPublicApi::class.java
        ) {
            DefaultCartPublicApi()
        }

        apiRegistry.registerApi(
            CartPrivateApi::class.java
        ) {
            DefaultCartPublicApi()
        }
    }

    override fun onStart(context: Context) {

    }

    override fun onLowMemory() {

    }

    override fun onDetach() {

    }

    override val TAG: String
        get() = "CartModule"
}