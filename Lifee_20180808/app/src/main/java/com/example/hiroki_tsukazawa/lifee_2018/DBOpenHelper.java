package com.example.hiroki_tsukazawa.lifee_2018;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class DBOpenHelper extends SQLiteOpenHelper {
    public Context m_context;
    public static final String TAG ="DBOpenHelper";
    public static final String DB_NAME = "android_sqlite_demo";
    public static final int DB_VERSION = 1;

    public DBOpenHelper(final Context context){
        super(context, DB_NAME, null, DB_VERSION);
        this.m_context = context;
    }

    @Override
    public void onCreate(final SQLiteDatabase db){
        Log.d(TAG, "onCreate version : " + db.getVersion());
        this.execFileSQL(db, "create_table.sql");
    }

    @Override
    public void onUpgrade(final SQLiteDatabase db, final int oldVersion, final int newVersion) {
        Log.d(TAG, "onUpgrade version :" + db.getVersion());
        Log.d(TAG, "onUpgrade oldVersion : " + oldVersion);
        Log.d(TAG, "onUpgrade newVersion : " + newVersion);
    }

    private void execFileSQL(SQLiteDatabase db, String fileName){
        InputStream in = null;
        InputStreamReader inReader = null;
        BufferedReader reader = null;
        try{
            in = m_context.getAssets().open(fileName);
            inReader = new InputStreamReader(in, "UTF-8");
            reader = new BufferedReader(inReader);

            String s;
            while ((s=reader.readLine()) != null){
                s = s.trim();

                if(0< s.length()){
                    db.execSQL(s);
                }
            }
        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(in != null) {
                try{
                    in.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }

            if(reader != null){
                try{
                    reader.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
