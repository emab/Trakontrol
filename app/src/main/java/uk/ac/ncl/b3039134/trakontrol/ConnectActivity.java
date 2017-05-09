package uk.ac.ncl.b3039134.trakontrol;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.net.URISyntaxException;

import io.socket.client.Socket;
import io.socket.client.IO;
import io.socket.emitter.Emitter;

public class ConnectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect);

        final Intent intent = new Intent(this, MainActivity.class);

        Button connect = (Button) findViewById(R.id.button);
        connect.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                final EditText ip = (EditText) findViewById(R.id.connectIP);
                /*try {
                    Socket mSocket = IO.socket(ip.getText().toString());
                    mSocket.connect();
                    mSocket.on(Socket.EVENT_CONNECT, new Emitter.Listener() {
                        @Override
                        public void call(Object... args) {
                            intent.putExtra("IP", ip.getText().toString());
                            startActivity(intent);
                            finish();
                        }
                    });
                } catch (URISyntaxException e) {} */
            }
        });

        Button autoconnect = (Button) findViewById(R.id.autoconnect);
        autoconnect.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                for (int i = 0; i <= 1; i++) {
                    for (int j=0;j<=255;j++) {
                        try {
                            Socket mSocket = IO.socket("http://192.168."+i+"."+j);
                            mSocket.connect();
                            final String selectedip = "http://192.168."+i+"."+j;
                            mSocket.on(Socket.EVENT_CONNECT, new Emitter.Listener() {
                                @Override
                                public void call(Object... args) {
                                    intent.putExtra("IP", selectedip);
                                    startActivity(intent);
                                    finish();
                                }
                            });
                        } catch (URISyntaxException e) {
                        }
                    }
                }
            }
        });
    }
}
