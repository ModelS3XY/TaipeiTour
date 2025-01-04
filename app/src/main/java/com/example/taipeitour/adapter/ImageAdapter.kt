package com.example.taipeitour.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil3.load
import coil3.request.ImageRequest
import coil3.request.placeholder
import coil3.request.transformations
import coil3.transform.RoundedCornersTransformation
import com.example.taipeitour.R
import com.example.taipeitour.data.SpotImage
import com.example.taipeitour.databinding.ImagRowBinding

class ImageAdapter(val images: List<SpotImage>): Adapter<ImageAdapter.ImageViewHolder>(){
    class ImageViewHolder(var view: ImagRowBinding): ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val binding = ImagRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ImageViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return if (images.size == 0) {
            1
        } else {
            images.size
        }

    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        if (images.isNotEmpty()) {
            holder.view.spotImg.load(images[position].src) {
                transformations(RoundedCornersTransformation(16f))
            }
        } else {
            holder.view.spotImg.load(R.drawable.img_load) {
                transformations(RoundedCornersTransformation(16f))
            }
        }

    }
}

