package com.example.shiva.healthapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Shiva on 4/20/2018.
 */

public class TempTable extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="db_cart.db";
    private static final String TABLE_NAME="table_cart";
    private static final String item="item";
    private static final String cart_id="cart_id";
    public TempTable(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String create=" CREATE TABLE "+TABLE_NAME+"("+item+" Int,"+cart_id+" Int"+")";
        sqLiteDatabase.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public boolean insertData(AddToCartModel model)
    {

        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(item,model.getCart_position());
      long result= db.insert(TABLE_NAME,null,contentValues);
        if (result==-1)
        {
            return false;
        }else{
            return true;
        }
    }
    public Cursor getData1()
    {
        SQLiteDatabase db=this.getReadableDatabase();
        String query="select * from "+TABLE_NAME;
        Cursor cursor=db.rawQuery(query,null);
        return cursor;
    }
}
