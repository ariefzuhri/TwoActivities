package com.ariefzuhri.twoactivities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static com.ariefzuhri.twoactivities.SecondActivity.EXTRA_MESSAGE;
import static com.ariefzuhri.twoactivities.SecondActivity.EXTRA_REPLY;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private static final int RC_REPLY = 1;
    private EditText edtMessage;
    private TextView tvReplyReceived;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtMessage = findViewById(R.id.edt_message_main);
        tvReplyReceived = findViewById(R.id.tv_reply_received_main);
    }

    public void launchSecondActivity(View view) {
        Log.d(TAG, "Button clicked!");

        String message = edtMessage.getText().toString();

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivityForResult(intent, RC_REPLY);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_REPLY){
            if (resultCode == RESULT_OK) {
                if (data != null){
                    String replyReceived = data.getStringExtra(EXTRA_REPLY);
                    tvReplyReceived.setText(replyReceived);
                }
            }
        }
    }
}