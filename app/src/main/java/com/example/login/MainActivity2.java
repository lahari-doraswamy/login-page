package com.example.login;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.security.Permission;

public class MainActivity2 extends AppCompatActivity {
    private TextView textView;
    Button fragment1,fragment2,fragment3;
    TextView textView_username,textView_password;
    Button btnLogout;
    SharedPreferences sharedPreferences;
    private static final String SHARED_PREF_NAME="mypref";
    private static final String SHARED_PREF_USERNAME="name";
    private static final String SHARED_PREF_PASs="password";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textView_username = findViewById(R.id.usernames);
        textView_password = findViewById(R.id.Password);
        btnLogout = findViewById(R.id.logut);
        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
        String Usernames = sharedPreferences.getString(SHARED_PREF_USERNAME, null);
        String password = sharedPreferences.getString(SHARED_PREF_PASs, null);
        if (Usernames != null || password != null) {
            textView_username.setText("fullname -" + Usernames);
            textView_password.setText("password -" + password);
        }
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.commit();
                Toast.makeText(MainActivity2.this, "logout successfully", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        textView = findViewById(R.id.login1);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String Username = bundle.getString("lahari");
            // textView.setText(Username);
        }
        fragment1 = findViewById(R.id.button1);
        fragment2 = findViewById(R.id.button2);
        fragment3 = findViewById(R.id.button3);
        fragment1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new frag1());
            }
        });
        fragment2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new frag2());
            }
        });
        fragment3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new frag3());
            }
        });

    }
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.buttonLay,fragment);
        fragmentTransaction.commit();
    }
}