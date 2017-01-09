package com.example.akash.CapitalsQuiz;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Akash on 07/01/2017.
 */

public class HighScore extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.highscore);
        SharedPreferences prefs = this.getSharedPreferences("Prefs", Context.MODE_PRIVATE);
        int score2 = prefs.getInt("highscores", 0);

        TextView highscoredisplay = (TextView)findViewById(R.id.highscoredisplay);
        highscoredisplay.setText("Your highscore is " + score2);
    }

    public void onRestartClick(View view) {
        Intent intent = new Intent(this, questions.class);
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
