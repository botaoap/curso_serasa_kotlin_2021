package com.serasa.crud_db_local_room.model

import androidx.room.*


@Entity
data class Product(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "prod_id")
    val id: Long = 0,
    @ColumnInfo(name = "prod_name")
    val name: String,
    @ColumnInfo(name = "prod_price")
    val price: Double,

    val categoryFk: Long
)

data class ProductWithCategory(

    @Embedded
    val product: Product?,
    @Relation(
        parentColumn = "categoryFk",
        entityColumn = "cat_id"
    )
    val category: Category?
)