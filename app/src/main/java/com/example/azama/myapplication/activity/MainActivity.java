package com.example.azama.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.backendless.Backendless;
import com.example.azama.myapplication.fragment.MenuFragment;
import com.example.azama.myapplication.R;

public class MainActivity extends AppCompatActivity {

    public static final String APP_ID = "44C2AB6A-1232-E4D8-FFA7-14F0BCB87200";
    public static final String SECRET_KEY = "DD990C57-99B8-685D-FF2F-5D5DA89ABD00";
    public static final String VERSION = "v1";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Backendless.initApp(this, APP_ID, SECRET_KEY);
        if(Backendless.UserService.loggedInUser().equals("")){
            System.out.println("Kirdi goi");
            MenuFragment mainMenu = new MenuFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.container, mainMenu).commit();
        }else{
            System.out.println("ID OF USER -> " + Backendless.UserService.loggedInUser());
        }
    }

}
