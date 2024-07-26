package com.app.thestore.shelf

import androidx.fragment.app.Fragment
import com.app.thestore.core.principles.api.FeatureExternalApi

interface ShelfExternalApi : FeatureExternalApi {

    /**
     * Method that provide the starting point of the Shelf
     *
     * @return instance of [Fragment]
     */
    fun getShelfFragment(): Fragment
}