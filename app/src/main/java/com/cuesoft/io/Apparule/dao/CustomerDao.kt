package com.cuesoft.io.Apparule.dao

import androidx.room.Insert
import androidx.room.Query
import com.cuesoft.io.Apparule.model.Customer

interface CustomerDao{

    @Insert
    fun insertCustomer(customer: Customer)

    @Query("SELECT * FROM customer WHERE customerId IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<Customer>


    //@Query("SELECT * FROM user")

}