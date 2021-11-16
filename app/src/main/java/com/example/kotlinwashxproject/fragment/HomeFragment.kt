package com.example.kotlinwashxproject.fragment

import com.example.kotlinwashxproject.OnCancelBottomSheetClick
import com.example.kotlinwashxproject.OnHistoryClickListener
import com.example.kotlinwashxproject.OnServiceClickListener
import com.example.kotlinwashxproject.OnUpcomingClickListener
import com.example.kotlinwashxproject.adapter.UpcomingAppointmentAdapter
import com.example.kotlinwashxproject.constant.BaseFragment
import com.example.kotlinwashxproject.databinding.FragmentAddressBinding
import com.example.kotlinwashxproject.databinding.FragmentHomeBinding
import com.example.kotlinwashxproject.model.ServicesList
import com.example.kotlinwashxproject.model.UpcomingAppointmentList

class HomeFragment : BaseFragment() , OnServiceClickListener, OnUpcomingClickListener, OnHistoryClickListener, OnCancelBottomSheetClick {
     private lateinit var binding: FragmentHomeBinding
     private val upcomingAppointmentList : MutableList<UpcomingAppointmentList> = ArrayList()
     private val recentAppointmentList : MutableList<UpcomingAppointmentList> = ArrayList()
     private val servicList : MutableList<ServicesList> = ArrayList()
     private var adapter : UpcomingAppointmentAdapter? = null



    override fun itemClickListener(position: Int) {
        TODO("Not yet implemented")
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