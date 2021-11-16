package com.example.kotlinwashxproject.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.kotlinwashxproject.MainActivity
import com.example.kotlinwashxproject.R
import com.example.kotlinwashxproject.constant.BaseFragment
import com.example.kotlinwashxproject.databinding.FragmentAddressBinding

class AddAddressFragment : BaseFragment(), View.OnClickListener {
    private var binding : FragmentAddressBinding? = null
    private var isFrom: String? = ""
    private var bundle : Bundle? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         if (arguments != null){
             isFrom = requireArguments().getString("isFrom")
             bundle = arguments
         }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddressBinding.inflate(layoutInflater)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi()
    }

    private fun initUi() {
    binding!!.doneBtn.setOnClickListener(this)
    }

    override fun onResume() {
        super.onResume()
        if(isFrom == "SignUp"){
            val toolbar: androidx.appcompat.widget.Toolbar =
                requireActivity().findViewById(R.id.toolbar)
            val back = toolbar.findViewById<ImageView>(R.id.back)
            back.setOnClickListener {
                requireFragmentManager().popBackStack()
            }
            val title = toolbar.findViewById<TextView>(R.id.title)
            title.text = resources.getString(R.string.add_address)
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
            title.text = resources.getString(R.string.add_address)
            back.setOnClickListener {
              //  navigateUp()
            }
        }
    }

    override fun onClick(v: View?) {
       when(v!!.id){
           R.id.skip,
               R.id.done_btn ->{
                   if (isFrom == "SignUp"){
                       startActivity(Intent(requireActivity(),MainActivity::class.java))
                       requireActivity().finish()
                   }
               }
       }
    }

}
