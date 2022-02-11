package edu.montclair.quizgame;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class PastScores extends AppCompatActivity {

    private static final String FILE_NAME = "scores.txt";
    AlertDialog dialog;
    AlertDialog.Builder builder;
    TextView scoresList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_past_scores);

        scoresList = findViewById(R.id.pastScoresList);


        FileInputStream fis = null;
        try { // try opening past scores file "scores.txt"
            fis = openFileInput(FILE_NAME);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String text;

            while ((text = br.readLine()) != null){
                // read each line and build string
                sb.append(text).append("\n");
            };

            scoresList.setText(sb.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
        e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public void wipeScores(View v){ // Delete all scores
        builder = new AlertDialog.Builder(this);
        builder.setTitle("Are you sure?");
        builder.setPositiveButton("Wipe Scores", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                FileOutputStream fos = null;
                //TextView scoreslist = (TextView)findViewById(R.id.pastScoresList);
                try {
                    fos = openFileOutput(FILE_NAME, MODE_PRIVATE);
                    fos.flush();
                    scoresList.setText("");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (fos != null) {
                        try {
                            fos.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
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
}
