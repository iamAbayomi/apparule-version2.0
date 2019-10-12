package com.cuesoft.io.Apparule.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Customer(
    @PrimaryKey var customerId : Int, @ColumnInfo var firstname: String,
    @ColumnInfo var lastname: String, @ColumnInfo var email: String,
    @ColumnInfo var phonenumber: Int, @ColumnInfo var gender: String,  @ColumnInfo var country: String )
