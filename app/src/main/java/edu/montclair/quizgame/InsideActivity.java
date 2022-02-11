package edu.montclair.quizgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InsideActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inside);

        Button startbtn = findViewById(R.id.start_button);
        Button scoresbtn = findViewById(R.id.stats_button);

        final Intent gotoQ1 = new Intent(this, Act_Question1.class);
        final Intent gotoStats = new Intent(this,PastScores.class);

        startbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(gotoQ1);
            }
        });

        scoresbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(gotoStats);
            }
        });




    }
}
