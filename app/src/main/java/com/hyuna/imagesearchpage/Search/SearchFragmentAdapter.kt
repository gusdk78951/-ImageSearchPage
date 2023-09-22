package com.hyuna.imagesearchpage.Search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hyuna.imagesearchpage.Data.ImageSearchDocuments
import com.hyuna.imagesearchpage.databinding.ItemRecyclerviewBinding

class SearchFragmentAdapter(private var data: ArrayList<ImageSearchDocuments>) :
    RecyclerView.Adapter<SearchFragmentAdapter.SearchFragmentHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchFragmentHolder {
        val binding = ItemRecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SearchFragmentHolder(binding)
    }

    override fun onBindViewHolder(holder: SearchFragmentHolder, position: Int) {
        holder.title = data[position].displaySitename

    }

    inner class SearchFragmentHolder(val binding: ItemRecyclerviewBinding) :
        RecyclerView.ViewHolder(binding.root) {
            val title = binding.textViewTitle
            val date = binding.textViewDate
            val url = binding.imageViewSearch
    }
}