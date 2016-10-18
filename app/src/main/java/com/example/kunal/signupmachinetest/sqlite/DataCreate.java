package com.example.kunal.signupmachinetest.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by KUNAL on 10/9/2016.
 */

public class DataCreate extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "UserDataBase";
    private static final int DATABASE_VERSION = 1;
    public static final String TABLE_USER = "User";

    Context mycontext;

    public DataCreate(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.mycontext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE User(Id INTEGER PRIMARY KEY AUTOINCREMENT, Username TEXT, Firstname TEXT, Lastname TEXT, Email TEXT, Mobile TEXT, Password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXIST" + TABLE_USER);
        onCreate(sqLiteDatabase);
    }
}
