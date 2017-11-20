package com.susheel.autism.feelings;

import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;


public class WelcomeScreenActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private static final String TAG = WelcomeScreenActivity.class.getName();
    public static final int REQUEST_SMS = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.susheel.autism.feelings.R.layout.activity_welcome_screen);

        // make notification bar transparent
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
        // hide the action bar
        getSupportActionBar().hide();

        viewPager = (ViewPager) findViewById(com.susheel.autism.feelings.R.id.viewpager);
        viewPager.setAdapter(new PagerAdapterWelcomeScreen(getSupportFragmentManager()));

        SmsHelper.checkAndRequestSmsPermission(this, REQUEST_SMS);
    }


    /**
     * Callback received when a permissions request has been completed.
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        if (requestCode == REQUEST_SMS) {
            // Received permission result for SMS
            if (grantResults.length == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // SMS permission has been granted
                Toast.makeText(getApplicationContext(),
                        "SMS permission granted",
                        Toast.LENGTH_LONG).show();
            }
            else {
                Toast.makeText(getApplicationContext(),
                        "SMS permission NOT granted. Turn it on in Settings -> Apps",
                        Toast.LENGTH_LONG).show();
            }
        } else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }
}
