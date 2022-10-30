package com.example.mobiledeviceassignments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var inputValue: EditText
    private lateinit var decideValue: TextView
    private var foods =  ArrayList<String>(arrayListOf("Hamburger", "Pizza", "Mexican" , "American", "Chinese"))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inputValue = findViewById<EditText>(R.id.input_new_food)
        decideValue = findViewById<TextView>(R.id.foods)
    }

    fun addFood(view: View) {
        val inputVal = inputValue.text.toString()
        var alertValue = "The $inputVal is added!"
        if (inputVal.isNotEmpty()) {
            foods.add(inputVal);
            inputValue.text.clear()
        } else
            alertValue = "Insert the new food!"

        val msg = Toast.makeText(applicationContext, alertValue, Toast.LENGTH_LONG)
        msg.show()
    }

    fun decideFood(view: View) {
        decideValue.text = foods.random();
    }

}