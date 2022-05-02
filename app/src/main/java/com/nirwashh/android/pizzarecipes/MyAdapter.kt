package com.nirwashh.android.pizzarecipes

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nirwashh.android.pizzarecipes.databinding.ItemListBinding

class MyAdapter(listMain: ArrayList<ListItem>, contextMAct: Context) : RecyclerView.Adapter<MyAdapter.MyHolder>() {
    var listArray = listMain
    var context = contextMAct

    inner class MyHolder(private val binding: ItemListBinding, contextHolder: Context) : RecyclerView.ViewHolder(binding.root) {
        val context = contextHolder
        fun setData(item: ListItem) {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyHolder(binding, context)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int = listArray.size


}