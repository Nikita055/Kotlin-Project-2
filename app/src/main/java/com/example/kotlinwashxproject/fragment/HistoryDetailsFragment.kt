package com.example.kotlinwashxproject.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinwashxproject.R
import com.example.kotlinwashxproject.adapter.UpComingVehicleAdapter
import com.example.kotlinwashxproject.constant.BaseFragment
import com.example.kotlinwashxproject.databinding.FragmentHistoryDetailBinding
import com.example.kotlinwashxproject.model.ChildServiceListModel
import com.example.kotlinwashxproject.model.UpcomingVehicleDetailModel

class HistoryDetailsFragment : BaseFragment() {
   private lateinit var binding: FragmentHistoryDetailBinding
   private val upcpmingVehicleDetailModel : MutableList<UpcomingVehicleDetailModel> = ArrayList()
   private var upcomingVehicleAdapter : UpComingVehicleAdapter? = null

   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      addData()
   }

   private fun addData() {
     val childServiceListModel : MutableList<ChildServiceListModel> = ArrayList()
      childServiceListModel.add(ChildServiceListModel("Silver","$70"))
      childServiceListModel.add(ChildServiceListModel("Sanitization Service","$70"))
      childServiceListModel.add(ChildServiceListModel("Paint Protection","$70"))
       upcpmingVehicleDetailModel.add(UpcomingVehicleDetailModel("Toyoto Fortuner- SUV","White LX001h","$170.00",childServiceListModel))

     val childServiceListModel1 : MutableList<ChildServiceListModel> = ArrayList()
       childServiceListModel1.add(ChildServiceListModel("Silver","$70"))
       childServiceListModel.add(ChildServiceListModel("Sanitization Service","$70"))
       childServiceListModel.add(ChildServiceListModel("Paint Protection","$70"))
       upcpmingVehicleDetailModel.add(UpcomingVehicleDetailModel("Hundai i20- Car","Silver SM001h","$170.00",childServiceListModel1))
   }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi()
    }

    private fun initUi() {
      binding.vehicleRv.layoutManager = LinearLayoutManager(activity,RecyclerView.VERTICAL,false)
      upcomingVehicleAdapter = UpComingVehicleAdapter(upcpmingVehicleDetailModel,requireActivity(),false)
      binding.vehicleRv.adapter = upcomingVehicleAdapter

        binding.viewImgBtn.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_historyDetailsFragment_to_imageHistoryFragment)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHistoryDetailBinding.inflate(layoutInflater)
        showDrawerNav(false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
       val toolbar:androidx.appcompat.widget.Toolbar = requireActivity().findViewById(R.id.toolbar)
        val menuIcon = toolbar.findViewById<ImageView>(R.id.menu_icon)
         menuIcon.visibility = View.GONE
        val logo = toolbar.findViewById<ImageView>(R.id.home_logo)
        logo.visibility = View.GONE
        val back = toolbar.findViewById<ImageView>(R.id.back)
        back.visibility = View.VISIBLE
        val title = toolbar.findViewById<TextView>(R.id.title)
        title.visibility = View.VISIBLE
        title.text = resources.getString(R.string.history)

        back.setOnClickListener {
            navigateUp()
        }
    }
}