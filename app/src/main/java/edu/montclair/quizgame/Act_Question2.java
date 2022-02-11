package edu.montclair.quizgame;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.Arrays;

public class Act_Question2 extends AppCompatActivity {

    String[] playeranswers;
    AlertDialog dialog;
    AlertDialog.Builder builder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act__question2);

        // Read playeranswers array from previous activity
        final Intent intent = getIntent();
        playeranswers = intent.getStringArrayExtra("playeranswers");

        //Check if array was successfully passed
        Log.d("Q1 passed:", Arrays.toString(playeranswers));

        final Intent gotoQ3;
        gotoQ3 = new Intent(this, Act_Question3.class);

        RadioGroup answers = (RadioGroup)findViewById(R.id.q2RadioGroup);
        final RadioButton q2a1 = (RadioButton)findViewById(R.id.q2answerA);
        final RadioButton q2a2 = (RadioButton)findViewById(R.id.q2answerB);
        final RadioButton q2a3 = (RadioButton)findViewById(R.id.q2answerC);
        final RadioButton q2a4 = (RadioButton)findViewById(R.id.q2answerD);

        Button nxt_button = (Button)findViewById(R.id.nextButton);
        builder = new AlertDialog.Builder(this);

        nxt_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.setTitle("Final answer?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Place players answer in playeranswers array
                        if (q2a1.isChecked()){ playeranswers[1] = "A";}
                        else if (q2a2.isChecked()){ playeranswers[1] = "B";}
                        else if (q2a3.isChecked()){ playeranswers[1] = "C";}
                        else if (q2a4.isChecked()) { playeranswers[1] = "D";}

                        //Check if it wrote to array
                        Log.d("Player Answers:", Arrays.toString(playeranswers));

                        // Pass playeranswers array to next activity
                        gotoQ3.putExtra("playeranswers", playeranswers);
                        startActivity(gotoQ3);
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                dialog = builder.create();
                dialog.show();

            }
        });
    }
}