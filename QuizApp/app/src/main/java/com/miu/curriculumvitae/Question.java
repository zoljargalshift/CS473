package com.miu.curriculumvitae;
public class Question {

	private int ID;
	private String QUESTION;
	private String ANS1;
	private String ANS2;
	private String ANS3;
	private String CORRECT;

	public Question()
	{
		ID=0;
		QUESTION="";
		ANS1="";
		ANS2="";
		ANS3="";
		CORRECT="";
	}

	public Question(String question, String ans1, String ans2, String ans3, String correct) {
		QUESTION = question;
		ANS1 = ans1;
		ANS2 = ans2;
		ANS3 = ans3;
		CORRECT = correct;
	}

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public String getQUESTION() {
		return QUESTION;
	}

	public void setQUESTION(String QUESTION) {
		this.QUESTION = QUESTION;
	}

	public String getANS1() {
		return ANS1;
	}

	public void setANS1(String ANS1) {
		this.ANS1 = ANS1;
	}

	public String getANS2() {
		return ANS2;
	}

	public void setANS2(String ANS2) {
		this.ANS2 = ANS2;
	}

	public String getANS3() {
		return ANS3;
	}

	public void setANS3(String ANS3) {
		this.ANS3 = ANS3;
	}

	public String getCORRECT() {
		return CORRECT;
	}

	public void setCORRECT(String CORRECT) {
		this.CORRECT = CORRECT;
	}
}
