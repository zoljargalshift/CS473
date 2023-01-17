package com.miu.curriculumvitae;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.miu.curriculumvitae.data.DbHelper;
import java.util.List;

public class QuizActivity extends AppCompatActivity {
	int questionID=0;
	int currentScore=0;
	List<Question> allQuestion;
	Question question;
	TextView viewQuestion;
	RadioButton button1, button2, button3;
	Button nextButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_quiz1);
		DbHelper db=new DbHelper(this);
		allQuestion=db.getQuestions();
		question=allQuestion.get(questionID);
		viewQuestion= findViewById(R.id.textView1);
		button1= findViewById(R.id.radiobutton1);
		button2= findViewById(R.id.radiobutton2);
		button3= findViewById(R.id.radiobutton3);
		nextButton= findViewById(R.id.nextbutton);
		setQuestionView();
		nextButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				RadioGroup rg= findViewById(R.id.radioGroup1);
				RadioButton answer= findViewById(rg.getCheckedRadioButtonId());
				rg.clearCheck();
				if(question.getCORRECT().equals(answer.getText()))
					currentScore++;
				if(questionID<15){
					question=allQuestion.get(questionID);
					setQuestionView();
				}else{
					Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
					Bundle bundle = new Bundle();
					bundle.putInt("score", currentScore);
					intent.putExtras(bundle);
					startActivity(intent);
					finish();
				}
			}
		});
	}

	private void setQuestionView()
	{
		viewQuestion.setText(question.getQUESTION());
		button1.setText(question.getANS1());
		button2.setText(question.getANS2());
		button3.setText(question.getANS3());
		questionID++;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_quiz1, menu);
		return true;
	}

}
