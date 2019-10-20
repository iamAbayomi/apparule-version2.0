package com.cuesoft.io.apparule.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.cuesoft.io.apparule.model.Customer

@Dao
interface CustomerDao{

    @Insert
    suspend  fun insertCustomer(customer: Customer)

    @Query("SELECT * FROM customer")
    fun getAll(): LiveData<Customer>


    @Query("SELECT * FROM customer WHERE customerId = customerID")
    fun loadUserProfile(customerID: Int):LiveData<Customer>


}