package com.example.kotlinwashxproject

import com.example.kotlinwashxproject.model.PackageListModel
import com.example.kotlinwashxproject.model.UpcomingAppointmentList

interface OnServiceClickListener {
    fun itemClickListener(position:Int)
}

interface OnUpcomingClickListener{
    fun cancelClickListener(position: UpcomingAppointmentList)
    fun itemClickListener(position: UpcomingAppointmentList)
}

interface PackageClickListener{
    fun itemClickListener(position:PackageListModel)
}

interface OnHistoryClickListener{
    fun recentItemClickListener(position: UpcomingAppointmentList?)
}

interface onVehicleItemListener{
    fun onDeleteClickListener(position: Int)
}

interface onAnotherServiceListener{
    fun onServiceClickListener(position:Int)
}

interface OnAppointmentBottomClick{
    fun upComingBottomClickListener()
}

interface OnCancelBottomSheetClick{
   fun onGoBackButtonClick()
}