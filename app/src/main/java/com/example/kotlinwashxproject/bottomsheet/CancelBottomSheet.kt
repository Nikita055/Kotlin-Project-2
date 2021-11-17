package com.example.kotlinwashxproject.bottomsheet

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kotlinwashxproject.OnCancelBottomSheetClick
import com.example.kotlinwashxproject.R
import com.example.kotlinwashxproject.databinding.CancelationBottomsheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class CancelBottomSheet : BottomSheetDialogFragment() {
    private var binding : CancelationBottomsheetBinding ? = null
    lateinit var OnClick : OnCancelBottomSheetClick

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.MyBottomSheetDialogTheme)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = CancelationBottomsheetBinding.inflate(inflater,container,false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
      dialog!!.setOnShowListener {
          val dialog = it as BottomSheetDialog
          val bottomSheet = dialog.findViewById<View>(R.id.design_bottom_sheet)
          bottomSheet?.let { sheet ->
              dialog.behavior.peekHeight = sheet.height
              sheet.parent.parent.requestLayout()
          }
      }

     binding!!.backBtn
    }
}