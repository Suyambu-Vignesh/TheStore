package com.app.thestore.core.module

import com.app.thestore.core.api.Apis
import com.app.thestore.core.api.FeaturePublicApi
import com.app.thestore.core.api.CoreApi
import com.app.thestore.core.api.FeatureApi

/**
 * Helper focus on resolving the API
 */
object ApiProvider {
    private lateinit var apis: Apis
    internal fun init(apis: Apis) {
        ApiProvider.apis = apis
    }

    fun <T : CoreApi> getCoreApi(clazz: Class<T>): T {
        return apis.getCoreApi(clazz)
    }

    fun <T : FeatureApi> getFeatureApi(clazz: Class<T>): T? {
        return apis.getFeatureApi(clazz)
    }
}