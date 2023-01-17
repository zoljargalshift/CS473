package com.miu.curriculumvitae.data;

import android.provider.BaseColumns;

public class QuizContract {
    public static class QuizEntry implements BaseColumns {
        public static final String TABLE_NAME = "quest";
        public static final String COL_ID = "id";
        public static final String COL_QUES = "question";
        public static final String COL_CORRECT = "correct";
        public static final String COL_ANS1= "ans1";
        public static final String COL_ANS2= "ans2";
        public static final String COL_ANS3= "ans3";
    }
}
