package uk.ac.ncl.b3039134.trakontrol;

/*
 * Information from:
 * https://www.bignerdranch.com/blog/splash-screens-the-right-way/
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent(this, ConnectActivity.class);
        startActivity(intent);
        finish();
    }
}