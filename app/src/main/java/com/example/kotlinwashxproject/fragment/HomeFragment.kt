package com.example.kotlinwashxproject.fragment

import android.media.Image
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinwashxproject.*
import com.example.kotlinwashxproject.adapter.RecentAppointmentAdapter
import com.example.kotlinwashxproject.adapter.ServiceAdapter
import com.example.kotlinwashxproject.adapter.UpcomingAppointmentAdapter
import com.example.kotlinwashxproject.bottomsheet.CancelBottomSheet
import com.example.kotlinwashxproject.constant.BaseFragment
import com.example.kotlinwashxproject.databinding.FragmentAddressBinding
import com.example.kotlinwashxproject.databinding.FragmentHomeBinding
import com.example.kotlinwashxproject.model.ServicesList
import com.example.kotlinwashxproject.model.UpcomingAppointmentList
import com.example.kotlinwashxproject.utility.Utils.getServiceList

class HomeFragment : BaseFragment() , OnServiceClickListener, OnUpcomingClickListener, OnHistoryClickListener, OnCancelBottomSheetClick {
     private lateinit var binding: FragmentHomeBinding
     private val upcomingAppointmentList : MutableList<UpcomingAppointmentList> = ArrayList()
     private val recentAppointmentList : MutableList<UpcomingAppointmentList> = ArrayList()
     private val servicList : MutableList<ServicesList> = ArrayList()
     private var adapter : UpcomingAppointmentAdapter? = null
     private var recentAppointmentAdapter : RecentAppointmentAdapter? = null
     private lateinit var serviceAdapter: ServiceAdapter
     private var cancelationBottomsheet : CancelBottomSheet?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addData()
    }

    private fun addData() {
      upcomingAppointmentList.add(UpcomingAppointmentList("16 july, 2021","02:30 PM","Toyoto Fortuner, HyHundai i20","$395.00"))
        upcomingAppointmentList.add(UpcomingAppointmentList("17 july, 2021","02:30 PM","Toyoto Fortuner, HyHundai i20","$395.00"))
        upcomingAppointmentList.add(UpcomingAppointmentList("18 july, 2021","02:30 PM","Toyoto Fortuner, HyHundai i20","$395.00"))
        upcomingAppointmentList.add(UpcomingAppointmentList("19 july, 2021","02:30 PM","Toyoto Fortuner, HyHundai i20","$395.00"))
        recentAppointmentList.add(UpcomingAppointmentList("16 july, 2021","02:30 PM","Toyoto Fortuner, HyHundai i20","$395.00"))
        recentAppointmentList.add(UpcomingAppointmentList("17 july, 2021","02:30 PM","Toyoto Fortuner, HyHundai i20","$395.00"))
        recentAppointmentList.add(UpcomingAppointmentList("18 july, 2021","02:30 PM","Toyoto Fortuner, HyHundai i20","$395.00"))
        recentAppointmentList.add(UpcomingAppointmentList("19 july, 2021","02:30 PM","Toyoto Fortuner, HyHundai i20","$395.00"))

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentHomeBinding.inflate(layoutInflater)
        showDrawerNav(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
         initUi()
    }

    private fun initUi() {
       binding.upcomingRv.layoutManager = LinearLayoutManager(activity, RecyclerView.HORIZONTAL,false)
        adapter = UpcomingAppointmentAdapter(upcomingAppointmentList, requireActivity())
        adapter!!.itemClick = this
        binding.upcomingRv.adapter = adapter

        binding.recentRv.layoutManager = LinearLayoutManager(activity,RecyclerView.HORIZONTAL,false)
        recentAppointmentAdapter = RecentAppointmentAdapter(recentAppointmentList, requireActivity())
        adapter!!.itemClick = this
        binding.recentRv.adapter = adapter

       binding.servicesRv.layoutManager = GridLayoutManager(activity,3,RecyclerView.VERTICAL,false)
       serviceAdapter = ServiceAdapter(getServiceList(),requireActivity())
        serviceAdapter.itemClick = this
        binding.servicesRv.adapter = serviceAdapter

    }

    override fun onResume() {
        super.onResume()
        val toolbar : androidx.appcompat.widget.Toolbar = requireActivity().findViewById(R.id.toolbar)
        val menuIcon = toolbar.findViewById<ImageView>(R.id.menu_icon)
        menuIcon.visibility = View.VISIBLE
        val logo = toolbar.findViewById<ImageView>(R.id.home_logo)
        logo.visibility = View.VISIBLE
        val back = toolbar.findViewById<ImageView>(R.id.back)
        back.visibility = View.GONE
        val title = toolbar.findViewById<TextView>(R.id.title)
        title.visibility = View.GONE
    }

    override fun itemClickListener(position: Int) {
        view?.findNavController()?.navigate(R.id.)
    }

    override fun cancelClickListener(position: UpcomingAppointmentList) {
        TODO("Not yet implemented")
    }

    override fun itemClickListener(position: UpcomingAppointmentList) {
        TODO("Not yet implemented")
    }

    override fun recentItemClickListener(position: UpcomingAppointmentList?) {
        TODO("Not yet implemented")
    }

    override fun onGoBackButtonClick() {
        TODO("Not yet implemented")
    }
}