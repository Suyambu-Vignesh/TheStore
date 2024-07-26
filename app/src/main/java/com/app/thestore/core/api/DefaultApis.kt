package com.app.thestore.core.api

import com.app.thestore.app.modules.AppModules

class DefaultApis: Apis {
    private lateinit var appModules: AppModules
    override fun <T : CoreApi> getCoreApi(clazz: Class<T>): T {
        return appModules.getCoreApi(clazz)
    }

    override fun <T : FeatureApi> getFeatureApi(clazz: Class<T>): T? {
        return appModules.getFeatureApi(clazz)
    }
}