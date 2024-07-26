package com.app.thestore.core.api

import com.app.thestore.core.module.Module

/**
 * Interface to register the API's from the Modules so other Module can access feature from other
 * Modules in a controlled Fashion.
 */
interface ApiRegistry {

    /**
     * Method for the Module to register the its API
     *
     * @param module [Module] module owner
     * @param apiClass of Type [Any]
     * @param factory Factory to create the api instance
     */
    fun registerApi(module: Module, apiClass: Class<out FeatureApi>, factory: () -> ModuleApi)
}
