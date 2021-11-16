package com.example.kotlinwashxproject.fragment

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.ImageView
import android.widget.TextView
import com.example.kotlinwashxproject.LoginActivity
import com.example.kotlinwashxproject.R
import com.example.kotlinwashxproject.constant.BaseFragment
import com.example.kotlinwashxproject.databinding.FragmentVehicleDetailsBinding
import com.example.kotlinwashxproject.utility.Utils.addFragmentToBackStack
//https://idapgroup.com/blog/android-arguments-with-kotlin-delegates/
//https://developer.android.com/guide/navigation/navigation-pass-data#kotlin
//https://android--examples.blogspot.com/2019/07/android-kotlin-fragment-pass-arguments.html

class AddVehicleFragment : BaseFragment(), View.OnClickListener {
    private var binding : FragmentVehicleDetailsBinding? = null
    private var arrayAdapter : ArrayAdapter<String>? = null
    private val vehicleType = arrayOf("Sedan","SUV","CrossOver","Convertible")
    private var isFrom : String? = ""
    private var bundle : Bundle? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         if(arguments != null){
             isFrom = requireArguments().getString("isFrom")
             bundle = arguments
         }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentVehicleDetailsBinding.inflate(layoutInflater)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi()
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun initUi() {
    arrayAdapter = ArrayAdapter(requireContext(),R.layout.text_list_item,vehicleType)
      binding!!.vehicleTypeTel.editText!!.inputType = 0
        (binding!!.vehicleTypeTel.editText as AutoCompleteTextView?)!!.setAdapter(arrayAdapter)
        (binding!!.vehicleTypeTel.editText as AutoCompleteTextView?)!!.keyListener = null
        (binding!!.vehicleTypeTel.editText as AutoCompleteTextView?)!!.setOnTouchListener(
            View.OnTouchListener { v, event ->
                (v as AutoCompleteTextView).showDropDown()
                return@OnTouchListener false
            })
        (binding!!.vehicleTypeTel.editText as AutoCompleteTextView?)!!.setOnTouchListener(
            View.OnTouchListener{ v, event ->
                (v as AutoCompleteTextView).showDropDown()
                return@OnTouchListener false
            })
          binding!!.doneBtn.setOnClickListener(this)
    }


    override fun onResume() {
        super.onResume()
       if (isFrom == "SignUp"){
         val toolbar: androidx.appcompat.widget.Toolbar =
             requireActivity().findViewById(R.id.toolbar)
         val back = toolbar.findViewById<ImageView>(R.id.back)
           back.setOnClickListener {
               startActivity(Intent(requireActivity(),LoginActivity::class.java))
               requireActivity().finish()
           }
           val title = toolbar.findViewById<TextView>(R.id.title)
           title.text = resources.getString(R.string.add_vehicle_detail)
           val skip = toolbar.findViewById<TextView>(R.id.skip)
           skip.setOnClickListener(this)
       }else{
           val toolbar: androidx.appcompat.widget.Toolbar =
               requireActivity().findViewById(R.id.toolbar)
           val menuIcon = toolbar.findViewById<ImageView>(R.id.menu_icon)
           menuIcon.visibility = View.GONE
           val logo = toolbar.findViewById<ImageView>(R.id.home_logo)
           logo.visibility = View.GONE
           val back = toolbar.findViewById<ImageView>(R.id.back)
           back.visibility = View.VISIBLE
           val title = toolbar.findViewById<TextView>(R.id.title)
           title.visibility = View.VISIBLE
           title.text = resources.getString(R.string.add_vehicle_detail)
           back.setOnClickListener {
              // navigateUp()
           }
       }
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.skip,
            R.id.done_btn -> {
                if (isFrom == "SignUp"){
                  val bundle = Bundle()
                   val targetFragment = AddAddressFragment()
                    bundle.putString("isFrom","SignUp")
                    targetFragment.arguments = bundle
                    addFragmentToBackStack(targetFragment, requireActivity(),R.id.container)
                }

            }
        }
    }


}
