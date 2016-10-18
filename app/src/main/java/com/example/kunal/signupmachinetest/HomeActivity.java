package com.example.kunal.signupmachinetest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.kunal.signupmachinetest.sqlite.DataHandler;

import java.util.List;

/**
 * Created by KUNAL on 10/9/2016.
 */

public class HomeActivity extends AppCompatActivity {

    private DataHandler dh;
    ListView li;
    List<String> names;
    ArrayAdapter<String> User_Adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        dh = new DataHandler(this);
        li = (ListView) findViewById(R.id.user_list);
        names = this.dh.userdetails();
        User_Adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names);
        li.setAdapter(User_Adapter);
    }
}
