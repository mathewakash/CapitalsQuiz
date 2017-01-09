package com.example.akash.CapitalsQuiz;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import static android.widget.Toast.makeText;
import static com.example.akash.CapitalsQuiz.R.array.Questions;

public class questions extends Activity {

    private boolean done;
    public int QuestionNo, score = 0;
    public boolean cheater = false;

       @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        String[] questions = getResources().getStringArray(Questions);
        TextView t = (TextView) findViewById(R.id.question);
        t.setText(questions[QuestionNo]);


    }

    public void onHintClick(View view) {
        cheater = true;
        String[] hints = getResources().getStringArray(R.array.Hints);
        Toast toasty = Toast.makeText(getApplicationContext(), hints[QuestionNo], Toast.LENGTH_SHORT);
        toasty.show();

    }

    public void onAnswerClick(View view) {

        if (done == false) {
            String answer = ((EditText) findViewById(R.id.answer)).getText().toString();
            String[] answers = getResources().getStringArray(R.array.Answers);
            String correctanswer = answers[QuestionNo];
            //gets the answer and correct answer from the edit text and strings.xml respectively
            correctanswer = correctanswer.toUpperCase();
            answer = answer.toUpperCase();


            if (answer.equals(correctanswer) & (cheater == false)) {
                score = score + 1;
                Toast toasty = Toast.makeText(getApplicationContext(), "Right! Your score is " + score, Toast.LENGTH_SHORT);
                toasty.show();
            }

            else {
                Toast toasty = Toast.makeText(getApplicationContext(), "Your score is " + score, Toast.LENGTH_SHORT);
                toasty.show();
            }
            done = true;

        }


    }

    public void onNextClick(View view) {
        if (done) {
            String[] questions = getResources().getStringArray(Questions);
            if (QuestionNo < (questions.length - 1)) {
                QuestionNo = QuestionNo + 1;
                TextView t = (TextView) findViewById(R.id.question);
                t.setText(questions[QuestionNo]);
            }
            done = false;
            cheater = false;
        }
    }

    public void onFinishClick(View view) {
        SharedPreferences prefs = this.getSharedPreferences("Prefs", Context.MODE_PRIVATE);
        int check = prefs.getInt("highscores", 0);

        if (score > check) {
            SharedPreferences.Editor editor = prefs.edit();
            editor.putInt("highscores", score);
            editor.commit();
        }

        Intent intent = new Intent (this, ScoreList.class);
        intent.putExtra("My_Score", score);
        startActivity(intent);
        finish();
    }

    public void onListClick (View view){
        final CharSequence questionchoice[] = new CharSequence[] {"Question 1", "Question 2", "Question 3", "Question 4", "Question 5"};

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Choose a question");
        builder.setItems(questionchoice, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // the user clicked on colors[which]
                if (questionchoice[which].equals("Question 1")) {
                    QuestionNo = 0;
                    String[] questions = getResources().getStringArray(Questions);
                    TextView t = (TextView) findViewById(R.id.question);
                    t.setText(questions[QuestionNo]);
                } else if (questionchoice[which].equals("Question 2")) {
                    QuestionNo = 1;
                    String[] questions = getResources().getStringArray(Questions);
                    TextView t = (TextView) findViewById(R.id.question);
                    t.setText(questions[QuestionNo]);
                } else if (questionchoice[which].equals("Question 3")) {
                    QuestionNo = 2;
                    String[] questions = getResources().getStringArray(Questions);
                    TextView t = (TextView) findViewById(R.id.question);
                    t.setText(questions[QuestionNo]);
                } else if (questionchoice[which].equals("Question 4")) {
                    QuestionNo = 3;
                    String[] questions = getResources().getStringArray(Questions);
                    TextView t = (TextView) findViewById(R.id.question);
                    t.setText(questions[QuestionNo]);
                } else if (questionchoice[which].equals("Question 5")) {
                    QuestionNo = 4;
                    String[] questions = getResources().getStringArray(Questions);
                    TextView t = (TextView) findViewById(R.id.question);
                    t.setText(questions[QuestionNo]);
                }
            }
        });
        builder.show();
    }

    public void onChangeClick(View view) {
        Intent intent = new Intent (this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    }
