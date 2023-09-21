package com.hyuna.imagesearchpage.RectclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hyuna.imagesearchpage.databinding.ActivityMainBinding
import com.hyuna.imagesearchpage.databinding.ItemRecyclerviewBinding

class RecyclerViewAdapter(val rvItems: MutableList<RecyclerViewItem>)
    : RecyclerView.Adapter<RecyclerViewAdapter.Holder>() {

    interface ItemClick {
        fun onClick(view : View, position: Int)
    }

    var itemClick : ItemClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemRecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.itemView.setOnClickListener {
            itemClick?.onClick(it, position)
        }
        holder.image.setImageResource(rvItems[position].Image)
        holder.title.text = rvItems[position].Title
        holder.date.text = rvItems[position].Date
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemCount(): Int {
        return rvItems.size
    }

    inner class Holder(val binding: ItemRecyclerviewBinding) : RecyclerView.ViewHolder(binding.root) {
        val image = binding.imageViewSearch
        val title = binding.textViewTitle
        val date = binding.textViewDate
    }
}