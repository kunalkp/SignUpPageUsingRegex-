package com.example.kunal.signupmachinetest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.kunal.signupmachinetest.sqlite.DataHandler;

public class LoginActivity extends AppCompatActivity {

    Button mBtn_Login;
    EditText mEdt_User, mEdt_Pass;
    DataHandler dh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        dh = new DataHandler(this);
        mEdt_User = (EditText)findViewById(R.id.edt_username);
        mEdt_Pass = (EditText)findViewById(R.id.edt_password);
        mBtn_Login = (Button) findViewById(R.id.btn_login);
        mBtn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = mEdt_User.getText().toString();
                String pass = mEdt_Pass.getText().toString();
                Boolean result = dh.logincheck(user, pass);
                if(result) {
                    Intent home = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(home);
                    mEdt_User.setText("");
                    mEdt_Pass.setText("");
                }
                else {
                    Toast.makeText(getApplicationContext(), "Login Failed! Register if New User", Toast.LENGTH_LONG).show(); //Toast is a widget
                }
            }
        });
    }

    public void Register(View v){
        Intent register = new Intent(LoginActivity.this, RegistrationActivity.class);
        startActivity(register);
    }
}
