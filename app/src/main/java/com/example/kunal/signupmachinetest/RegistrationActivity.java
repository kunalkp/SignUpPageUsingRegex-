package com.example.kunal.signupmachinetest;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.kunal.signupmachinetest.sqlite.DataHandler;


/**
 * Created by KUNAL on 10/9/2016.
 */

public class RegistrationActivity extends AppCompatActivity {

    private DataHandler dh;
    EditText mEdt_Username, mEdt_Firstname, mEdt_Lastname, mEdt_Email, mEdt_Mobile, mEdt_Password, mEdt_ConfirmPass;
    Button mBtn_Register;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        dh = new DataHandler(this);

        mEdt_Username = (EditText) findViewById(R.id.edt_username_register);
        mEdt_Firstname = (EditText) findViewById(R.id.edt_firstname);
        mEdt_Lastname = (EditText) findViewById(R.id.edt_lastname);
        mEdt_Email = (EditText) findViewById(R.id.edt_email);
        mEdt_Mobile = (EditText) findViewById(R.id.edt_mobileno);
        mEdt_Password = (EditText) findViewById(R.id.edt_pass);
        mEdt_ConfirmPass = (EditText) findViewById(R.id.edt_confirmpass);
        mBtn_Register = (Button) findViewById(R.id.btn_register);

        registerUser();
    }

    private void registerUser() {

        // TextWatcher would help us check the validation
        mEdt_Username.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                RegisterFormValidation.hasUsername(mEdt_Username);
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Keep blank
            }
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Keep blank
            }
        });

        mEdt_Firstname.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                RegisterFormValidation.hasFirstname(mEdt_Firstname);
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Keep blank
            }
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Keep blank
            }
        });

        mEdt_Email.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                RegisterFormValidation.isValidEmail(mEdt_Email, true);
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Keep blank
            }
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Keep blank
            }
        });

        mEdt_Mobile.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                RegisterFormValidation.isValidPhone(mEdt_Mobile, true);
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Keep blank
            }
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Keep blank
            }
        });

        mEdt_Password.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                RegisterFormValidation.isValidPassword(mEdt_Password, true);
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Keep blank
            }
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Keep blank
            }
        });

        mEdt_ConfirmPass.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                RegisterFormValidation.isValidConfirmPassword(mEdt_ConfirmPass, true);
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Keep blank
            }
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Keep blank
            }
        });

        mBtn_Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ( checkValidation () ){
                    dh.AddUser(mEdt_Username.getText().toString(), mEdt_Firstname.getText().toString(), mEdt_Lastname.getText().toString(),
                        mEdt_Email.getText().toString(), mEdt_Mobile.getText().toString(), mEdt_Password.getText().toString());
                    Toast.makeText(RegistrationActivity.this, "Submitting Form ... ", Toast.LENGTH_SHORT).show();
                    Intent login = new Intent(RegistrationActivity.this, LoginActivity.class);
                    startActivity(login);
                }
                else{
                    Toast.makeText(RegistrationActivity.this, "Form contains error", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean checkValidation() {
        boolean ret = true;
        if (!RegisterFormValidation.hasUsername(mEdt_Username)) ret = false;
        if (!RegisterFormValidation.hasFirstname(mEdt_Firstname)) ret = false;
        if (!RegisterFormValidation.isValidEmail(mEdt_Email, true)) ret = false;
        if (!RegisterFormValidation.isValidPhone(mEdt_Mobile, true)) ret = false;
        if (!RegisterFormValidation.isValidPassword(mEdt_Password, true)) ret = false;
        if (!RegisterFormValidation.isValidPassword(mEdt_ConfirmPass, true)) ret = false;

        return ret;
    }
}
