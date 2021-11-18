package com.example.kotlinwashxproject.utility

import android.app.Activity
import android.content.DialogInterface
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.kotlinwashxproject.R
import com.example.kotlinwashxproject.model.ServicesList
import com.google.android.material.dialog.MaterialAlertDialogBuilder

object Utils {
    fun showColoredStatusBar(activity: Activity) {
     activity.window.clearFlags(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)
        activity.window.statusBarColor = activity.resources.getColor(R.color.login_background)
    }

     fun getServiceList(): MutableList<ServicesList>{
       val servicesList : MutableList<ServicesList> = ArrayList()
       servicesList.add(ServicesList(R.drawable.group_118,"Cars"))
         servicesList.add(ServicesList(R.drawable.group_120,"Trucks Van, SUV"))
         servicesList.add(ServicesList(R.drawable.group_121,"Exotic"))
         servicesList.add(ServicesList(R.drawable.group_125,"Boats"))
         servicesList.add(ServicesList(R.drawable.group_123,"Airoplane/Jets"))
         servicesList.add(ServicesList(R.drawable.group_124,"Fleet"))
         return servicesList

     }

    fun addFragmentToBackStack(fragment: Fragment, activity: FragmentActivity,containerId : Int){
       val backStateName = fragment.javaClass.name
       val manager = activity.supportFragmentManager
        val fragmentPopped = manager.popBackStackImmediate(backStateName, 0)
         if (!fragmentPopped){//fragment not in back stack, create it.
          val ft = manager.beginTransaction()
           ft.replace(containerId,fragment)
             ft.addToBackStack(backStateName)
             ft.commit()
         }
    }

    fun showAlertDialog(activity: Activity?, title: String?, msg: String?, buttonTitle: String?) {
        val builder = MaterialAlertDialogBuilder(activity!!, R.style.RoundShapeTheme)
        builder.setTitle(title)
            .setMessage(msg)
            .setPositiveButton(buttonTitle) { dialog: DialogInterface, which: Int -> dialog.dismiss() }
            .show()
    }

   /* fun navigateUp(){
        findNavController().navigateUp()
    }*/
}