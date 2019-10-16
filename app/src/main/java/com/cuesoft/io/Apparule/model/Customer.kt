package com.cuesoft.io.apparule.model

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Customer" )
data class Customer(
    @ColumnInfo(name="firstname")
    var firstname: String,

    @ColumnInfo(name = "lastname")
    var lastname: String,

    @ColumnInfo(name="email")
    var email: String,

    @ColumnInfo(name="phonenumber")
    var phonenumber: String

  /*  @ColumnInfo (name="password")
    var Password: String
*/
){
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name ="customerId")
    var customerId : Int = 0

}
