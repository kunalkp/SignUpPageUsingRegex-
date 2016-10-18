package com.example.kunal.signupmachinetest.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by KUNAL on 10/9/2016.
 */

public class DataHandler {

    SQLiteDatabase db;
    Context context;
    ArrayList<String> user_info = new ArrayList<String>();

    public DataHandler(Context con) {
        this.context = con;
        SQLiteOpenHelper myHelper = new DataCreate(this.context);
        this.db = myHelper.getWritableDatabase();
    }

    public void AddUser(String Username, String Firstname, String Lastname, String Useremail, String Usermobile,String Userpassword) {
        ContentValues conV = new ContentValues();
        conV.put("Username", Username);
        conV.put("Firstname", Firstname);
        conV.put("Lastname", Lastname);
        conV.put("Email", Useremail);
        conV.put("Mobile", Usermobile);
        conV.put("Password", Userpassword);

        db.insert(DataCreate.TABLE_USER, null, conV);
    }

    public Boolean logincheck(String UNm,String Pass)
    {
        Boolean result =false;
        Cursor c = db.rawQuery("SELECT * FROM User",null);

        if(c!= null)
        {
            if(c.moveToFirst())
            {
                do
                {
                    String username = c.getString(c.getColumnIndex("Username"));
                    String userpass = c.getString(c.getColumnIndex("Password"));

                    if(username.equals(UNm) && userpass.equals(Pass))
                    {
                        result = true;
                        break;
                    }
                }
                while(c.moveToNext());
            }
        }
        else {
            result=false;
        }
        c.close();
        return result;
    }

    public List<String> userdetails()
    {
        user_info.clear();
        Cursor c = db.rawQuery("SELECT * FROM User",null);

        if(c!= null) {
            if(c.moveToFirst()) {
                do {
                    String username = c.getString(c.getColumnIndex("Username"));
                    String firstname = c.getString(c.getColumnIndex("Firstname"));
                    String lastname = c.getString(c.getColumnIndex("Lastname"));
                    String useremail = c.getString(c.getColumnIndex("Email"));
                    String usermobile = c.getString(c.getColumnIndex("Mobile"));
                    user_info.add(firstname+" "+lastname+"\n"+username+"\n"+useremail+"\n"+usermobile);
                }
                while(c.moveToNext());
            }
        }
        else
        {

        }
        c.close();
        return user_info ;
    }
}
