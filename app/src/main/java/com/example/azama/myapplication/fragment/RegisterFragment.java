package com.example.azama.myapplication.fragment;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.example.azama.myapplication.R;
import com.example.azama.myapplication.activity.MainActivity;
import com.example.azama.myapplication.activity.MapsActivity;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment {

    private EditText usernameField;
    private EditText passwordField;
    private EditText repasswordField;
    private EditText nameField;
    private EditText surnameField;
    private EditText emailField;
    private TextView validationTextView;

    public RegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        Button button =  (Button) view.findViewById(R.id.registerButton);
        usernameField =  (EditText) view.findViewById(R.id.usernameField);
        passwordField =  (EditText) view.findViewById(R.id.passwordField);

        repasswordField =  (EditText) view.findViewById(R.id.repasswordField);
        nameField =  (EditText) view.findViewById(R.id.nameField);
        surnameField = (EditText) view.findViewById(R.id.surnameField);
        emailField =   (EditText) view.findViewById(R.id.emailField);
        validationTextView = (TextView) view.findViewById(R.id.validationTextView);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(passwordField.getText().toString().equals(repasswordField.getText().toString())) {
                    String username = usernameField.getText().toString();
                    String password = passwordField.getText().toString();
                    String name = nameField.getText().toString();
                    String surname = surnameField.getText().toString();
                    String email = emailField.getText().toString();

                    if(username.isEmpty() || username.equals("")){
                        setValidationTextView("Username is empty");
                    }else{
                        BackendlessUser user = new BackendlessUser();
                        user.setPassword(password);
                        user.setProperty("name", username);
                        user.setProperty("firstname", name);
                        user.setProperty("lastname", surname);
                        user.setEmail(email);
                        user.setProperty("location", "");
                        Backendless.UserService.register(user, new AsyncCallback<BackendlessUser>() {
                            @Override
                            public void handleResponse(BackendlessUser response) {
                                Toast.makeText(getActivity(), "You registered!", Toast.LENGTH_SHORT).show();
//                        Intent intent = new Intent(getActivity(), MainActivity.class);
//                        startActivity(intent);
                                Intent intent = new Intent(getActivity(), MapsActivity.class);
                                startActivity(intent);
                            }

                            @Override
                            public void handleFault(BackendlessFault fault) {
                                Toast.makeText(getActivity(), "Registration failed!", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                }else{
                    setValidationTextView("Passwords doesn't matches !!");
                }
            }
        });
        return view;
    }

    public void setValidationTextView(String text){
        validationTextView.setText(text);
        validationTextView.setTextColor(Color.RED);
    }
}
