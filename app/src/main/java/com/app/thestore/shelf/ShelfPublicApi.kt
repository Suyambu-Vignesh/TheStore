package com.app.thestore.shelf

import androidx.fragment.app.Fragment
import com.app.thestore.core.api.FeaturePublicApi

interface ShelfPublicApi : FeaturePublicApi {

    /**
     * Method that provide the starting point of the Shelf
     *
     * @return instance of [Fragment]
     */
    fun getShelfFragment(): Fragment
}