package com.example.recyclerviewlistandquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_quiz_view.*
import java.text.SimpleDateFormat
import java.util.*

class Quiz : AppCompatActivity() {
    private val correctAnswer = hashMapOf<String, Int>()
    private val answered = hashSetOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_view)
        supportActionBar?.title = "Quiz App"
        correctAnswer[getString(R.string.answer1)] = 50
        correctAnswer[getString(R.string.question2_answer1)] = 25
        correctAnswer[getString(R.string.question2_answer2)] = 25
        correctAnswer[getString(R.string.question2_answer3)] = -25
        radio.setOnCheckedChangeListener { group, checkedId ->
            val clicked = group.findViewById(checkedId) as RadioButton
            if (clicked.isChecked) {
                if(clicked.text.toString() == getString(R.string.answer1)) answered.add(clicked.text.toString())
                else answered.remove(getString(R.string.answer1))
            }
        }
        question2_answer1.setOnCheckedChangeListener { view, isChecked ->
            checked(isChecked, R.string.question2_answer1)
        }
        question2_answer2.setOnCheckedChangeListener { view, isChecked ->
            checked(isChecked, R.string.question2_answer2)
        }
        question2_answer3.setOnCheckedChangeListener { view, isChecked ->
            checked(isChecked, R.string.question2_answer3)
        }
        submit.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Congratulations!")
            val dateFormat = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
            val submittedOn = dateFormat.format(Date())
            builder.setMessage("""You submitted on $submittedOn, Your achieved: ${calculate()}%""".trimIndent())
            builder.setPositiveButton("Close"){dialogInterface, which ->
                dialogInterface.dismiss()
            }
            val dialog: AlertDialog = builder.create()
            dialog.show()
        }
        reset.setOnClickListener {
            var checkedButton = findViewById<RadioButton>(radio.checkedRadioButtonId);
            if (checkedButton.isChecked) checkedButton.isChecked = false
            question2_answer1.isChecked = false
            question2_answer2.isChecked = false
            question2_answer3.isChecked = false
            answered.clear()
        }
    }

    private fun calculate():Int {
        var totalScore = 0;
        for (answer in answered) {
            if (correctAnswer.containsKey(answer)) totalScore += correctAnswer[answer]!!
        }
        return totalScore;
    }

    private fun checked(isChecked: Boolean, ans: Int) {
        if (isChecked) answered.add(getString(ans))
        else answered.remove(getString(ans))
    }
}