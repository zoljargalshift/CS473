package com.example.tablayoutassignment

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.*

class MainActivity : AppCompatActivity() {
    private lateinit var name: EditText
    private lateinit var table: TableLayout
    private lateinit var version: EditText
    private lateinit var button: Button
    @SuppressLint("ResourceAsColor", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        name = findViewById<EditText>(R.id.name)
        table = findViewById<TableLayout>(R.id.table)
        version = findViewById<EditText>(R.id.version)
        button = findViewById<Button>(R.id.add)

        button.setOnClickListener {
            if (version.text.isEmpty() || name.text.isEmpty()) {
                Toast.makeText(applicationContext, "Please enter valid version and code!", Toast.LENGTH_LONG).show()
            } else {
                val row = TableRow(applicationContext)
                val param = TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT)
                row.layoutParams = param
                val first = TextView(this)
                first.text = version.text.toString()
                first.setBackgroundColor(Color.parseColor("#f368e0"))
                val second = TextView(this)
                second.text = name.text.toString()
                second.setBackgroundColor(Color.parseColor("#f368e0"))
                row.addView(first)
                row.addView(second)
                row.setPadding(0, 0, 0, 10)
                table.addView(row)
                version.text.clear()
                name.text.clear()
                Toast.makeText(applicationContext, "Successfully added!", Toast.LENGTH_LONG).show()
            }
        }
    }
}