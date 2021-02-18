package com.example.flowersmvvm.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.flowersmvvm.R
import com.example.flowersmvvm.databinding.FlowerRowBinding
import com.example.flowersmvvm.model.FlowersModel

class FlowersAdapter : RecyclerView.Adapter<FlowersAdapter.FlowersViewHolder>() {

    var flowersList: List<FlowersModel> = emptyList()

    set(value) {
        field = value

        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlowersViewHolder {
        val withDataBinding: FlowerRowBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            FlowersViewHolder.LAYOUT,
            parent,
            false
        )
        return FlowersViewHolder(withDataBinding)
    }

    override fun onBindViewHolder(holder: FlowersViewHolder, position: Int) {
        holder.viewDataBinding.also {
            it.flower = flowersList[position]
        }
    }

    override fun getItemCount(): Int {
        return flowersList.size
    }

    class FlowersViewHolder(val viewDataBinding: FlowerRowBinding): RecyclerView.ViewHolder(viewDataBinding.root) {
        companion object {
            @LayoutRes
            val LAYOUT = R.layout.flower_row
        }
    }


}