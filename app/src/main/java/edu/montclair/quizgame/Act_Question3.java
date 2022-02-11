package edu.montclair.quizgame;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.Arrays;

public class Act_Question3 extends AppCompatActivity {

    String[] playeranswers;
    AlertDialog dialog;
    AlertDialog.Builder builder;
    String temp_answer = "null";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act__question3);
        final Intent intent = getIntent();
        playeranswers = intent.getStringArrayExtra("playeranswers");

        //Check if array was successfully passed
        Log.d("Q2 passed:", Arrays.toString(playeranswers));

        final Intent gotoQ4;
        gotoQ4 = new Intent(this, Act_Question4.class);


        Button trueButton = (Button)findViewById(R.id.trueButton);
        Button falseButton = (Button)findViewById(R.id.falseButton);
        builder = new AlertDialog.Builder(this);
        builder.setTitle("Final answer?");

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Place players answer in playeranswers array
                playeranswers[2] = temp_answer;
                Log.d("Q3 Player Answers:", Arrays.toString(playeranswers));
                // Pass playeranswers array to next activity
                gotoQ4.putExtra("playeranswers", playeranswers);
                startActivity(gotoQ4);
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp_answer = "true";
                dialog = builder.create();
                dialog.show();

            }
        });

        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp_answer = "false";
                dialog = builder.create();
                dialog.show();

            }
        });


    }
}