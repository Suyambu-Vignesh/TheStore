package com.app.thestore.shelf.api

import androidx.fragment.app.Fragment
import com.app.thestore.shelf.ShelfPublicApi
import com.app.thestore.shelf.ui.view.ShelfFragment

class DefaultShelfPublicApi : ShelfPublicApi {
    override fun getShelfFragment(): Fragment {
        return ShelfFragment.newInstance()
    }

    override val TAG: String
        get() = "DefaultShelfApi"
}