package com.example.walmartlogin

import android.content.Intent
import android.graphics.Paint
import android.net.Uri
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import com.example.walmartlogin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView2 = findViewById<TextView>(R.id.forgot_pass_view)
        textView2.paintFlags = Paint.UNDERLINE_TEXT_FLAG
    }

    fun openUrl(view: View) {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.walmart.com/account/login"))
        startActivity(browserIntent);
    }

}