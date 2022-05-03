package com.nirwashh.android.pizzarecipes

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nirwashh.android.pizzarecipes.databinding.ItemListBinding

class MyAdapter(listMain: ArrayList<ListItem>, contextMAct: Context) : RecyclerView.Adapter<MyAdapter.MyHolder>() {
    var listArray = listMain
    var context = contextMAct

    inner class MyHolder( val binding: ItemListBinding, contextHolder: Context) : RecyclerView.ViewHolder(binding.root) {
        val context = contextHolder
        fun setData(item: ListItem) {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyHolder(binding, context)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        with(holder) {
            with(listArray[position]) {
                binding.tvTitle.text = title
                val descText = desc.substring(0, 50) + "..."
                binding.tvDescription.text = descText
                binding.imgPizza.setImageResource(image)
            }
        }
    }

    override fun getItemCount(): Int = listArray.size


}