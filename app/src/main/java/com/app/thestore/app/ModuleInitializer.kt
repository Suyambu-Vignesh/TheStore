package com.app.thestore.app

import android.content.Context
import androidx.startup.Initializer
import com.app.thestore.app.modules.AppModules
import com.app.thestore.core.api.Apis
import com.app.thestore.core.module.ApiProvider

class ModuleInitializer : Initializer<AppModules> {
    override fun create(context: Context): AppModules {
        val appModules = AppModules(context.applicationContext)
        ApiProvider.init(appModules)
        return appModules
    }

    override fun dependencies(): List<Class<out Initializer<*>>> {
        return emptyList()
    }
}