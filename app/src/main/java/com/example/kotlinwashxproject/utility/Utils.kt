package com.example.kotlinwashxproject.utility

import android.app.Activity
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.kotlinwashxproject.R

object Utils {
    fun showColoredStatusBar(activity: Activity) {
     activity.window.clearFlags(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)
        activity.window.statusBarColor = activity.resources.getColor(R.color.login_background)
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


   /* fun navigateUp(){
        findNavController().navigateUp()
    }*/
}