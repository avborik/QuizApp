package com.avborik28.quizapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    private TextView mTxtQuestion;
    private Button btnTrue, btnWrong;
    private int mQuestionIndex = 0;
    private int mQuizQuestion;

    private ProgressBar mProjgressBar;
    private TextView mQuizStatsTextView;

    private int mUserScore;

    private QuizModel[] questionCollection = new QuizModel[] {
            new QuizModel(R.string.q1, true),
            new QuizModel(R.string.q2, false),
            new QuizModel(R.string.q3, true),
            new QuizModel(R.string.q4, false),
            new QuizModel(R.string.q5, true),
            new QuizModel(R.string.q6, false),
            new QuizModel(R.string.q7, true),
            new QuizModel(R.string.q8, false),
            new QuizModel(R.string.q9, true),
            new QuizModel(R.string.q10, false)
    };

    final int USER_PROGRESS = (int) Math.ceil(100.0 / questionCollection.length);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTxtQuestion = findViewById(R.id.txtQestion);

        QuizModel q1 = questionCollection[mQuestionIndex];

        mQuizQuestion = q1.getmQuestion();

        mTxtQuestion.setText(mQuizQuestion);

        mProjgressBar = findViewById(R.id.quizPB);

        mQuizStatsTextView = findViewById(R.id.txtQuizStats);


        btnTrue = findViewById(R.id.btnTrue);

      /*  View.OnClickListener myClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Log.i("Listener ", "The button is tapped");

                if(v.getId() == R.id.btnTrue){
                   // Log.i("Listener","Button true is tapped !!");
                }
                *//*if(v.getId() == R.id.btnFalse){
                    Log.i("Listenter", "The false button is tapped");

                }*//*
                Toast myToastObject = Toast.makeText(getApplicationContext(),"btn True is tapped now",Toast.LENGTH_LONG);
                myToastObject.show();
            }
        };*/

        btnTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                evaluateUserAnswers(true);
                changeQuestionOnButtonClick();

            }
        });

        btnWrong = findViewById(R.id.btnFalse);

       // btnWrong.setOnClickListener(myClickListener);
          btnWrong.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                /*  if(v.getId() == R.id.btnFalse){
                      //Log.i("another Listenter", "The false button is tapped");
                      *//*Toast myToastObject = Toast.makeText(getApplicationContext(),"btn False is tapped now",Toast.LENGTH_LONG);
                      myToastObject.show();*//*
                      Toast.makeText(getApplicationContext(),"btn Wrong is tapped now",Toast.LENGTH_LONG).show();
                  }*/
                  evaluateUserAnswers(false);
                changeQuestionOnButtonClick();

              }
          });

         // QuizModel model = new QuizModel(R.string.q1, true);
    }

    private void changeQuestionOnButtonClick(){
        mQuestionIndex = (mQuestionIndex + 1) % 10;
        if(mQuestionIndex == 0 ){
            AlertDialog.Builder quizAlert = new AlertDialog.Builder(this);
            quizAlert.setCancelable(false);
            quizAlert.setTitle("The quiz is finished");
            quizAlert.setMessage("Your score is " + mUserScore);
            quizAlert.setPositiveButton("Finish the quiz", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            quizAlert.show();
        }
        mQuizQuestion = questionCollection[mQuestionIndex].getmQuestion();
        mTxtQuestion.setText(mQuizQuestion);
        mProjgressBar.incrementProgressBy(USER_PROGRESS);
        mQuizStatsTextView.setText(mUserScore + "");
    }

    private void evaluateUserAnswers(boolean userGuess){
        boolean currentUserQuestion = questionCollection[mQuestionIndex].ismAnswer();

        if(currentUserQuestion == userGuess){
            Toast.makeText(getApplicationContext(),R.string.correct_toast_message,Toast.LENGTH_SHORT).show();
            mUserScore = mUserScore + 1;
        } else{
            Toast.makeText(getApplicationContext(),R.string.incorrect_toast_message,Toast.LENGTH_SHORT).show();
        }
    }
}
