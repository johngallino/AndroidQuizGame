package edu.montclair.quizgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.Arrays;
import java.util.Date;

public class ScoreActivity extends AppCompatActivity {
    // Activity that shows final score at the end of the game

    Integer score = 0;
    String[] playeranswers;
    String[] correctanswers = {"C", "B", "false", "Missouri River", "C"};
    Date currentTime = Calendar.getInstance().getTime();
    private static final String FILE_NAME = "scores.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        final Intent intent = getIntent();
        playeranswers = intent.getStringArrayExtra("playeranswers");

        //Check if array was successfully passed
        Log.d("Q5 passed:", Arrays.toString(playeranswers));
        Log.d("Correct:", Arrays.toString(correctanswers));

        final Intent gotoBeginning;
        gotoBeginning = new Intent(this, InsideActivity.class);

        TextView finalscore = (TextView)findViewById(R.id.finalscore);
        TextView finalmsg = (TextView)findViewById(R.id.finalmessage);
        Button playagain = (Button)findViewById(R.id.playagain);

        //Compare player scores to correct answers
        for(int i = 0; i < 5; i++){
            if (playeranswers[i].equals(correctanswers[i])){
                score++;
            }
        }

        // Write score to file
        saveScore();

        finalscore.setText(score.toString() + "/5");

        if (score == 5){
            finalmsg.setText(R.string.bestscore);
        }
        else if (score > 2){
            finalmsg.setText(R.string.goodscore);
        }
        else {
            finalmsg.setText(R.string.badscore);
        }

        playagain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(gotoBeginning);
            }
        });


    }

    public void saveScore (){
        String newscore = currentTime.toString() + "\t" + score.toString() + "/5\n";
        FileOutputStream fos = null;
        try {
            fos = openFileOutput(FILE_NAME, MODE_APPEND);
            String newScore = currentTime + "\t\t\t" + score + "/5\n";
            fos.write(newScore.getBytes());
            fos.close();
            Toast.makeText(this, "Score saved!",Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Log.d("error", e.getMessage());
            Toast.makeText(this,e.getMessage(),Toast.LENGTH_SHORT).show();
        }
}}
