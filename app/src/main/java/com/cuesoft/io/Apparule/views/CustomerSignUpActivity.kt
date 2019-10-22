package com.cuesoft.io.apparule.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.cuesoft.io.apparule.R
import com.cuesoft.io.apparule.model.Customer
import com.cuesoft.io.apparule.viewmodel.CustomerSignUpViewModel
import kotlinx.android.synthetic.main.registration_page.*

class CustomerSignUpActivity : AppCompatActivity() {

   // var button: Button
   private lateinit var customerSignUpViewModel: CustomerSignUpViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registration_page)

        customerSignUpViewModel = ViewModelProviders.of(this)
            .get(CustomerSignUpViewModel::class.java)

        registerButton.setOnClickListener{
            getCustomerData()
        }
    }

    //method to get customer data from editText
    fun getCustomerData(){

      //Retriving Customer's info from text Fields
      var FirstName : String = firstnameEditText.text.toString()
      var LastName : String = lastnameEditText.text.toString()
      var EmailAddress : String = emailEditText.text.toString()
      var PhoneNumberString : String = phoneNumberEditText.text.toString()

      var customer = Customer( firstname = FirstName, lastname= LastName,
            email = EmailAddress,  phonenumber = PhoneNumberString
      )

      customerSignUpViewModel.insert(customer)

      var intent = Intent(this, BaseActivity::class.java)
      startActivity(intent)
    }


    fun findUser(){
       // customerSignUpViewModel.findUser(1)
    }

}
