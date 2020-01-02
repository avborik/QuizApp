package com.avborik28.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView mTxtQuestion;
    private Button btnTrue, btnWrong;
    private int mQuestionIndex = 0;

    private QuizModel[] questonCollection = new QuizModel[] {
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTxtQuestion = findViewById(R.id.txtQestion);

        QuizModel q1 = questonCollection[mQuestionIndex];

        mTxtQuestion.setText(q1.getmQuestion());

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

            }
        });

        btnWrong = findViewById(R.id.btnFalse);

       // btnWrong.setOnClickListener(myClickListener);
          btnWrong.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  if(v.getId() == R.id.btnFalse){
                      //Log.i("another Listenter", "The false button is tapped");
                      /*Toast myToastObject = Toast.makeText(getApplicationContext(),"btn False is tapped now",Toast.LENGTH_LONG);
                      myToastObject.show();*/
                      Toast.makeText(getApplicationContext(),"btn Wrong is tapped now",Toast.LENGTH_LONG).show();
                  }
              }
          });

         // QuizModel model = new QuizModel(R.string.q1, true);
    }
}
