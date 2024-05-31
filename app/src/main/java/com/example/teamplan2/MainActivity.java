package com.example.teamplan2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.view.View.OnClickListener;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton b = (ImageButton) findViewById(R.id.imageButton2);
        b.setOnClickListener(new OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, choiceplacemain.class);
                startActivity(intent);
                finish();
            }
        });
    }
}

class DBhelper extends SQLiteOpenHelper{
    private static final String DATABASE_NAME = "mymy.db";
    private static final int DATABASE_VERSION = 1;

    public DBhelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE contacts ( _id INTEGER PRIMARY KEY"+"AUTOINCREMENT, name TEXT, tel TEXT);");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS contacts");
        onCreate(db);
    }
    public class Databasedb extends AppCompatActivity{
        DBhelper helper;
        SQLiteDatabase db;
        EditText edit_name;

        public void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            helper = new DBhelper(this);
            try {
                db = helper.getWritableDatabase();
            }catch (SQLiteException ex){
                db = helper.getReadableDatabase();
            }
            edit_name = (EditText) findViewById(R.id.editText01);
        }
        public void insert(View target){
            String name = edit_name.getText().toString();
            db.execSQL("fkfkfkf"+name);
            Toast.makeText(getApplicationContext(), "성공적으로 추가되었음", Toast.LENGTH_SHORT).show();
            edit_name.setText("");
        }
    }




















}