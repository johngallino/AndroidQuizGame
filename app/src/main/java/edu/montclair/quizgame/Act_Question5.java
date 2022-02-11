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

public class Act_Question5 extends AppCompatActivity {

    String[] playeranswers;
    AlertDialog dialog;
    AlertDialog.Builder builder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act__question5);

        final Intent intent = getIntent();
        playeranswers = intent.getStringArrayExtra("playeranswers");

        //Check if array was successfully passed
        Log.d("Q4 passed:", Arrays.toString(playeranswers));

        final Intent gotoScore;
        gotoScore = new Intent(this, ScoreActivity.class);
        
        
        RadioGroup answers = (RadioGroup)findViewById(R.id.q5RadioGroup);
        final RadioButton q5a1 = (RadioButton)findViewById(R.id.q5answerA);
        final RadioButton q5a2 = (RadioButton)findViewById(R.id.q5answerB);
        final RadioButton q5a3 = (RadioButton)findViewById(R.id.q5answerC);
        final RadioButton q5a4 = (RadioButton)findViewById(R.id.q5answerD);

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
                        if (q5a1.isChecked()){ playeranswers[4] = "A";}
                        else if (q5a2.isChecked()){ playeranswers[4] = "B";}
                        else if (q5a3.isChecked()){ playeranswers[4] = "C";}
                        else if (q5a4.isChecked()) { playeranswers[4] = "D";}

                        //Check if it wrote to array
                        Log.d("Player Answers:", Arrays.toString(playeranswers));

                        // Pass playeranswers array to next activity
                        gotoScore.putExtra("playeranswers", playeranswers);
                        startActivity(gotoScore);
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
