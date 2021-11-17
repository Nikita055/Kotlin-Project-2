package com.example.kotlinwashxproject.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kotlinwashxproject.constant.Constant
import com.example.kotlinwashxproject.databinding.UploadPictureBtmSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class UploadMediaBottomSheet(private val mListener: BottomSheetListener) : BottomSheetDialogFragment(), View.OnClickListener{
    private var binding: UploadPictureBtmSheetBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = UploadPictureBtmSheetBinding.inflate(inflater,container,false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding!!.cameraTxt.setOnClickListener(this)
        binding!!.galleryTxt.setOnClickListener(this)
    }
    override fun onClick(v: View?) {
       if (v == binding!!.cameraTxt){
         mListener.OnItemSelected(Constant.OPEN_CAMERA)
       } else if (v == binding!!.galleryTxt){
         mListener.OnItemSelected(Constant.OPEN_GALLERY)
       }
    }


    interface BottomSheetListener {
        fun OnItemSelected(requestCode:Int)
    }
}

