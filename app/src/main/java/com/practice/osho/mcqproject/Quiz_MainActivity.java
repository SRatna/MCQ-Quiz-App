package com.practice.osho.mcqproject;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Quiz_MainActivity extends AppCompatActivity {

    private TextView tv_questionNo;
    private TextView tv_question;
    private TextView tv_ans1;
    private TextView tv_ans2;
    private TextView tv_ans3;
    private TextView tv_ans4;
    private TextView tv_score;
    private TextView btn_next;
    private int qNo;
    private int j=1;
    private static int i;
    private static int score=0;
    private final int Q_NO=8;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_activity_main);
        Bundle qno=this.getIntent().getExtras();
        qNo=qno.getInt("Qno");
        i=qNo;
        initialize();
        setQuestions();
    }
    public void initialize(){
        tv_ans1=(TextView)findViewById(R.id.tv_ans1);
        tv_ans2=(TextView)findViewById(R.id.tv_ans2);
        tv_ans3=(TextView)findViewById(R.id.tv_ans3);
        tv_ans4=(TextView)findViewById(R.id.tv_ans4);
        tv_question=(TextView)findViewById(R.id.tv_question);
        tv_questionNo=(TextView)findViewById(R.id.tv_questionNo);
        tv_score=(TextView)findViewById(R.id.tv_score);
        btn_next=(TextView)findViewById(R.id.btn_next);
    }
    public void setQuestions(){
        tv_questionNo.setText("Question No."+String.valueOf(j));j++;
        tv_question.setText(Quiz_Questions.questions[i].getQuestion());
        tv_ans1.setText(Quiz_Questions.questions[i].getAns1());
        tv_ans2.setText(Quiz_Questions.questions[i].getAns2());
        tv_ans3.setText(Quiz_Questions.questions[i].getAns3());
        tv_ans4.setText(Quiz_Questions.questions[i].getAns4());
        tv_score.setText(String.valueOf(score));
        tv_ans1.setClickable(true);
        tv_ans2.setClickable(true);
        tv_ans3.setClickable(true);
        tv_ans4.setClickable(true);
    }


    public void onNextclick(View view) {
        if(i==qNo-2+Q_NO) {
            btn_next.setVisibility(View.GONE);
        }
        i++;
        setQuestions();


        }

    public void noAns1click(View view) {
        if(tv_ans1.getText().equals(Quiz_Questions.questions[i].getCorrectAnswer())){
            callToast("Correct!");
            score++;
            tv_score.setText(String.valueOf(score));

        }else {
            callToast("Wrong!\n Correct answer is "+ Quiz_Questions.questions[i].getCorrectAnswer());
        }
        tv_ans1.setClickable(false);
        tv_ans2.setClickable(false);
        tv_ans3.setClickable(false);
        tv_ans4.setClickable(false);
    }
    public void noAns2click(View view) {
        if(tv_ans2.getText().equals(Quiz_Questions.questions[i].getCorrectAnswer())){
            callToast("Correct!");
            score++;
            tv_score.setText(String.valueOf(score));
        }else {
            callToast("Wrong!\n Correct answer is "+ Quiz_Questions.questions[i].getCorrectAnswer());
        }
        tv_ans1.setClickable(false);
        tv_ans2.setClickable(false);
        tv_ans3.setClickable(false);
        tv_ans4.setClickable(false);

    }
    public void noAns3click(View view) {
        if(tv_ans3.getText().equals(Quiz_Questions.questions[i].getCorrectAnswer())){
            callToast("Correct!");
            score++;
            tv_score.setText(String.valueOf(score));
        }else {
            callToast("Wrong!\n Correct answer is "+ Quiz_Questions.questions[i].getCorrectAnswer());
        }
        tv_ans1.setClickable(false);
        tv_ans2.setClickable(false);
        tv_ans3.setClickable(false);
        tv_ans4.setClickable(false);

    }
    public void noAns4click(View view) {
        if(tv_ans4.getText().equals(Quiz_Questions.questions[i].getCorrectAnswer())){
            callToast("Correct!");
            score++;
            tv_score.setText(String.valueOf(score));
        }else {
            callToast("Wrong!\n Correct answer is "+ Quiz_Questions.questions[i].getCorrectAnswer());
        }
        tv_ans1.setClickable(false);
        tv_ans2.setClickable(false);
        tv_ans3.setClickable(false);
        tv_ans4.setClickable(false);

    }
    public void callToast(String forToast){
        Toast.makeText(this,forToast,Toast.LENGTH_SHORT).show();
    }
    public void onEndclick(View view){
        new AlertDialog.Builder(this).setMessage("Your Final Score is\n"+score)
                .setPositiveButton("Try Again", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int ia) {
                        i=qNo;
                        score=0;
                        setQuestions();
                        btn_next.setVisibility(View.VISIBLE);
                    }
                })
                .setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int ia) {
                        i=qNo;
                        score=0;
                        finishAffinity();
                    }
                })
                .setNeutralButton("End this Level", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        i=qNo;
                        score=0;
                        finish();
                    }
                })
                .show();
    }

    @Override
    protected void onDestroy() {
        i=qNo;
        score=0;
        super.onDestroy();
    }
}
