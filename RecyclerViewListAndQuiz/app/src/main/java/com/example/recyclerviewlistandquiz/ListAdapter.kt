package com.example.recyclerviewlistandquiz

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_item_view.view.*

class ListAdapter(var productList:ArrayList<Product>, val mItemClickListener:ItemClickListener): RecyclerView.Adapter<ListAdapter.ListViewHolder>() {
    interface ItemClickListener{
        fun onItemClick(position: Int)
    }

    inner class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnClickListener{
                mItemClickListener.onItemClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListAdapter.ListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_item_view, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListAdapter.ListViewHolder, position: Int) {
        holder.itemView.image.setImageResource(productList[position].image)
        holder.itemView.title.text = productList[position].title
        holder.itemView.price.text = "Price: $${productList[position].price}"
        holder.itemView.color.text = "Color: ${productList[position].color}"
    }

    override fun getItemCount(): Int {
        return productList.size
    }
}