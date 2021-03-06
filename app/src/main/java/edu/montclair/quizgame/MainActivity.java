package edu.montclair.quizgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

import edu.montclair.quizgame.R;

public class MainActivity extends AppCompatActivity {
    int counter=0;

    public void openLoginActivity() {
        Intent gotoLogin = new Intent(this, LoginActivity.class);
        startActivity(gotoLogin);
    }

    public void openGameActivity() {
        Intent gotoGame= new Intent(this, Act_Question1.class);
        startActivity(gotoGame);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prog();

    }
// Creates a timer for the splash screen to stay up for 2.5 seconds before starting app
    public void prog(){

        final Timer t = new Timer();
        final TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                counter++;

                if (counter == 100){
                    t.cancel();
                    // Goes to next activity
                    openGameActivity();

                }
            }
        };

    t.schedule(tt, 0, 25);

    }
}
