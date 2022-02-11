package edu.montclair.quizgame;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.Arrays;

public class Act_Question4 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String[] playeranswers;
    String answer = "";
    AlertDialog dialog;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act__question4);
        final Intent intent = getIntent();
        playeranswers = intent.getStringArrayExtra("playeranswers");

        //Check if array was successfully passed
        Log.d("Q3 passed:", Arrays.toString(playeranswers));

        final Intent gotoQ5;
        gotoQ5 = new Intent(this, Act_Question5.class);

        Button nextButton = (Button)findViewById(R.id.nextButton);
        builder = new AlertDialog.Builder(this);
        builder.setTitle("Final answer?");

        // Link up spinner
        final Spinner q4spinner = findViewById(R.id.q4spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.rivers, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        q4spinner.setAdapter(adapter);
        q4spinner.setOnItemSelectedListener(this);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Place players answer in playeranswers array
                        playeranswers[3] = answer;
                        Log.d("Q4 Player Answers:", Arrays.toString(playeranswers));

                        // Pass playeranswers array to next activity
                        gotoQ5.putExtra("playeranswers", playeranswers);
                        startActivity(gotoQ5);
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

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        answer = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
