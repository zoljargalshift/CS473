package com.miu.curriculumvitae

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.miu.curriculumvitae.common.Person
import kotlinx.android.synthetic.main.activity_login.*
import com.miu.curriculumvitae.common.*

class LoginActivity : AppCompatActivity() {
    val KEY = "user"
    val PREF = "cvapp"
    var users = ArrayList<Person>();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        createPerson()

        val prefs = getSharedPreferences(PREF, MODE_PRIVATE)

        if (prefs.getBoolean("auth", false)) {
            val email = prefs.getString("email", "")
            if (email != null) {
                val foundUser = findUserByEmail(email)
                if(foundUser != null) {
                    startMainActivity(foundUser)
                }
            }
        }

        login.setOnClickListener {
            val inputEmail = et_email.text.toString()
            if (isValidated(inputEmail, et_password.text.toString())) {
                val editor = prefs.edit()

                editor.putBoolean("auth", true)
                editor.putString("email", inputEmail)
                editor.apply()

                val foundUser = findUserByEmail(inputEmail)
                if(foundUser != null) {
                    startMainActivity(foundUser)
                }


            } else {
                Toast.makeText(applicationContext, "Wrong credential", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun startMainActivity(person: Person) {
        var mainIntent = Intent(applicationContext, MainActivity::class.java)

        mainIntent.putExtra(KEY, person)
        startActivity(mainIntent)
    }

    private fun isValidated(email: String, password: String): Boolean {
        for (user in users) {
            if (user.contact.email == email && user.password == password) {
                return true
            }
        }
        return false
    }

    private fun findUserByEmail(email: String): Person? {
        for (user in users) {
            if (user.contact.email == email) {
                println(user.contact.email)
                return user
            }
        }
        return null
    }

    fun createPerson() {
        var contactInfo: Contact = Contact("(202) 428-8416", "zbyambasuren@miu.edu")
        var educationFirst: Education = Education("2011-2015","B.S. Computer Science","University of Science and Technology")
        var educationLast: Education = Education("2021-2023","M.S. Computer Science","Maharishi International University")
        var projectFirst: Project = Project("2015-2021","ERP development project", "Fullstack Developer")
        var projectLast: Project = Project("2009-2010","Time Attendance system project", "Backend Developer")
        var workInfo: Work = Work("2015-2021", "ITZONE LLC","Software Engineer")
        var certificateInfo: ArrayList<String> = arrayListOf("GCP Cloud Architecture Certification (2016-12)", "Oracle Certified Expert Certification (2018-04)", "Microsoft 360 Certified Certification (2020-05)", "Azure Developer Associate Certificate (2021-07)")
        var skillInfo: ArrayList<String> = arrayListOf("Angular", "ReactJS", "Spring Boot")

        var person:Person = Person(R.drawable.zoloo, "Zoljargal", "Byambasuren", "123", "Fullstack Developer", "Highly motivated, dedicated Software Engineer with 6+ years of experience in the development and continuous maintenance of web, mobile, and desktop applications using Java, C#, Spring Boot, JavaScript, React, and React Native. Hand-on experience in developing ERP and financial systems. Proven ability to collaborate with team members and as well as writing efficient and reusable code with problem-solving skills.\n", certificateInfo, skillInfo, arrayListOf(educationFirst, educationLast),contactInfo, arrayListOf(projectFirst,projectLast), arrayListOf(workInfo))
        users.add(person)
    }
}