package com.miu.curriculumvitae.data;

import static com.miu.curriculumvitae.data.QuizContract.QuizEntry.COL_CORRECT;
import static com.miu.curriculumvitae.data.QuizContract.QuizEntry.COL_ID;
import static com.miu.curriculumvitae.data.QuizContract.QuizEntry.COL_ANS1;
import static com.miu.curriculumvitae.data.QuizContract.QuizEntry.COL_ANS2;
import static com.miu.curriculumvitae.data.QuizContract.QuizEntry.COL_ANS3;
import static com.miu.curriculumvitae.data.QuizContract.QuizEntry.COL_QUES;
import static com.miu.curriculumvitae.data.QuizContract.QuizEntry.TABLE_NAME;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.miu.curriculumvitae.Question;
import java.util.ArrayList;
import java.util.List;

public class DbHelper extends SQLiteOpenHelper {
	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME = "quiz";
	private SQLiteDatabase dbase;
	public DbHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		dbase=db;
		String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " ( "
				+ COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_QUES
				+ " TEXT, " + COL_CORRECT+ " TEXT, "+COL_ANS1 +" TEXT, "
				+COL_ANS2 +" TEXT, "+COL_ANS3+" TEXT)";
		db.execSQL(sql);		
		addQuestions();
	}

	private void addQuestions()
	{
		Question q1=new Question("1. How do you insert COMMENTS in Kotlin code?","/* This is a comment", "// This is a comment", "-- This is a comment", "// This is a comment");
		this.insertQuestion(q1);
		Question q2=new Question("2. Which keyword is used to declare a function?", "fun", "decl", "function", "fun");
		this.insertQuestion(q2);
		Question q3=new Question("3. How can you create a variable with the numeric value 5?","int num = 5", "val num = 5","num = 5 int", "val num = 5" );
		this.insertQuestion(q3);
		Question q4=new Question("4. How can you create a variable with the floating number 2.8?", "double num = 2.8", "num = 2.8 float", "val num = 2.8","val num = 2.8");
		this.insertQuestion(q4);
		Question q5=new Question("5. Which operator is used to add together two values?","The + sign","The & sign","The * sign","The + sign");
		this.insertQuestion(q5);
		Question q6=new Question("6. What is the output of the following code: println(5 > 3 && 5 < 10)?","false","true","2","true");
		this.insertQuestion(q6);
		Question q7=new Question("7. Which operator can be used to compare two values?","=","><","==","==");
		this.insertQuestion(q7);
		Question q8=new Question("8. Which property can be used to find the length of a string?","The size property","The len property","The length property","The length property");
		this.insertQuestion(q8);
		Question q9=new Question("9. Which symbol is used for string templates/interpolation?","$",".","*","$");
		this.insertQuestion(q9);
		Question q10=new Question("10. To create an array in Kotlin, use","[]","The arrayOf() function","{}","The arrayOf() function");
		this.insertQuestion(q10);
		Question q11=new Question("11. How do you call a function in Kotlin?","myFunction[]","(myFunction)","myFunction()","myFunction()");
		this.insertQuestion(q11);
		Question q12=new Question("12. How do you start writing an if statement in Kotlin?","if x > y then","if x > y()","if (x > y)","if (x > y)");
		this.insertQuestion(q12);
		Question q13=new Question("13. How do you start writing a while loop in Kotlin?","if x > y while","while x < y then","while (x < y)","while (x < y)");
		this.insertQuestion(q13);
		Question q14=new Question("14. Which keyword is used to return a value inside a function?","break","return","void","return");
		this.insertQuestion(q14);
		Question q15=new Question("15. How can you create a range of numbers between 5 and 15 in Kotlin?","for (5..15)","for (x in 5..15)","for (5 to 15)","for (x in 5..15)");
		this.insertQuestion(q15);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
		onCreate(db);
	}

	public void insertQuestion(Question quest) {
		ContentValues values = new ContentValues();
		values.put(COL_QUES, quest.getQUESTION());
		values.put(COL_CORRECT, quest.getCORRECT());
		values.put(COL_ANS1, quest.getANS1());
		values.put(COL_ANS2, quest.getANS2());
		values.put(COL_ANS3, quest.getANS3());
		dbase.insert(TABLE_NAME, null, values);
	}

	public List<Question> getQuestions() {
		List<Question> quesList = new ArrayList<Question>();
		String getAllQuestion = "SELECT  * FROM " + TABLE_NAME;
		dbase=this.getReadableDatabase();
		Cursor cursor = dbase.rawQuery(getAllQuestion, null);
		if (cursor.moveToFirst()) {
			do {
				Question quest = new Question();
				quest.setID(cursor.getInt(0));
				quest.setQUESTION(cursor.getString(1));
				quest.setCORRECT(cursor.getString(2));
				quest.setANS1(cursor.getString(3));
				quest.setANS2(cursor.getString(4));
				quest.setANS3(cursor.getString(5));
				quesList.add(quest);
			} while (cursor.moveToNext());
		}
		return quesList;
	}

}
