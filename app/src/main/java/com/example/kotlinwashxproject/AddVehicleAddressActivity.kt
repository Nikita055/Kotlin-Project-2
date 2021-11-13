package com.example.kotlinwashxproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.kotlinwashxproject.databinding.ActivityAddVehicleAddressBinding

class AddVehicleAddressActivity : AppCompatActivity() {

     private var binding : ActivityAddVehicleAddressBinding?= null
     private var isForm = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddVehicleAddressBinding.inflate(layoutInflater)
        val view : View = binding!!.root
        setContentView(view)
        initUi()
    }

    private fun initUi() {
     if (intent.hasExtra("isForm")){
       isForm = intent.getStringExtra("isForm")!!
     }
        setSupportActionBar(binding!!.toolbar.toolbar)
        supportActionBar!!.title = null

      if (isForm == "SignUp"){
          
      }
    }
}