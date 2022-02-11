package edu.montclair.quizgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final Intent gotoLogin = new Intent(this, LoginActivity.class);

        // Linking up visual elements
        Button register_btn = findViewById(R.id.regbutton);
        final EditText emailbox = findViewById(R.id.emailbox);
        final EditText userbox = findViewById(R.id.userbox);
        final EditText datebox = findViewById(R.id.dateBox);
        final EditText passbox1 = findViewById(R.id.passbox1);
        final EditText passbox2 = findViewById(R.id.passbox2);
        final TextView error = findViewById(R.id.errorMsg);

        register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Resets error message and pulls all user entries
                error.setVisibility(View.INVISIBLE);
                String emailentry = emailbox.getText().toString().trim();
                String userentry = userbox.getText().toString().trim();
                String dateentry = datebox.getText().toString();
                String passentry = passbox1.getText().toString();
                String passentry2 = passbox2.getText().toString();

                // These are RegEx patterns for data validation
                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                String datePattern = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
                String userPattern = "\\w{4,30}";
                String passPattern = "\\S{6,14}$";

                // If any fields are empty display error
                if(emailentry.isEmpty() || userentry.isEmpty() || passentry.isEmpty() || passentry2.isEmpty()) {
                    error.setText(R.string.err_empty);
                    error.setVisibility(View.VISIBLE);
                    Toast.makeText(getApplicationContext(), "Empty fields!", Toast.LENGTH_SHORT).show();
                }

                // If email doesn't match valid email pattern, display error
                if (!emailentry.matches(emailPattern)){
                    error.setText(R.string.err_email);
                    error.setVisibility(View.VISIBLE);
                }
                // If username doesnt match valid pattern, display error
                else if (!userentry.matches(userPattern)){
                    error.setText(R.string.err_user);
                    error.setVisibility(View.VISIBLE);
                }
                // If date doesnt match valid pattern, display error
                else if (!dateentry.matches(datePattern)){
                    error.setText(R.string.err_date);
                    error.setVisibility(View.VISIBLE);
                }
                // If password doesnt match valid pattern, display error
                else if (!passentry.matches(passPattern)){
                    error.setText(R.string.err_pass);
                    error.setVisibility(View.VISIBLE);
                }
                // If passwords don't match, display error
                else if (!passentry.equals(passentry2)){
                    error.setText(R.string.err_passmatch);
                    error.setVisibility(View.VISIBLE);
                }else {
                    // if everything is good, go back to login screen
                    startActivity(gotoLogin);
                    Toast.makeText(getApplicationContext(), "New user registered!", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
