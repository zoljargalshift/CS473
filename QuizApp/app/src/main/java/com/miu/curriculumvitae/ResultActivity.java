package com.miu.curriculumvitae;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);
		RatingBar bar= findViewById(R.id.ratingBar1);
		bar.setNumStars(15);
		bar.setStepSize(1.0f);
		TextView t= findViewById(R.id.textResult);
		Bundle bundle = getIntent().getExtras();
		int score= bundle.getInt("score");
		bar.setRating(score);

		if(score > 9)
			t.setText("Total Score: " + score + ", Good Enough!");
		else if(score == 15)
			t.setText("Total Score: " + score + ", Perfect Score!");
		else
			t.setText("Total Score: " + score + ", Not Passed!");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_result, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int itemId = item.getItemId();
		if (itemId == R.id.action_settings) {
			Intent settingsIntent = new Intent(this, QuizActivity.class);
			startActivity(settingsIntent);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
