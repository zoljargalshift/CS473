package com.example.recyclerviewlistandquiz

import android.app.Activity
import android.content.Intent
import android.graphics.Paint
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        prob1.setOnClickListener {
            var quizIntent = Intent(this, Quiz::class.java);
            startActivity(quizIntent)
        }
        prob2.setOnClickListener {
            var shopIntent = Intent(this, ShoppingCategory::class.java);
            startActivity(shopIntent)
        }
        prob3.setOnClickListener {
            var recycleIntent = Intent(this, RecyclerView::class.java);
            startActivity(recycleIntent)
        }
    }
}