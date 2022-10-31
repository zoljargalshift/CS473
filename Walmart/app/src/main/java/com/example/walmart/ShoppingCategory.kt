package com.example.walmart

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_shopping_category.*

class ShoppingCategory : AppCompatActivity()  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_category)
        supportActionBar?.title = "Shop by Category"
        var loginEmail = intent.getStringExtra("email")
        loggedIn.text = loginEmail
    }

    private fun alert(text: String) {
        Toast.makeText(applicationContext, "You have chosen the $text category of shopping", Toast.LENGTH_SHORT).show()
    }

    fun onClick(v: View?) {
        when (v?.id) {
            R.id.electronic -> alert(getString(R.string.electronic))
            R.id.clothing -> alert(getString(R.string.clothes))
            R.id.beauty -> alert(getString(R.string.beauty))
            R.id.food -> alert(getString(R.string.food))
            else -> alert("No items")
        }
    }

}