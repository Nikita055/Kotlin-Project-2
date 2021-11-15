package com.example.kotlinwashxproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlinwashxproject.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    private lateinit var bind:ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bind = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(bind.root)
        initUi()
    }

    private fun initUi() {
      bind.signUpBtn.setOnClickListener {
          val addDetails = Intent(this, AddVehicleAddressActivity::class.java)
          addDetails.putExtra("isFrom","SignUp")
          startActivity(addDetails)
          finishAffinity()
      }

        bind.signInTv.setOnClickListener {
          finish()
        }
    }


}