package com.cuesoft.io.apparule.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.cuesoft.io.apparule.ApparuleRoomDatabase
import com.cuesoft.io.apparule.model.Customer
import com.cuesoft.io.apparule.repositories.CustomerSignUpRepository
import kotlinx.coroutines.launch


// Class extends AndroidViewModel and requires application as a parameter
class CustomerSignUpViewModel(application: Application): AndroidViewModel(application){

    // The ViewModel maintains a reference to the repository  to get data.
    private val repository: CustomerSignUpRepository

    // LiveData gives us updated words when they change
    val allcustomers: LiveData<Customer>

    init{
        //Gets reference to CustomerDao from ApparuleRoomDatabase to construct
        // the correct CustomerSignUpRepository
        val customerDao = ApparuleRoomDatabase.getDatabase(application).customerDao()
        repository = CustomerSignUpRepository(customerDao)
        allcustomers = repository.getAllCustomers
    }

    //The implementation of insert() is completely hidden from the UI
    // We don't want to insert to block the main thread, so we're launching a new
    // coroutine. ViewModels have a coroutine scope based on their lifecycle called
    // viewModelScope which we can use here.

    fun insert(customer: Customer) = viewModelScope.launch{
        repository.insert(customer)
    }

  /*  fun findUser(userId: Int): LiveData<Customer>  {
       return repository.loadUserProfile(userId)
    }*/

}