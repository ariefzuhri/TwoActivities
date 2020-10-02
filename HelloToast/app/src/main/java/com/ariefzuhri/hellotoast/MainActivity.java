package com.ariefzuhri.hellotoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView tvCount;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvCount = findViewById(R.id.tv_count);
    }

    public void showToast(View view) {
        Toast.makeText(this, String.valueOf(count),
                Toast.LENGTH_LONG).show();
    }

    public void countUp(View view) {
        count++;
        tvCount.setText(String.valueOf(count));
    }
}