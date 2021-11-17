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
import com.example.kotlinwashxproject.OnHistoryClickListener
import com.example.kotlinwashxproject.R
import com.example.kotlinwashxproject.adapter.RecentAppointmentAdapter
import com.example.kotlinwashxproject.constant.BaseFragment
import com.example.kotlinwashxproject.databinding.FragmentHistoryListingBinding
import com.example.kotlinwashxproject.databinding.FragmentHomeBinding
import com.example.kotlinwashxproject.model.UpcomingAppointmentList

class HistoryFragment : BaseFragment(), OnHistoryClickListener {
    private val recentAppointmentList : MutableList<UpcomingAppointmentList> = ArrayList()
     private var recentAppointmentAdapter : RecentAppointmentAdapter? = null
     private lateinit var binding : FragmentHistoryListingBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addData()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentHistoryListingBinding.inflate(layoutInflater)
        showDrawerNav(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi()
    }

    private fun initUi() {
         binding.historyRv.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL,false)
        recentAppointmentAdapter = RecentAppointmentAdapter(recentAppointmentList, requireActivity())
       recentAppointmentAdapter!!.itemClick = this
        binding.historyRv.adapter = recentAppointmentAdapter

    }

    override fun onResume() {
        super.onResume()
        val toolbar:androidx.appcompat.widget.Toolbar= requireActivity().findViewById(R.id.toolbar)
        val menuIcon=toolbar.findViewById<ImageView>(R.id.menu_icon)
        menuIcon.visibility=View.VISIBLE
        val logo=toolbar.findViewById<ImageView>(R.id.home_logo)
        logo.visibility=View.GONE
        val back=toolbar.findViewById<ImageView>(R.id.back)
        back.visibility=View.GONE
        val title=toolbar.findViewById<TextView>(R.id.title)
        title.visibility=View.VISIBLE
        title.text = resources.getString(R.string.history)

    }
    private fun addData() {
        recentAppointmentList.add(UpcomingAppointmentList("16 july, 2021","02:30 PM","Toyoto Fortuner, HyHundai i20","$395.00"))
        recentAppointmentList.add(UpcomingAppointmentList("17 july, 2021","02:30 PM","Toyoto Fortuner, HyHundai i20","$395.00"))
        recentAppointmentList.add(UpcomingAppointmentList("18 july, 2021","02:30 PM","Toyoto Fortuner, HyHundai i20","$395.00"))
        recentAppointmentList.add(UpcomingAppointmentList("16 july, 2021","02:30 PM","Toyoto Fortuner, HyHundai i20","$395.00"))
    }

    override fun recentItemClickListener(position: UpcomingAppointmentList?) {
          view?.findNavController()?.navigate(R.id.action_history_to_historyDetailsFragment)
    }
}