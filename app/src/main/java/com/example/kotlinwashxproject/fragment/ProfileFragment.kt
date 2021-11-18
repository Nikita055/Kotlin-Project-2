package com.example.kotlinwashxproject.fragment

import android.Manifest
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.PermissionRequest
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlinwashxproject.R
import com.example.kotlinwashxproject.adapter.ProfileVehicleListAdapter
import com.example.kotlinwashxproject.constant.BaseFragment
import com.example.kotlinwashxproject.constant.Constant
import com.example.kotlinwashxproject.databinding.FragmentProfileBinding
import com.example.kotlinwashxproject.model.VehicleListModel
import com.example.kotlinwashxproject.onVehicleItemListener
import com.example.kotlinwashxproject.utility.FileUtils.getPath
import com.example.kotlinwashxproject.utility.FileUtils.getReadableFileSize
import com.example.kotlinwashxproject.utility.Utils.showAlertDialog
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.multi.MultiplePermissionsListener
import java.io.File

class ProfileFragment : BaseFragment(),onVehicleItemListener, View.OnClickListener,UploadMediaBottomSheet.BottomSheetListener {
     private lateinit var binding : FragmentProfileBinding
     private val vehicleListModel : MutableList<VehicleListModel> = ArrayList()
     private val serviceListModel : MutableList<VehicleListModel> = ArrayList()
     private var vehicleAdapter : ProfileVehicleListAdapter? = null
     private var serviceAddressAdapter : ProfileVehicleListAdapter? = null
     private var imagePath: String = ""
     private var mediaBottomSheet : UploadMediaBottomSheet? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addData()
    }

    private val takeImageResult = registerForActivityResult(ActivityResultContracts.TakePicture()) { isSuccess ->
        if (isSuccess) {
            latestTmpUri?.let { uri ->
                imagePath = getPath(requireActivity(), uri)
                val imageFile = File(imagePath)
                val size = getReadableFileSize(imageFile.length())
                if (size.contains("MB")) {
                    val actualSize = size.substring(0, size.indexOf(" "))
                    if (actualSize.toFloat() > 10) {
                        try {
                            showAlertDialog(activity, "Alert", "Uploaded document should be less than 10 MB", getString(R.string.ok))
                        } catch (e: Exception) {
                            Log.e("TAG", e.toString())
                        }
                        return@registerForActivityResult
                    }
                }
                Glide.with(requireActivity())
                    .load(imagePath)
                    .placeholder(R.drawable.rounded_bg)
                    .circleCrop()
                    .into(binding.imageView10)

//                photosList.add(imagePath)
//                filesListAdapter?.notifyDataSetChanged()
            }
        }
    }

    private var latestTmpUri: Uri? = null

    private var selectImageFromGalleryResult = registerForActivityResult(ActivityResultContracts.GetContent()){ uri:Uri? ->
       uri?.let {
           imagePath = getPath(requireActivity(), uri)
           val imageFile = File(imagePath)
           val size = getReadableFileSize(imageFile.length())
           if (size.contains("MB")) {
               val actualSize = size.substring(0, size.indexOf(" "))
               if (actualSize.toFloat() > 10) {
                   try {
                       showAlertDialog(activity, "Alert", "Uploaded document should be less than 10 MB", getString(R.string.ok))
                   } catch (e: Exception) {
                       Log.e("TAG", e.toString())
                   }
                   return@registerForActivityResult
               }
           }
           Glide.with(requireActivity())
               .load(imagePath)
               .placeholder(R.drawable.rounded_bg)
               .circleCrop()
               .into(binding.imageView10)

       }
    }

    private fun addData() {
       vehicleListModel.add(VehicleListModel("Toyota Fortuner - SUV", "White LX001h",))
        vehicleListModel.add(VehicleListModel("Hundai i20 - Car", "Silver MX001h",))
        serviceListModel.add(VehicleListModel("1901 Thornridge Cir. Shiloh,", "Hawaii 81063",))
        serviceListModel.add(VehicleListModel("1901 Thornridge Cir. Shiloh,", "Hawaii 81063",))

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi()
    }


    private fun initUi() {
       binding.vehicleListRv.layoutManager = LinearLayoutManager(activity,RecyclerView.VERTICAL,false)
        binding.serviceAddressRv.layoutManager = LinearLayoutManager(activity,RecyclerView.VERTICAL,false)
        vehicleAdapter = ProfileVehicleListAdapter(vehicleListModel,requireActivity())
        vehicleAdapter!!.deleteClick
        serviceAddressAdapter = ProfileVehicleListAdapter(serviceListModel,requireActivity())
        serviceAddressAdapter!!.deleteClick
        binding.vehicleListRv.adapter = vehicleAdapter
        binding.serviceAddressRv.adapter = serviceAddressAdapter

        binding.addAddressIv.setOnClickListener(this)
        binding.addVehicleIv.setOnClickListener(this)
        binding.imageView6.setOnClickListener(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(layoutInflater)
        (activity as AppCompatActivity).supportActionBar?.show()
        return binding.root
    }

    override fun onResume() {
        super.onResume()
       val toolbar: androidx.appcompat.widget.Toolbar = requireActivity().findViewById(R.id.toolbar)
        val menuIcon = toolbar.findViewById<ImageView>(R.id.menu_icon)
        menuIcon.visibility = View.VISIBLE
        val logo = toolbar.findViewById<ImageView>(R.id.home_logo)
        logo.visibility = View.GONE
        val back = toolbar.findViewById<ImageView>(R.id.back)
        back.visibility = View.GONE
        val title = toolbar.findViewById<TextView>(R.id.title)
        title.visibility = View.VISIBLE
        title.text = resources.getString(R.string.profile)
    }

    override fun onDeleteClickListener(position: Int) {
         if (vehicleListModel.size>0){
            vehicleListModel.removeAt(position)
            vehicleAdapter!!.notifyDataSetChanged()
         }
    }

    override fun onClick(v: View?) {
        when(v!!.id){
         R.id.add_address_iv -> {

         }
            R.id.add_vehicle_iv -> {

            }

           R.id.imageView6 ->{
              mediaBottomSheet = UploadMediaBottomSheet(this)
               mediaBottomSheet!!.show(requireActivity().supportFragmentManager,"UploadMedia")
           }
        }
    }

    private fun checkForPermission(isCamera: Boolean) {
        Dexter.withContext(requireActivity())
            .withPermissions(
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.CAMERA)
            .withListener(object : MultiplePermissionsListener {
                override fun onPermissionsChecked(report: MultiplePermissionsReport?) {
                    if (report!!.areAllPermissionsGranted()) {
                        if (isCamera) {
                            takeImage()
                        } else {
                            selectImageFromGallery()
                        }
                    }
                }

                override fun onPermissionRationaleShouldBeShown(
                    permissions: MutableList<com.karumi.dexter.listener.PermissionRequest>?, token: PermissionToken?) {
                    token?.continuePermissionRequest()
                }

            }).check()
    }


    private fun takeImage() {
        lifecycleScope.launchWhenStarted {
            getTmpFileUri().let { uri ->
                latestTmpUri = uri
                takeImageResult.launch(uri)
            }
        }
    }


    private fun getTmpFileUri(): Uri {
        val storageDir = requireActivity().getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        val tmpFile = File.createTempFile("tmp_image_file", ".png", storageDir).apply {
            createNewFile()
            deleteOnExit()
        }

        return FileProvider.getUriForFile(requireActivity(), requireActivity().applicationContext.packageName + ".utility.UserWashAppFileProvider", tmpFile)
    }

    private fun selectImageFromGallery() = selectImageFromGalleryResult.launch("image/*")
    override fun OnItemSelected(requestCode: Int) {
        if (requestCode == Constant.OPEN_CAMERA) {
            checkForPermission(true)
        } else if (requestCode == Constant.OPEN_GALLERY) {
            checkForPermission(false)
        }
        mediaBottomSheet!!.dismiss()
    }
    }
