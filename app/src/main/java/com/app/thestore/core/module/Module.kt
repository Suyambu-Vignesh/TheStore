package com.app.thestore.core.principles.module

import android.app.Application
import android.content.Context
import com.app.thestore.core.principles.api.ApiRegistry
import com.app.thestore.core.principles.core.Tagged

interface Module : Tagged {

    /**
     * Called when the Module is about to get attached to the application, Over here the Module owner
     * need to register all the api's they own, any time consuming task need to be deferred to [Module.onStart]
     *
     * @param context - [Context]
     * @param apiRegistry - [ApiRegistry]
     */
    fun onAttach(context: Context, apiRegistry: ApiRegistry)

    /**
     * Called when the api's exposed from the Module about to be used.
     */
    fun onStart(context: Context)

    /**
     * Called when the phone enters Low memory mode. This method is tied with [Application.onLowMemory]
     */
    fun onLowMemory()

    /**
     * Called when the Module about to get detached, called when configuration of Application changed
     */
    fun onDetach()
}
