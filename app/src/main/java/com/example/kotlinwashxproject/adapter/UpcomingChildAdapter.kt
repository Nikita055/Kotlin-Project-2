package com.example.kotlinwashxproject.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinwashxproject.databinding.VehicleChildListItemBinding
import com.example.kotlinwashxproject.model.ChildServiceListModel

class UpcomingChildAdapter(private val childServiceListModel: List<ChildServiceListModel?>,private val context:Context) : RecyclerView.Adapter<UpcomingChildAdapter.UpcomingChildViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UpcomingChildAdapter.UpcomingChildViewHolder {
       val itemBinding = VehicleChildListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return UpcomingChildViewHolder(itemBinding)

    }

    override fun onBindViewHolder(holder: UpcomingChildAdapter.UpcomingChildViewHolder, position: Int) {
     val upcomingAppointmentList = childServiceListModel[position]
      holder.bind(upcomingAppointmentList)
    }

    override fun getItemCount(): Int {
        return childServiceListModel.size
    }

    inner class UpcomingChildViewHolder(private val itemBinding:VehicleChildListItemBinding) :RecyclerView.ViewHolder(itemBinding.root){
        fun bind(childServiceListModel: ChildServiceListModel?) {
          itemBinding.serviceName.text = childServiceListModel!!.serviceType
            itemBinding.serviceName.text = childServiceListModel.amount
        }

    }

}