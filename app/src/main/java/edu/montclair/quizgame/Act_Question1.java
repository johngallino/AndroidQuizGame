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

public class Act_Question1 extends AppCompatActivity {


    String[] playeranswers = new String[5];
    AlertDialog dialog;
    AlertDialog.Builder builder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act__question1);

        final Intent gotoQ2;
        gotoQ2 = new Intent(this, Act_Question2.class);

        RadioGroup answers = (RadioGroup)findViewById(R.id.q1RadioGroup);
        final RadioButton q1a1 = (RadioButton)findViewById(R.id.q1answerA);
        final RadioButton q1a2 = (RadioButton)findViewById(R.id.q1answerB);
        final RadioButton q1a3 = (RadioButton)findViewById(R.id.q1answerC);
        final RadioButton q1a4 = (RadioButton)findViewById(R.id.q1answerD);

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
                        if (q1a1.isChecked()){ playeranswers[0] = "A";}
                        else if (q1a2.isChecked()){ playeranswers[0] = "B";}
                        else if (q1a3.isChecked()){ playeranswers[0] = "C";}
                        else if (q1a4.isChecked()) { playeranswers[0] = "D";}

                        //Check if it wrote to array
                        Log.d("Player Answers:", Arrays.toString(playeranswers));

                        // Pass playeranswers array to next activity
                        gotoQ2.putExtra("playeranswers", playeranswers);
                        startActivity(gotoQ2);
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
