package com.example.shiva.healthapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Shiva on 4/19/2018.
 */

public class CartTable extends SQLiteOpenHelper{
    private final static String DATABASE_NAME="db";
    private final static String Table_name="cart_table";
    private final static String colmn1="position";
    SQLiteDatabase sqLiteDatabase;

    public CartTable(Context context)
    {
        super(context,DATABASE_NAME,null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL("Create table "+Table_name+"("+colmn1+" NUMBER "+")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int i, int i1) {

    }
    public boolean insertData(int position)
    {
         sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(colmn1,position);

        long result=sqLiteDatabase.insert(Table_name, null, contentValues);
        Log.e("result:", String.valueOf(result));
        if (result==-1)
        {
            return false;
        }else{
            return true;
        }

    }
}
