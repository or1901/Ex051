package com.example.ex051;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView[] txt = new TextView[6];
    EditText[] et = new EditText[3];
    Button[] sendBtn = new Button[3];
    ImageView[] iv = new ImageView[3];

    Random rnd = new Random();

    int num1 = 0;
    int num2 = 0;
    int sum = 0;
    int userInput = 0;
    int column = 0;
    int currentTxt = 0;
    int successAmount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt[0] = findViewById(R.id.txt1);
        txt[1] = findViewById(R.id.txt2);
        txt[2] = findViewById(R.id.txt3);
        txt[3] = findViewById(R.id.txt4);
        txt[4] = findViewById(R.id.txt5);
        txt[5] = findViewById(R.id.txt6);

        et[0] = findViewById(R.id.et1);
        et[1] = findViewById(R.id.et2);
        et[2] = findViewById(R.id.et3);

        sendBtn[0] = findViewById(R.id.sendBtn1);
        sendBtn[1] = findViewById(R.id.sendBtn2);
        sendBtn[2] = findViewById(R.id.sendBtn3);

        iv[0] = findViewById(R.id.iv1);
        iv[1] = findViewById(R.id.iv2);
        iv[2] = findViewById(R.id.iv3);

        num1 = rnd.nextInt(90) + 10;
        num2 = rnd.nextInt(90) + 10;
        sum = num1 + num2;
        txt[0].setText("" + num1);
        txt[1].setText("" + num2);
        currentTxt = 2;
    }

    public void checkSum(View view) {
        if (column < 3) {
            userInput = Integer.parseInt(et[column].getText().toString());
            if (sum == userInput) {
                iv[column].setImageResource(R.drawable.vi);
                successAmount++;
            } else
                iv[column].setImageResource(R.drawable.exs);

            if (column < 2) {
                num1 = sum;
                num2 = rnd.nextInt(90) + 10;
                sum = num1 + num2;
                txt[currentTxt].setText("" + num1);
                currentTxt++;
                txt[currentTxt].setText("" + num2);
                currentTxt++;
            }
            else {
                Toast.makeText(this, ((int)(successAmount / 3.0 * 100)) + "% ," + successAmount + "/3", Toast.LENGTH_LONG).show();
            }

            column++;
        }
    }

    public void restart(View view) {
        for(int i = 0; i < txt.length; i++) {
            txt[i].setText("");
        }
        for(int i = 0; i < iv.length; i++) {
            iv[i].setImageResource(0);
            et[i].setText("");
        }

        column = 0;
        successAmount = 0;
        num1 = rnd.nextInt(90) + 10;
        num2 = rnd.nextInt(90) + 10;
        sum = num1 + num2;
        txt[0].setText("" + num1);
        txt[1].setText("" + num2);
        currentTxt = 2;
    }
}