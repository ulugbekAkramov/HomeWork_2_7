package com.geektech.homework_2_7;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textField;
    private Integer firsNumber, secondNumber;
    private boolean isOperationClick;
    private String operation;
    private Integer result;
    private Button openButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textField = findViewById(R.id.text_view);
        openButton =  findViewById(R.id.btn_open);


        openButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("key1",textField.getText().toString());
                startActivity(intent);

            }
        });



    }

    public void onNumberClick(View view) {
        switch (view.getId()) {
            case R.id.nul://нажал ноль
                cmollNumber();
                if (textField.getText().toString().equals("0") || isOperationClick) {
                    textField.setText("0");
                } else {
                    textField.append("0");
                }
                break;

            case R.id.five:
                numberClick("5");
                cmollNumber();
                break;
            case R.id.btn_seven://нажал на два
                cmollNumber();
                numberClick("7");
                break;
            case R.id.btn_for://нажал на два
                cmollNumber();
                numberClick("4");
                break;
            case R.id.btn_drob://нажал на два
                cmollNumber();
                numberClick(".");
                break;
            case R.id.btn_nine://нажал на два
                cmollNumber();
                numberClick("9");
                break;

            case R.id.btn_one://нажал на единицу
                cmollNumber();
                numberClick("1");

                break;

            case R.id.btn_eight://нажал на единицу
                cmollNumber();
                numberClick("8");
                break;


            case R.id.btn_two://нажал на два
                cmollNumber();
                numberClick("2");
                break;
            case R.id.btn_three:
                cmollNumber();
                numberClick("3");
                break;
            case R.id.btn_six:
                cmollNumber();
                numberClick("6");
                break;
            case R.id.btn_clear://нажал на очистить
                firsNumber = 0;
                secondNumber = 0;
                textField.setText("0");
                break;
        }
        isOperationClick = false;
    }

    private void numberClick(String s) {
        if (textField.getText().toString().equals("0")) {
            textField.setText(s);
        } else if (isOperationClick) {
            textField.setText(s);
        } else {
            textField.append(s);
        }
    }

    public void cmollNumber() {
        if (textField.length() > 5) {
            textField.setTextSize(50);
        } else {
            textField.setTextSize(75);
        }
    }

    @SuppressLint({"NonConstantResourceId", "SetTextI18n"})
    public void onOperationClick(View view) {
        switch (view.getId()) {
            case R.id.btn_minus:
                operation = "-";
                firsNumber = Integer.valueOf(textField.getText().toString());
                break;

            case R.id.btn_plus://12
                operation = "+";
                firsNumber = Integer.valueOf(textField.getText().toString());
                break;

            case R.id.btn_umnojeni:
                operation = "*";
                firsNumber = Integer.valueOf(textField.getText().toString());
                break;

            case R.id.delenie:
                operation = "/";
                firsNumber = Integer.valueOf(textField.getText().toString());
                break;

            case R.id.btn_equal:

                openButton.setVisibility(View.VISIBLE);
                secondNumber = Integer.valueOf(textField.getText().toString());
                // 33=12+21

                switch (operation) {
                    case "-":
                        result = firsNumber - secondNumber;
                        break;
                    case "+":
                        result = firsNumber + secondNumber;
                        break;
                    case "*":
                        result = firsNumber * secondNumber;
                        break;
                    case "/":
                        result = firsNumber / secondNumber;
                        break;

                }

                textField.setText(result.toString());

        }
        isOperationClick = true;
    }
    //12+21=33
}