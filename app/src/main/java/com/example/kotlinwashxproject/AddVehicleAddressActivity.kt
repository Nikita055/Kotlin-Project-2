package com.example.kotlinwashxproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.kotlinwashxproject.databinding.ActivityAddVehicleAddressBinding
import com.example.kotlinwashxproject.fragment.AddVehicleFragment
import com.example.kotlinwashxproject.utility.Utils.addFragmentToBackStack
import com.example.kotlinwashxproject.utility.Utils.showColoredStatusBar

class AddVehicleAddressActivity : AppCompatActivity() , View.OnClickListener{
    private var binding : ActivityAddVehicleAddressBinding? = null
    private var isFrom = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddVehicleAddressBinding.inflate(layoutInflater)
        val view : View = binding!!.root
        setContentView(view)
        initUi()
    }

    private fun initUi() {
          if (intent.hasExtra("isFrom")){
              isFrom = intent.getStringExtra("isFrom")!!
          }
        /*setSupportActionBar(binding!!.toolbar.toolbar)
        supportActionBar!!.title = null*/

        if (isFrom == "SignUp"){
            val vehicleFragment : Fragment = AddVehicleFragment()
            val bundle = Bundle()
            bundle.putString("isFrom",isFrom)
            vehicleFragment.arguments = bundle
            addFragmentToBackStack(vehicleFragment,this,binding!!.container.id)
        }

    }

    override fun onClick(p0: View?) {

    }
}