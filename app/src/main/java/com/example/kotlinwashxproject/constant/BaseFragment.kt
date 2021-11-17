package com.example.kotlinwashxproject.constant

import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.kotlinwashxproject.R

abstract class BaseFragment : Fragment(){

    fun showDrawerNav(show: Boolean) {
        var drawerNavView = activity?.findViewById<DrawerLayout>(R.id.drawer_layout)
        if (show) {
            drawerNavView?.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
        } else {
            drawerNavView?.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
        }
    }

    fun navigateUp() {
        findNavController().navigateUp()
    }
}