package com.example.kotlinwashxproject.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinwashxproject.OnHistoryClickListener
import com.example.kotlinwashxproject.databinding.RecentServiceItemBinding
import com.example.kotlinwashxproject.model.UpcomingAppointmentList

class RecentAppointmentAdapter(private val upcomingAppointmentList: List<UpcomingAppointmentList?>, private val context: Context) : RecyclerView.Adapter<RecentAppointmentAdapter.RecentViewHolder>() {
    lateinit var itemClick : OnHistoryClickListener


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecentViewHolder {
       val itemBinding = RecentServiceItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
       return RecentViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: RecentViewHolder, position: Int) {
      val upcomingAppointmentList = upcomingAppointmentList[position]
       holder.bind(upcomingAppointmentList)
         holder.itemView.setOnClickListener {
           itemClick.recentItemClickListener(upcomingAppointmentList)
         }
    }

    override fun getItemCount(): Int {
        return upcomingAppointmentList.size
    }

    class RecentViewHolder(private val itemBinding: RecentServiceItemBinding):RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(upcomingAppointmentList: UpcomingAppointmentList?) {
            itemBinding.dateTv.text = upcomingAppointmentList!!.date
            itemBinding.timeTv.text = upcomingAppointmentList.time
            itemBinding.carName.text = upcomingAppointmentList.vehicleName
            itemBinding.priceTv.text = upcomingAppointmentList.amount
        }

    }

}