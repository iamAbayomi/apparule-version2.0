package com.cuesoft.io.apparule

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProviders
import com.cuesoft.io.apparule.fragment.ProfileFragment
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
      var FirstName : String = firstnameEditText.text.toString()
      var LastName : String = lastnameEditText.text.toString()
      var EmailAddress : String = emailEditText.text.toString()
      var PhoneNumberString : String = phoneNumberEditText.text.toString()
//      var PhoneNumber = Integer.parseInt(PhoneNumberString)

      var customer = Customer( firstname = FirstName, lastname= LastName,
            email = EmailAddress,  phonenumber = PhoneNumberString
      )

       customerSignUpViewModel.insert(customer)

        Toast.makeText(this,"Database Built", Toast.LENGTH_LONG)
            .show()


        var intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    fun addProductFragment(){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = supportFragmentManager.beginTransaction()

        val fragment = ProfileFragment()
        fragmentTransaction.replace(R.id.fragment_container, fragment)
        fragmentTransaction.commit()

    }
}
