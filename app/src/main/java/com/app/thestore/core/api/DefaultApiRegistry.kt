package com.app.thestore.core.api

import com.app.thestore.core.module.Module

class DefaultApiRegistry(
    private val apiClassCache: HashMap<Class<out ModuleApi>, () -> ModuleApi>,
    private val apiToModule: HashMap<Class<out ModuleApi>, Module>
) : ApiRegistry {

    override fun registerApi(module: Module, apiClass: Class<out FeatureApi>, factory: () -> ModuleApi) {
        apiClassCache[apiClass] = factory
        apiToModule[apiClass] = module
    }
}
