package com.thisisabir.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    private Button logout;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private static String sharedpreferece_key = "authentication";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        sharedPreferences = getSharedPreferences(sharedpreferece_key, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        logout = findViewById(R.id.logoutbutton);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // this  code will be perform to logout user
                editor.clear();
                editor.commit();
                startActivity(new Intent(HomeActivity.this, MainActivity.class));
            }
        });
    }
}
