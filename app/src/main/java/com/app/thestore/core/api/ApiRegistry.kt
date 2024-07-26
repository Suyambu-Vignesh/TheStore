package com.app.thestore.core.principles.api

/**
 * Interface to register the API's from the Modules so other Module can access feature from other
 * Modules in a controlled Fashion.
 */
interface ApiRegistry {

    /**
     * Method for the Module to register the its API
     *
     * @param apiClass of Type [T]
     * @param factory Factory to create the api instance
     */
    fun <T : Any> registerApi(apiClass: Class<T>, factory: () -> Unit)
}
