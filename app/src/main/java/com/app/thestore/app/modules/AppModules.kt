package com.app.thestore.app.modules

import android.app.Application
import android.content.Context
import com.app.thestore.cart.CartModule
import com.app.thestore.core.api.ApiRegistry
import com.app.thestore.core.api.Apis
import com.app.thestore.core.api.CoreApi
import com.app.thestore.core.api.DefaultApiRegistry
import com.app.thestore.core.api.FeatureApi
import com.app.thestore.core.api.ModuleApi
import com.app.thestore.core.error.CoreModuleInitException
import com.app.thestore.core.module.Module
import com.app.thestore.shelf.ShelfModule

class AppModules(private val applicationContext: Context) : Module, Apis {
    private val featureModules by lazy {
        arrayListOf(
            ShelfModule(),
            CartModule()
        )
    }
    private val platformModules by lazy {
        ArrayList<Module>()
    }
    private val startedModules by lazy {
        HashSet<Module>()
    }

    private val featureApiCache by lazy {
        HashMap<Class<out ModuleApi>, FeatureApi>()
    }
    private val coreApiCache by lazy {
        HashMap<Class<out CoreApi>, FeatureApi>()
    }

    private val apiFactoryMap: HashMap<Class<out ModuleApi>, () -> ModuleApi> by lazy {
        HashMap()
    }

    private val apiToModule: HashMap<Class<out ModuleApi>, Module> by lazy {
        HashMap()
    }

    private val apiRegistry: DefaultApiRegistry by lazy {
        DefaultApiRegistry(
            apiFactoryMap,
            apiToModule
        )
    }

    override fun onAttach(context: Context, apiRegistry: ApiRegistry) {
        for (platformModule in platformModules) {
            platformModule.onAttach(context, apiRegistry)
        }

        for (featureModule in featureModules) {
            featureModule.onAttach(context, apiRegistry)
        }
    }

    override fun onStart(context: Context) {

    }

    override fun onLowMemory() {
        for (module in startedModules) {
            module.onLowMemory()
        }
    }

    override fun onDetach() {
        for (platformModule in platformModules) {
            platformModule.onDetach()
        }

        for (featureModule in featureModules) {
            featureModule.onDetach()
        }
    }

    override val TAG: String = "AppModules"
    override fun <T : CoreApi> getCoreApi(clazz: Class<T>): T {
        apiToModule[clazz]?.let {
            if (!startedModules.contains(it)) {
                it.onStart(applicationContext)
            }

            startedModules.add(it)
        }

        return coreApiCache[clazz]?.let {
            it as? T
        } ?: run {
            apiFactoryMap[clazz]?.invoke() as? T
        } ?: throw CoreModuleInitException(clazz.simpleName)
    }

    override fun <T : FeatureApi> getFeatureApi(clazz: Class<T>): T? {
        apiToModule[clazz]?.let {
            if (!startedModules.contains(it)) {
                it.onStart(applicationContext)
            }

            startedModules.add(it)
        }

        return featureApiCache[clazz]?.let {
            it as? T
        } ?: run {
            apiFactoryMap[clazz]?.invoke() as? T
        }
    }
}