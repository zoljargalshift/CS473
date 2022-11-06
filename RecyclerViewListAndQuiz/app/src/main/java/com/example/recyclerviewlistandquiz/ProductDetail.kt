package com.example.recyclerviewlistandquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_details_view.*

class ProductDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_view)
        val currentProduct = intent.getSerializableExtra("PRODUCT") as Product
        supportActionBar?.title = currentProduct.title
        productImage.setImageResource(currentProduct.image)
        productTitle.text = currentProduct.title
        productColor.text = "Color: ${currentProduct.color}"
        productId.text = "Product id: ${currentProduct.itemId}"
        productDesc.text = "Description: ${currentProduct.desc}"
    }
}