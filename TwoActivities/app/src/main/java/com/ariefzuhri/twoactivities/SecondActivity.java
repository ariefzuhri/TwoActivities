package com.ariefzuhri.twoactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "extra_message";
    public static final String EXTRA_REPLY = "extra_reply";
    private EditText edtReply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        edtReply = findViewById(R.id.edt_reply_second);

        Intent intent = getIntent();
        if (intent.hasExtra(EXTRA_MESSAGE)){
            String messageReceived = getIntent().getStringExtra(EXTRA_MESSAGE);
            TextView tvMessageReceived = findViewById(R.id.tv_message_received_second);
            tvMessageReceived.setText(messageReceived);
        }
    }

    public void returnReplay(View view) {
        String reply = edtReply.getText().toString();
        Intent intent = new Intent();
        intent.putExtra(EXTRA_REPLY, reply);
        setResult(RESULT_OK, intent);
        finish();
    }
}