package com.example.akash.CapitalsQuiz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_page);

    }
    public void onStartClick(View view) {
        String Playername = ((EditText) findViewById(R.id.username)).getText().toString();
        SharedPreferences prefs = this.getSharedPreferences("Prefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("name", Playername);
        editor.commit();

        Intent intent = new Intent(this, questions.class);
        //Starts the 'questions' activity
        startActivity(intent);
        //Closes this activity
        finish();
    }

    public void onFinishClick(View view) {
        Intent intent = new Intent (this, ScoreList.class);
        startActivity(intent);
        finish();
    }

}