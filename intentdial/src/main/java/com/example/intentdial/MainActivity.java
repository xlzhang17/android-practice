package com.example.intentdial;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button dialButton = findViewById(R.id.dial_button);
        Button messageButton = findViewById(R.id.message_button);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                switch (v.getId()){
                    case R.id.dial_button:
                        intent.setAction(intent.ACTION_DIAL);
                        intent.setData(Uri.parse("tel:043184978981"));
                        startActivity(intent);
                        break;
                    case R.id.message_button:
                        intent.setAction(intent.ACTION_SENDTO);
                        intent.setData(Uri.parse("smsto:55534"));
                        intent.putExtra("sms_body","welcome to Android!");
                        startActivity(intent);
                }
            }
        };

        dialButton.setOnClickListener(listener);
        messageButton.setOnClickListener(listener);
    }
}
