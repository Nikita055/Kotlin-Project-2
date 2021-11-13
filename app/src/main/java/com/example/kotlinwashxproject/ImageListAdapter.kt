package com.example.kotlinwashxproject

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlinwashxproject.databinding.ImageSingleListItemBinding

class ImageListAdapter (val imageList:MutableList<Int>, private val context: Context)  : RecyclerView.Adapter<ImageListAdapter.ImageHistoryViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageHistoryViewHolder {
        val itemBinding = ImageSingleListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ImageHistoryViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ImageHistoryViewHolder, position: Int) {
        val imageList = imageList[position]
         holder.bind(imageList)
    }

    override fun getItemCount(): Int {
        return imageList.size
    }

    inner class ImageHistoryViewHolder(private val itemBinding: ImageSingleListItemBinding):
        RecyclerView.ViewHolder(itemBinding.root)
    {
           fun bind(image: Int?){
            Glide.with(context).load(image).placeholder(R.drawable.rounded_bg).into(itemBinding.imageView11)
           }

    }
}