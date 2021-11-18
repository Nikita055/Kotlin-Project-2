package com.example.kotlinwashxproject.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinwashxproject.databinding.ProfileVehicleListItemBinding
import com.example.kotlinwashxproject.model.VehicleListModel
import com.example.kotlinwashxproject.onVehicleItemListener

class ProfileVehicleListAdapter(private val vehicleList:List<VehicleListModel?>,private val context: Context):RecyclerView.Adapter<ProfileVehicleListAdapter.HistoryViewHolder>() {
     lateinit var deleteClick : onVehicleItemListener

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProfileVehicleListAdapter.HistoryViewHolder {
       val itemBinding = ProfileVehicleListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return HistoryViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ProfileVehicleListAdapter.HistoryViewHolder, position: Int) {
       val vehicleList = vehicleList[position]
        holder.bind(vehicleList)
    }

    override fun getItemCount(): Int {
       return vehicleList.size
    }

    inner class HistoryViewHolder (private val itemBinding: ProfileVehicleListItemBinding) : RecyclerView.ViewHolder(itemBinding.root){
        fun bind(vehicleList: VehicleListModel?) {
            itemBinding.vehicleNameTv.text = vehicleList!!.carType
            itemBinding.vehicleModel.text = vehicleList.carModel

            itemBinding.deleteIv.setOnClickListener {
                deleteClick.onDeleteClickListener(position)
            }
        }

    }

}