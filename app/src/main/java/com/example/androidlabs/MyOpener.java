package com.example.androidlabs;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class MyOpener extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "MyDatabaseFile";
    public static final int VERSION_NUM = 1;
    public static final String TABLE_NAME = "MessageTable";
    public static final String COL_ID = "_id";
    public static final String COL_TEXT = "MASSAGE";
    public static final String COL_SENT = "SENT";


   public MyOpener(Activity ctx){
       super(ctx, DATABASE_NAME,null,VERSION_NUM);

   }

    @Override
    public void onCreate(SQLiteDatabase db) {

    db.execSQL("CREATE TABLE " + TABLE_NAME + "("
            + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL_TEXT + " TEXT, "
            + COL_SENT +  " BOOLEAN ); ");

   }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i("Database upgrade", "Old Version:" + oldVersion + "New Version " + newVersion);
       db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

       onCreate(db);
   }
    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion){
        Log.i("Database upgrade", "Old Version:" + oldVersion + "New Version " + newVersion);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

        onCreate(db);

    }


}
