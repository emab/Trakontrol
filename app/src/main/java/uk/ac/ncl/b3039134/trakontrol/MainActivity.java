package uk.ac.ncl.b3039134.trakontrol;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String ip = getIntent().getStringExtra("IP");
        TextView showIp = (TextView) findViewById(R.id.ip);
        showIp.setText("This is the ip: "+ip);
    }
}
