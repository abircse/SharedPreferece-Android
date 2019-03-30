package com.thisisabir.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    /*
    * Class with Android Shared Preference
    * */
    private EditText email, password;
    private CheckBox remembercheckBox;
    private Button loginBtn;

    // Object creating for shredpreference
    private SharedPreferences userPreference;
    private SharedPreferences.Editor editor;
    private static String sharedpreferece_key = "authentication";
    private static String EMAIL_key = "email";
    private static String PASSWORD_key = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.emailbox);
        password = findViewById(R.id.passwordbox);
        remembercheckBox = findViewById(R.id.checkbox);
        loginBtn = findViewById(R.id.loginbutton);

        userPreference = getSharedPreferences(sharedpreferece_key, Context.MODE_PRIVATE);
        editor = userPreference.edit();

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                if (email.getText().toString().trim() == null && password.getText().toString().trim() == null)
                {
                    Toast.makeText(getApplicationContext(), "Please fill up all field", Toast.LENGTH_LONG).show();
                }
                else
                {
                    if (remembercheckBox.isChecked())
                    {
                        // store email & password in sharedpreference
                        String EMAIL = email.getText().toString();
                        String PASSWORD = password.getText().toString();
                        editor.putString(EMAIL_key, EMAIL);
                        editor.putString(PASSWORD_key, PASSWORD);
                        editor.commit();
                        Toast.makeText(getApplicationContext(), "Email & Password Has been Saved", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(MainActivity.this, HomeActivity.class));

                    }

                    startActivity(new Intent(MainActivity.this, HomeActivity.class));

                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (userPreference.contains(EMAIL_key) && userPreference.contains(PASSWORD_key))
        {
            startActivity(new Intent(MainActivity.this, HomeActivity.class));
            finish();
        }
    }
}
