package com.geektech.homework_2_7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        TextView textView = findViewById(R.id.text_view1);
      String text =  getIntent().getStringExtra("key1");
      textView.setText(text);

      findViewById(R.id.btn_button).setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

              finish();
              moveTaskToBack(true);
          }
      });


    }
}