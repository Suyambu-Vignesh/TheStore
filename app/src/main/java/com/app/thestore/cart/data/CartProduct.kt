package com.app.thestore.cart.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.app.thestore.shelf.data.model.Rating

@Entity(tableName = "table_cart")
data class CartProduct(
    @PrimaryKey
    val id: Int,
    @ColumnInfo
    val title: String?,
    @ColumnInfo
    val price: Double?,
    @ColumnInfo
    val description: String?,
    @ColumnInfo
    val category: String?,
    @ColumnInfo
    val image: String?,
    @ColumnInfo
    val rating: Rating?,
    @ColumnInfo
    private var itemCount: Int = 0,
    @ColumnInfo
    private var availableItemCount: Int = 0
) {

    internal fun getItemCount() = itemCount
    internal fun getAvailableItemCount() = availableItemCount

    internal fun removeAnItem(): Boolean {
        if (itemCount == 0) {
            return false
        }

        itemCount -= 1

        return true
    }

    internal fun addAnItem() {
        if (itemCount == availableItemCount) {
            return
        }

        itemCount += 1
    }
}
