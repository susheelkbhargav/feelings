package com.susheel.autism.feelings;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;




public class SettingActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.susheel.autism.feelings.R.layout.activity_setting);
    }

    // Go to add contacts activity
    public void onClickeditContacts(View view) {
        Intent intent = new Intent(this, ContactSelectActivity.class);
        startActivity(intent);
    }

    // Go to pin activity
    public void onClickChangePassword(View view) {
        Intent intent = new Intent(this, PasswordCreateActivity.class);
        startActivity(intent);
    }

    // Return to home page
    public void onClickGoHome(View view) {
        finish();
    }

}
