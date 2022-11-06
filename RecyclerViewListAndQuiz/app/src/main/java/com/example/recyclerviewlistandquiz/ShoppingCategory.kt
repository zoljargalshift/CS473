package com.example.recyclerviewlistandquiz

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_category_view.*

class ShoppingCategory : AppCompatActivity()  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_view)
        supportActionBar?.title = "Shop by Category"
        var loginEmail = intent.getStringExtra("email")
        loggedIn.text = loginEmail
    }

    fun startCategoryDetail(type: String) {
        val detailIntent = Intent(this, ShoppingDetail::class.java)
        detailIntent.putExtra("TYPE", type)
        startActivity(detailIntent)
    }

    fun onClick(v: View?) {
        when (v?.id) {
            R.id.electronic -> startCategoryDetail(getString(R.string.electronic))
            R.id.clothing -> startCategoryDetail(getString(R.string.clothes))
            R.id.beauty -> startCategoryDetail(getString(R.string.beauty))
            R.id.food -> startCategoryDetail(getString(R.string.food))
            else -> startCategoryDetail("No items")
        }
    }

}