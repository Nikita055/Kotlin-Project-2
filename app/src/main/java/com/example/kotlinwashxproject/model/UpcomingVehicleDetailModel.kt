package com.example.kotlinwashxproject.model

data class UpcomingVehicleDetailModel(
    val carType:String,
    val carModel:String,
    val subTotal:String,
    val serviceList:List<ChildServiceListModel>
)
