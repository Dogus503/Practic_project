package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    CheckBox checkBox;
    CheckBox checkBox1;
    CheckBox checkBox11;
    CheckBox checkBox12;
    Button ans;
    Button btn;
    Button answer;
    boolean isCheck = false;
    boolean isChecker = false;
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkBox = findViewById(R.id.checkBoxColor);
        checkBox1 = findViewById(R.id.checkBoxBold);
        checkBox11 = findViewById(R.id.checkBox1Color);
        checkBox12 = findViewById(R.id.checkBox1Bold);
        ans = findViewById(R.id.buttonCounter4);
        answer = findViewById(R.id.button1Counter);
        btn = findViewById(R.id.button);
        ans.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (checkBox.isChecked() && isCheck == false){
                    if (checkBox1.isChecked())
                    {
                        Toast.makeText(MainActivity.this, "Вопрос 1 - неверно", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        count += 1;
                        Toast.makeText(MainActivity.this, "Вопрос 1 - верно", Toast.LENGTH_SHORT).show();
                    }
                    isCheck = true;
                }
                else{
                    if(isCheck == true){
                        Toast.makeText(MainActivity.this, "Плохо отправлять много ответов", Toast.LENGTH_LONG).show();
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Вопрос 1 - неверно", Toast.LENGTH_SHORT).show();
                    }
                    isCheck = true;
                }
            }
        });
        answer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBox12.isChecked() && isChecker == false){
                    if(checkBox11.isChecked()){
                        Toast.makeText(MainActivity.this, "Вопрос 2 - неверно", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        count += 1;
                        Toast.makeText(MainActivity.this, "Вопрос 2 - верно", Toast.LENGTH_SHORT).show();
                    }
                    isChecker = true;
                }
                else{
                    if(isChecker == true){
                        Toast.makeText(MainActivity.this, "Как так можно ну зачем, отправлять много ответов плохо", Toast.LENGTH_LONG).show();
                    }
                    else {
                        Toast.makeText(MainActivity.this, "Вопрос 2 - неверно", Toast.LENGTH_SHORT).show();
                    }
                    isChecker = true;
                }
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("count", count);
                intent.setClass(MainActivity.this, Next_Book.class);
                startActivity(intent);
            }
        });
    }
}