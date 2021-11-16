package com.example.kotlinwashxproject.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinwashxproject.OnUpcomingClickListener
import com.example.kotlinwashxproject.databinding.ImageSingleListItemBinding
import com.example.kotlinwashxproject.databinding.UpcomingAppointmentItemBinding
import com.example.kotlinwashxproject.model.UpcomingAppointmentList

class UpcomingAppointmentAdapter(private val upcomingAppointmentList: List<UpcomingAppointmentList>, private val context: Context) : RecyclerView.Adapter<UpcomingAppointmentAdapter.UpcomingViewHolder>(){
    lateinit var itemClick : OnUpcomingClickListener


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpcomingAppointmentAdapter.UpcomingViewHolder {
         val itemBinding = UpcomingAppointmentItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
          return UpcomingViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: UpcomingViewHolder, position: Int) {
      val upcomingAppointmentList= upcomingAppointmentList[position]
        holder.bind(upcomingAppointmentList)
        holder.itemView.setOnClickListener {
            itemClick.itemClickListener(upcomingAppointmentList)
        }
    }

    override fun getItemCount(): Int {
        return upcomingAppointmentList.size
    }

    inner class UpcomingViewHolder(private val itemBinding: UpcomingAppointmentItemBinding): RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(upcomingAppointmentList: UpcomingAppointmentList) {
           itemBinding.dateTv.text = upcomingAppointmentList!!.date
            itemBinding.timeTv.text = upcomingAppointmentList.time
            itemBinding.carName.text = upcomingAppointmentList.vehicleName
            itemBinding.priceTv.text = upcomingAppointmentList.amount
            itemBinding.cancelBtn.setOnClickListener {
              itemClick.cancelClickListener(upcomingAppointmentList)
            }
        }

    }

}