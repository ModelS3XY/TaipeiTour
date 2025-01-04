package com.example.taipeitour.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil3.load
import coil3.request.placeholder
import coil3.request.transformations
import coil3.transform.CircleCropTransformation
import coil3.transform.RoundedCornersTransformation
import com.example.taipeitour.R
import com.example.taipeitour.data.Spot
import com.example.taipeitour.databinding.SpotRowBinding
import com.example.taipeitour.viewmodel.SpotViewModel

class SpotAdapter(var spots: List<Spot>, private val onItemClickListener: (Spot) -> Unit): Adapter<SpotAdapter.SpotHolder>() {

    class SpotHolder(var view: SpotRowBinding): ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpotHolder {
        val binding = SpotRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SpotHolder(binding)
    }

    override fun getItemCount(): Int {
        return spots.size
    }

    override fun onBindViewHolder(holder: SpotHolder, position: Int) {
        val name = spots[position].name
        val introduction = spots[position].introduction
        holder.view.txtTitle.text = name
        holder.view.txtDesc.text = introduction
        val haveImage = if (spots[position].images.isNotEmpty()) {
            spots[position].images.first().src
        } else {
            R.drawable.img_load
        }
        holder.view.imgSpot.load(haveImage) {
            placeholder(R.drawable.img_load)
            transformations(RoundedCornersTransformation(16f))
        }
        holder.view.root.setOnClickListener{
            onItemClickListener(spots[position])
        }
    }
}