package com.example.recyclerviewlistandquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_shopping_details.*

class ShoppingDetail : AppCompatActivity() {
    lateinit var itemList: Array<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_details)
        val itemCategory = intent.getStringExtra("TYPE")
        supportActionBar?.title = itemCategory
        itemList = when(itemCategory) {
            getString(R.string.electronic) -> resources.getStringArray(R.array.electronic_list)
            getString(R.string.clothes) -> resources.getStringArray(R.array.clothes_list)
            getString(R.string.beauty) -> resources.getStringArray(R.array.beauty_list)
            else -> resources.getStringArray(R.array.food_list)
        }
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, itemList)
        list.adapter = adapter
        list.setOnItemClickListener {parent, view, position, id ->
            Toast.makeText(applicationContext, parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show()
        }
    }
}