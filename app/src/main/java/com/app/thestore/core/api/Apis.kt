package com.app.thestore.core.principles.api

interface Apis {

    /**
     * Method that return the Core API. Will Throw [NullPointerException] when the Platform API is
     * Not present.
     *
     * @param clazz Class Type of PlatformApi
     *
     * @return [CoreApi] or Throw [NullPointerException]
     */
    fun <T : CoreApi> getCoreApi(clazz: Class<T>): T

    /**
     * Method that return the FeatureApi API. Will return null if the API is not registered
     *
     * @param clazz Class Type of PlatformApi
     *
     * @return [FeaturePublicApi] or null
     */
    fun <T : FeatureApi> getFeatureApi(clazz: Class<T>): T?
}