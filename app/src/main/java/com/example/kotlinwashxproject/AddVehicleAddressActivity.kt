package com.example.kotlinwashxproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlinwashxproject.databinding.ActivityAddVehicleAddressBinding

class AddVehicleAddressActivity : AppCompatActivity() {

     private var binding : ActivityAddVehicleAddressBinding?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_vehicle_address)
    }
}