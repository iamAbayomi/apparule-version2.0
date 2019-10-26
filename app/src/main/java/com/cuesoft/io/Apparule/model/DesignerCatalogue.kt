package com.cuesoft.io.apparule.model

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "DesignerCatalogue")
data class DesignerCatalogue(

    @ColumnInfo(name = "CatalogueTitle")
    val CatalogueTitle: String,

    @ColumnInfo(name = "CatalogueDescription")
    val CataloueDescription : String,

    @ColumnInfo(name = "CataloguePrice")
    val CataloguePrice : Int,

    @ColumnInfo(name = "CatalogueUrl")
    val CatalogueUrl: String,

    @ColumnInfo(name ="Likes")
    val Likes : Int
)
