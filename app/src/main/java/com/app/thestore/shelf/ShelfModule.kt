package com.app.thestore.shelf

import android.content.Context
import com.app.thestore.core.api.ApiRegistry
import com.app.thestore.core.module.Module

class ShelfModule : Module {
    override fun onAttach(context: Context, apiRegistry: ApiRegistry) {
        apiRegistry.re
    }

    override fun onStart(context: Context) {

    }

    override fun onLowMemory() {

    }

    override fun onDetach() {

    }

    override val TAG: String = "ShelfModule"
}