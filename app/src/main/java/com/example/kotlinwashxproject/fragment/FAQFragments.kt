package com.example.kotlinwashxproject.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.kotlinwashxproject.R
import com.example.kotlinwashxproject.constant.BaseFragment
import com.example.kotlinwashxproject.databinding.FragmentPrivacyPolicyBinding

class FAQFragments:BaseFragment() {
  private lateinit var binding : FragmentPrivacyPolicyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPrivacyPolicyBinding.inflate(layoutInflater)
        showDrawerNav(true)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        val toolbar:androidx.appcompat.widget.Toolbar = requireActivity().findViewById(R.id.toolbar)
        val menuIcon = toolbar.findViewById<ImageView>(R.id.menu_icon)
        menuIcon.visibility = View.VISIBLE
        val logo = toolbar.findViewById<ImageView>(R.id.home_logo)
        menuIcon.visibility = View.GONE
        val back = toolbar.findViewById<ImageView>(R.id.back)
        back.visibility = View.GONE
        val title = toolbar.findViewById<TextView>(R.id.title)
        title.visibility = View.VISIBLE
        title.text = resources.getString(R.string.faq_s)
    }

}