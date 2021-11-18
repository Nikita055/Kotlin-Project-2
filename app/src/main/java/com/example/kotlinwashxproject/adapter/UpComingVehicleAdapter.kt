package com.example.kotlinwashxproject.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinwashxproject.databinding.SummaryVehicleListItemBinding
import com.example.kotlinwashxproject.model.UpcomingVehicleDetailModel
import com.example.kotlinwashxproject.onVehicleItemListener

class UpComingVehicleAdapter(private val upcomingVehicleDetailModel: List<UpcomingVehicleDetailModel?>,private val context: Context,private val showDelete:Boolean) : RecyclerView.Adapter<UpComingVehicleAdapter.UpcomingVehicleViewHolder>(){
     private var childAdapter:UpcomingChildAdapter?= null
    lateinit var itemClick : onVehicleItemListener

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UpComingVehicleAdapter.UpcomingVehicleViewHolder {
        val itemBinding = SummaryVehicleListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return UpcomingVehicleViewHolder(itemBinding)
    }


    override fun onBindViewHolder(holder: UpComingVehicleAdapter.UpcomingVehicleViewHolder, position: Int) {
      val upcomingAppointmentList =upcomingVehicleDetailModel[position]
        holder.bind(upcomingAppointmentList)
    }

    override fun getItemCount(): Int {
       return upcomingVehicleDetailModel.size
    }

   inner class UpcomingVehicleViewHolder(private val itemBinding: SummaryVehicleListItemBinding) :RecyclerView.ViewHolder(itemBinding.root){
       fun bind(upcomingAppointmentList: UpcomingVehicleDetailModel?) {
        itemBinding.vehicleModelTv.text = upcomingAppointmentList!!.carModel
           itemBinding.vehicleNameTv.text = upcomingAppointmentList.carType
           itemBinding.amountTv.text = upcomingAppointmentList.subTotal
           itemBinding.amountListRv.layoutManager = LinearLayoutManager(context,RecyclerView.VERTICAL,false)
            childAdapter = UpcomingChildAdapter(upcomingAppointmentList.serviceList,context)
            itemBinding.amountListRv.adapter = childAdapter

           if (showDelete){
             itemBinding.deleteIv.visibility = View.VISIBLE
               itemBinding.deleteIv.setOnClickListener {
                 itemClick.onDeleteClickListener(position)
               }
           }else{
               itemBinding.deleteIv.visibility = View.INVISIBLE
           }
       }

   }

}