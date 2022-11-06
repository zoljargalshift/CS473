package com.example.recyclerviewlistandquiz

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_register_view.*

class RegisterActivity : AppCompatActivity() {
    private var user: User = User()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_view)
        supportActionBar?.hide()
        button_register.setOnClickListener {
            if (checkValidation()) {
                Toast.makeText(applicationContext, "Created the account successfully!", Toast.LENGTH_SHORT).show()
                val intent = Intent()
                intent.putExtra("user", user)
                setResult(RESULT_OK, intent)
                finish()
            }
        }
    }

    private fun setInputValues() {
        user.userName = email.text.toString()
        user.firstName = firstname.text.toString()
        user.lastName = lastname.text.toString()
        user.password = password.text.toString()
    }

    private fun checkValidation(): Boolean {
        setInputValues()
        if (user.userName.isEmpty() || user.firstName.isEmpty() || user.lastName.isEmpty() || user.password.isEmpty()) {
            Toast.makeText(applicationContext, "Fill the required fields to create an account", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }
}