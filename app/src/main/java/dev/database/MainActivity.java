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


        try
        {
            SQLiteDatabase myDatabase = this.openOrCreateDatabase("Users", MODE_PRIVATE, null);

             myDatabase.execSQL("CREATE TABLE IF NOT EXISTS newUsers (name VARCHAR, age INT(3), id INTEGER PRIMARY KEY)");

//            myDatabase.execSQL("INSERT INTO newUsers (name, age) VALUES ('Andris', 42)");
//            myDatabase.execSQL("INSERT INTO newUsers (name, age) VALUES ('Indra', 43)");
//            myDatabase.execSQL("INSERT INTO newUsers (name, age) VALUES ('Ruta', 31)");
//            myDatabase.execSQL("INSERT INTO newUsers (name, age) VALUES ('Raimonds', 43)");

//            myDatabase.execSQL("UPDATE users SET age = 2 WHERE name = 'Emīls'");
//            myDatabase.execSQL("DELETE FROM users WHERE name = 'Edvards' LIMIT 2");

            Cursor c = myDatabase.rawQuery("SELECT * FROM newUsers", null);


            int nameIndex = c.getColumnIndex("name");
            int ageIndex = c.getColumnIndex("age");
            int idIndex = c.getColumnIndex("id");

            c.moveToFirst();

            while(c != null)
            {
                Log.i("UserResults - name", c.getString(nameIndex));
                Log.i("UserResults - age", Integer.toString(c.getInt(ageIndex)));
                Log.i("UserResults - id", Integer.toString(c.getInt(idIndex)));

                c.moveToNext();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
