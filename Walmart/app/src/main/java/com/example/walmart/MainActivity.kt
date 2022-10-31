package com.example.walmart

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
    var user_list = ArrayList<User>();
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        forgot_pass_view.paintFlags = Paint.UNDERLINE_TEXT_FLAG
        fillMockData()
        button_signin.setOnClickListener {
            if (isValidated(email.text.toString(), password.text.toString())) {
                val shopping_object = Intent(this, ShoppingCategory::class.java)
                shopping_object.putExtra("email", email.text.toString())
                startActivity(shopping_object)
            } else
                Toast.makeText(applicationContext, "Email or password is not valid!", Toast.LENGTH_LONG).show()
        }

        register_view.setOnClickListener {
            val signUpIntent = Intent(this, RegisterActivity::class.java)
            result.launch(signUpIntent)
        }
    }

    private var result = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data: Intent? = result.data
            val serUser = data!!.getSerializableExtra("user")
            val newUser = serUser as User
            user_list.add(newUser)
        }
    }

    private fun findUserByEmail(email: String): User {
        for (user in user_list) {
            if (user.userName == email) {
                return user
            }
        }
        return User()
    }

    fun forgotPassword(view: View) {
        val inputEmail = email.text.toString()
        val foundUser = findUserByEmail(inputEmail)

        if(foundUser.password.isNotEmpty()) {
            val sendEmail = Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:"))
            sendEmail.putExtra(Intent.EXTRA_EMAIL, arrayOf(inputEmail))
            sendEmail.putExtra(Intent.EXTRA_SUBJECT, "Password reset")
            sendEmail.putExtra(Intent.EXTRA_TEXT, "Your password: ${foundUser.password}")
            startActivity(Intent.createChooser(sendEmail, "Send an email: "))
        } else {
            Toast.makeText(applicationContext, "Not found the user: $inputEmail", Toast.LENGTH_LONG).show()
        }
    }

    private fun fillMockData() {
        var user_1 = User("Zoljargal", "Byambasuren", "zoloo@gmail.com", "123")
        var user_2 = User("Togtokhbayar", "Munkhjargal", "toki@gmail.com", "123")
        var user_3 = User("Mohit", "Sharma", "mohit@gmail.com", "123")
        var user_4 = User("Shophine", "Roshan", "shop@gmail.com", "123")
        var user_5 = User("Abdul", "Kareem", "abdul@gmail.com", "123")
        user_list.add(user_1)
        user_list.add(user_2)
        user_list.add(user_3)
        user_list.add(user_4)
        user_list.add(user_5)
    }

    private fun isValidated(email: String, password: String): Boolean {
        for (user in user_list) {
            if (user.userName == email && user.password == password) {
                return true
            }
        }
        return false
    }
}