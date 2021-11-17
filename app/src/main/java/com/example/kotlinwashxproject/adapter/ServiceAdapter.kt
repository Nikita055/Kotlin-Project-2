package com.example.kotlinwashxproject.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlinwashxproject.OnServiceClickListener
import com.example.kotlinwashxproject.R
import com.example.kotlinwashxproject.databinding.ServiceItemBinding
import com.example.kotlinwashxproject.model.ServicesList

class ServiceAdapter(private val serviceList: List<ServicesList?>, val context:Context): RecyclerView.Adapter<ServiceAdapter.ServiceViewHolder>() {
     lateinit var itemClick : OnServiceClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiceAdapter.ServiceViewHolder {
        val itemBinding = ServiceItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ServiceViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ServiceAdapter.ServiceViewHolder, position: Int) {
        val servicesList = serviceList[position]
        holder.bind(servicesList)
        holder.itemView.setOnClickListener {
          itemClick.itemClickListener(position)
        }

    }

    override fun getItemCount(): Int {
        return serviceList.size
    }

   inner class ServiceViewHolder(private val itemBinding:ServiceItemBinding):RecyclerView.ViewHolder(itemBinding.root) {
       fun bind(servicesList: ServicesList?) {
           itemBinding.serviceName.text = servicesList!!.serviceName
          Glide.with(context)
              .load(servicesList.serviceIcon)
              .placeholder(R.drawable.rounded_bg)
              .circleCrop()
              .into(itemBinding.serviceIcon)
       }

   }
}