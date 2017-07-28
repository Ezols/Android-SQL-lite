package dev.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        try {

            
            // Open or create DB if doesn't exist
            SQLiteDatabase myDatabase = this.openOrCreateDatabase("Users", MODE_PRIVATE, null);

            // Create tables
            myDatabase.execSQL("CREATE TABLE IF NOT EXISTS users (name VARCHAR, age INT(3))");

            // Insert data in tables
            myDatabase.execSQL("INSERT INTO users (name, age) VALUES ('Rob', 34)");
            myDatabase.execSQL("INSERT INTO users (name, age) VALUES ('Edvards', 24)");

            // Get data

            // Cursor allows to loop through all of the results of particular query
            Cursor c = myDatabase.rawQuery("SELECT * FROM users", null);


            // Get colon indexes

            int nameIndex = c.getColumnIndex("name");
            int ageIndex = c.getColumnIndex("age");

            c.moveToFirst();

            while(c != null)
            {
                Log.i("name", c.getString(nameIndex));
                Log.i("age", Integer.toString(c.getInt(ageIndex)));

                c.moveToNext();
            }

        }
        catch (Exception e)
        {

        }
    }
}
