package com.example.kotlinwashxproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.kotlinwashxproject.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding : ActivityLoginBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val View = binding.root
        setContentView(View)
        initUit()
    }

    private fun initUit() {
        binding.signInBtn.setOnClickListener {
           startActivity(Intent(this,MainActivity::class.java))
            finish()
        }

        binding.signUpTv.setOnClickListener {
            startActivity(Intent(this,SignUpActivity::class.java))

        }
    }
}