package com.cuesoft.io.apparule.repositories

import androidx.lifecycle.LiveData
import com.cuesoft.io.apparule.dao.CustomerDao
import com.cuesoft.io.apparule.model.Customer


class CustomerSignUpRepository(private val customerDao: CustomerDao){

    //Room executes all queries on a separate thread.
    //observed LiveData will notify the observer when the data
    val getAllCustomers: LiveData<Customer> = customerDao.getAll()


    suspend fun loadUserProfile(userID: Int): LiveData<Customer>{
        return customerDao.loadUserProfile(userID)
    }

    suspend fun insert(customer: Customer){
        customerDao.insertCustomer(customer)
    }


}