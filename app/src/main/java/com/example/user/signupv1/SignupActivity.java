package com.example.user.signupv1;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.signupv1.data.UserDBHelper;
import com.example.user.signupv1.data.UsersContract.UserEntry;

public class SignupActivity extends AppCompatActivity {

    UserDBHelper dbHelper = new UserDBHelper(this);
    TextView userName, email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_activity);

        userName = findViewById(R.id.editUsernameSignup);
        email = findViewById(R.id.editEmailSignup);
        password = findViewById(R.id.editPasswordSignup);
    }

    public void viewLogin(View view) {
        //If data is saved successfully move to Login Activity
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(intent);
    }

    //Insert new user
    public void saveUser() {
        //Gets database repo in write mode
        SQLiteDatabase database = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(UserEntry.COLUMN_USERNAME, userName.getText().toString());
        values.put(UserEntry.COLUMN_EMAIL, email.getText().toString());
        values.put(UserEntry.COLUMN_PASSWORD, password.getText().toString());

        //Insert new row while returning the primary key of the new row
        long newRowId;
        newRowId = database.insert(UserEntry.TABLE_NAME, null, values);

        if (newRowId == -1) {
            Toast.makeText(this, "Error adding new user :-(", Toast.LENGTH_LONG).show();

        } else {
            Toast.makeText(this, "User added :-)", Toast.LENGTH_LONG).show();

            //Reset fields
            userName.setText(null);
            email.setText(null);
            password.setText(null);
        }

    }
}
// TODO: Create a Content provider for the database