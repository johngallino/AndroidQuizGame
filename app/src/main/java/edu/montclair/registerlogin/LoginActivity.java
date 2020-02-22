package edu.montclair.registerlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

//      Linking layout elements
        Button login_btn = findViewById(R.id.Login_btn);
        TextView regPhrase = findViewById(R.id.register_phrase);

        final Intent gotoInside = new Intent(this, InsideActivity.class);
        final Intent gotoRegister = new Intent(this, RegisterActivity.class);

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText userbox = findViewById(R.id.user_box);
                EditText passbox = findViewById(R.id.password_box);
                TextView badentry = findViewById(R.id.badentry);
                // Pulling the values entered by the user
                String userentry = userbox.getText().toString();
                String passentry = passbox.getText().toString();

// User may enter with sample credentials of admin and pass
                if ((userentry.equals("admin")) && (passentry.equals("pass"))){
                    Log.i("Good!", "Good!");
                    startActivity(gotoInside);

                }
                else { // Any other credentials will give an error
                    badentry.setVisibility(View.VISIBLE);
                    Log.i(userentry, passentry);
                }

            }
        });

        regPhrase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(gotoRegister);
            }
        });
    }
}
