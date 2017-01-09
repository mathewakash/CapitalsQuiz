package com.example.akash.CapitalsQuiz;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Akash on 06/01/2017.
 */

public class ScoreList extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scorelist);


        Intent intent = getIntent();
        int points = intent.getExtras().getInt("My_Score");

        SharedPreferences prefs = this.getSharedPreferences("Prefs", Context.MODE_PRIVATE);
        String name = prefs.getString("name", "default");

        TextView scoredisplay = (TextView)findViewById(R.id.scoredisplay);
        scoredisplay.setText(name +", your score is " + points);

    }

    public void onRestartClick(View view) {
        Intent intent = new Intent(this, questions.class);
        //Starts the 'questions' activity
        startActivity(intent);
        //Closes this activity
        finish();
    }

    public void onHighscoreClick(View view) {
        Intent intent = new Intent(this, HighScore.class);
        //Starts the 'questions' activity
        startActivity(intent);
        //Closes this activity
        finish();
    }

    public void onChangeClick(View view) {
        Intent intent = new Intent (this, MainActivity.class);
        startActivity(intent);
        finish();
    }

}




