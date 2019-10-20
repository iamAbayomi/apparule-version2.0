package com.cuesoft.io.apparule

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.cuesoft.io.apparule.model.Customer
import com.cuesoft.io.apparule.viewmodel.CustomerSignUpViewModel
import kotlinx.android.synthetic.main.user_profile.*

class MainActivity : AppCompatActivity() {

    private lateinit var customerSignUpViewModel : CustomerSignUpViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_profile)

        var firstCustomer : Customer

       customerSignUpViewModel = ViewModelProviders.of(this)
           .get(CustomerSignUpViewModel::class.java)

        customerSignUpViewModel.allcustomers.observe( this, Observer {
            customer ->

            firstCustomer =  customer

            firstnameView.text = firstCustomer.firstname
            secondnameView.text = customer.lastname
            emailView.text = customer.email
            phonenumberView.text = customer.phonenumber


        )
    }



}
