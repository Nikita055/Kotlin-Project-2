package com.example.kotlinwashxproject.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.ui.NavigationUI.navigateUp
import com.example.kotlinwashxproject.R
import com.example.kotlinwashxproject.constant.BaseFragment
import com.example.kotlinwashxproject.databinding.FragmentContactUsBinding

class ContactUsFragment : BaseFragment() {
     private var arrayAdapter : ArrayAdapter<String>? = null
     private val lookingFor = arrayOf("One","Two","Three","Four")
    private lateinit var binding : FragmentContactUsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentContactUsBinding.inflate(layoutInflater)
       showDrawerNav(false)
         return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi()
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun initUi() {
     arrayAdapter = ArrayAdapter(requireContext(), R.layout.text_list_item,lookingFor)
      binding.lookingForTel.editText!!.inputType = 0
        (binding.lookingForTel.editText as AutoCompleteTextView)!!.setAdapter(arrayAdapter)
        (binding.lookingForTel.editText as AutoCompleteTextView)!!.keyListener = null
        (binding.lookingForTel.editText as AutoCompleteTextView)!!.setOnTouchListener(View.OnTouchListener { v, event ->
            (v as AutoCompleteTextView).showDropDown()
            return@OnTouchListener false
        })

    }

    override fun onResume() {
        super.onResume()
        val toolbar:androidx.appcompat.widget.Toolbar= requireActivity().findViewById(R.id.toolbar)
        val menuIcon=toolbar.findViewById<ImageView>(R.id.menu_icon)
        menuIcon.visibility= View.GONE
        val logo=toolbar.findViewById<ImageView>(R.id.home_logo)
        logo.visibility= View.GONE
        val back=toolbar.findViewById<ImageView>(R.id.back)
        back.visibility= View.VISIBLE
        val title=toolbar.findViewById<TextView>(R.id.title)
        title.visibility= View.VISIBLE
        title.text = resources.getString(R.string.contact_us)

        back.setOnClickListener {
            navigateUp()
        }
    }
}