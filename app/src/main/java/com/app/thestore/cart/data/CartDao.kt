package com.app.thestore.cart.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface CartDao {
    @Query("SELECT * FROM table_cart")
    fun getAllCartItem(): Flow<List<CartProduct>>

    @Update
    fun updateCartItem(cartProduct: CartProduct)

    @Insert
    fun addCartItem(cartProduct: CartProduct)

    @Delete
    fun removeCartItem(cartProduct: CartProduct)
}