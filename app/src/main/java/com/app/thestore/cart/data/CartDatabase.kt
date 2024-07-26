package com.app.thestore.cart.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [CartProduct::class], version = 1)
abstract class CartDatabase : RoomDatabase() {
    abstract fun cartDao(): CartDao
}

internal fun getCardDatabase(context: Context): CartDatabase {
    return Room.databaseBuilder(
        context,
        CartDatabase::class.java,
        "CartDatabase"
    ).build()
}
