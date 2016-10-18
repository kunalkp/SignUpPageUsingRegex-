package com.example.kunal.signupmachinetest;

import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by KUNAL on 10/10/2016.
 */

public class RegisterFormValidation {

    //Regular Expression
    private static final String EMAIL_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private static final String PHONE_REGEX = "\\d{1}\\d{10}";
    private static final String PASSWORD_REGEX = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";

    // Error Messages
    private static final String REQUIRED_MSG = "required";
    private static final String EMAIL_MSG = "invalid email";
    private static final String PHONE_MSG = "0##########";
    private static final String PASSWORD_MSG = "Must Contain a Upper case, Digit, Symbol and minimum 6 Characters";
    private static final String CONFIRMPASS_MSG = "Passwords don't match";

    // validate username whether it's blank or not
    public static boolean hasUsername(EditText mEdt_Username) {

        String text = mEdt_Username.getText().toString().trim();
        mEdt_Username.setError(null);

        if (text.length() == 0) {
            mEdt_Username.setError(REQUIRED_MSG);
            return false;
        }
        return true;
    }

    public static boolean hasFirstname(EditText mEdt_Firstname) {

        String text = mEdt_Firstname.getText().toString().trim();
        mEdt_Firstname.setError(null);

        if (text.length() == 0) {
            mEdt_Firstname.setError(REQUIRED_MSG);
            return false;
        }
        return true;
    }

    public static boolean isPasswordMatching(EditText mEdt_Confirmpass,EditText mEdt_Password){
        String password = mEdt_Password.getText().toString();
        String confirmpass = mEdt_Confirmpass.getText().toString();
        mEdt_Confirmpass.setError(null);

        if(!confirmpass.equals(password)){
            mEdt_Confirmpass.setError(CONFIRMPASS_MSG);
            return false;
        }
        return true;
    }

    // validate email address
    public static boolean isValidEmail(EditText mEdt_Email, boolean required) {
        return isValid(mEdt_Email, EMAIL_REGEX, EMAIL_MSG, required);
    }

    // validate phone number
    public static boolean isValidPhone(EditText mEdt_Mobile, boolean required) {
        return isValid(mEdt_Mobile, PHONE_REGEX, PHONE_MSG, required);
    }

    // validate password
    public static boolean isValidPassword(EditText mEdt_Password, boolean required) {
        return isValid(mEdt_Password, PASSWORD_REGEX, PASSWORD_MSG, required);
    }

    // validate confirm password
    public static boolean isValidConfirmPassword(EditText mEdt_ConfirmPass, boolean required) {
        return isValid(mEdt_ConfirmPass, PASSWORD_REGEX, CONFIRMPASS_MSG, required);
    }

    // return true if the input field is valid, based on the parameter passed
    public static boolean isValid(EditText editText, String regex, String errMsg, boolean required) {

        String text = editText.getText().toString().trim();
        // clearing the error, if it was previously set by some other values
        editText.setError(null);

        // text required and editText is blank, so return false
        if ( required && !hasUsername(editText) )
            return false;

        // text required and editText is blank, so return false
        if ( required && !hasFirstname(editText) )
            return false;

        // pattern doesn't match so returning false
        if (required && !Pattern.matches(regex, text)) {
            editText.setError(errMsg);
            return false;
        }

        // Confirm password doesn't match
        if (required && !isPasswordMatching(editText,editText)){
            editText.setError(errMsg);
            return false;
        }
        return true;
    }
}
