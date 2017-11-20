package com.susheel.autism.feelings;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;



public class PasswordCreateActivity extends AppCompatActivity {

    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.susheel.autism.feelings.R.layout.activity_create_password);
        password = (EditText) findViewById(com.susheel.autism.feelings.R.id.etPassword);
    }

    public void onSavePasswordClick(View view) {
        SharedPreferences sharedpreference = getSharedPreferences(
                getString(com.susheel.autism.feelings.R.string.password), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreference.edit();
        editor.putString("password", password.getText().toString());
        editor.putBoolean("passwordSet", true);
        editor.commit();

        Toast.makeText(this, "Created New Password", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(getApplicationContext(), ContactSelectActivity.class);
        startActivity(intent);
    }
}
