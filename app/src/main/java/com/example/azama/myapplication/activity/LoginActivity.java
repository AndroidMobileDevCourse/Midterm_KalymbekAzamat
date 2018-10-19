package com.example.azama.myapplication.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.azama.myapplication.fragment.LoginFragment;
import com.example.azama.myapplication.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        LoginFragment loginFragment = new LoginFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.loginContainer, loginFragment).commit();
    }
}
