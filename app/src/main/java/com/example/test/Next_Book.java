package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
public class Next_Book extends AppCompatActivity {
    CheckBox checkBox;
    CheckBox checkBox1;
    CheckBox checkBox2;
    EditText editText;
    Button ans;
    Button answer;
    Button end;
    boolean isCheck = false;
    boolean isChecker = false;
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.next_book);
        checkBox = findViewById(R.id.checkBoxColor1);
        checkBox1 = findViewById(R.id.checkBoxBold1);
        checkBox2 = findViewById(R.id.checkBox2Bold);
        ans = findViewById(R.id.buttonCounter3);
        answer = findViewById(R.id.buttonCounter2);
        editText = findViewById(R.id.editText);
        end = findViewById(R.id.end);
        count = getIntent().getIntExtra("count", count);
        ans.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (checkBox2.isChecked() && !isCheck){
                    if (checkBox1.isChecked() || checkBox.isChecked())
                    {
                        Toast.makeText(Next_Book.this, "Вопрос 3 - неверно", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        count += 1;
                        Toast.makeText(Next_Book.this, "Вопрос 3 - верно", Toast.LENGTH_SHORT).show();
                    }
                    isCheck = true;
                }
                else{
                    if(isCheck){
                        Toast.makeText(Next_Book.this, "Плохо отправлять много ответов, айяйа. Не делайте так больше!", Toast.LENGTH_LONG).show();
                    }
                    else{
                        Toast.makeText(Next_Book.this, "Вопрос 3 - неверно", Toast.LENGTH_SHORT).show();
                    }
                    isCheck = true;
                }
            }
        });
        answer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editText.getText().toString().equals("Runner.run()") && !isChecker){
                    count += 1;
                    Toast.makeText(Next_Book.this, "Вопрос 4 - верно", Toast.LENGTH_SHORT).show();
                    isChecker = true;
                }
                else{
                    if(isChecker){
                        Toast.makeText(Next_Book.this, "Ух ты пухты ещё один ответ, ой я уже обедал, так что не нужен мне второй обед.", Toast.LENGTH_LONG).show();
                    }
                    else {
                        Toast.makeText(Next_Book.this, "Вопрос 4 - неверно", Toast.LENGTH_SHORT).show();
                    }
                    isChecker = true;
                }
            }
        });
        end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Next_Book.this, "Вы набрали" + " " + count + " из 4", Toast.LENGTH_LONG).show();
            }
        });
    }
}