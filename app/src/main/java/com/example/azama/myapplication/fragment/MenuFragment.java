package com.example.azama.myapplication.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.azama.myapplication.R;
import com.example.azama.myapplication.activity.LoginActivity;
import com.example.azama.myapplication.activity.RegisterActivity;


public class MenuFragment extends Fragment {


    public MenuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu, container, false);
        String[] loginMenuItems = {"Register", "Log in"};
        ListView listView = (ListView) view.findViewById(R.id.mainMenu);

        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                loginMenuItems);
        listView.setAdapter(listViewAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    Toast.makeText(getActivity(), "Register", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getActivity(), RegisterActivity.class);
                    startActivity(intent);
                }else if(position == 1){
                    Toast.makeText(getActivity(), "Log in", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getActivity(), LoginActivity.class);
                    startActivity(intent);
                }
            }
        });
        // Inflate the layout for this fragment
        return view;
    }

}
