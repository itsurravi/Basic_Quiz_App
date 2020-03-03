package com.rvsharma.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_one, btn_two, btn_three, btn_four;
    TextView tv_question, tv_timer, tv_score;
    public int score = 0, count = 0;
    View v1;

    private Question question = new Question();

    private String answer;
    private int questionLength = question.questions.length;

    Integer numbers[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};

    int p = 0;

    Random random;
    CountDownTimer c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        random = new Random();

        List<Integer> intList = Arrays.asList(numbers);

        Collections.shuffle(intList);

        intList.toArray(numbers);

        tv_question = (TextView) findViewById(R.id.tv_question);
        tv_timer = (TextView) findViewById(R.id.tv_timer);
        tv_score = (TextView) findViewById(R.id.tv_score);
        btn_one = (Button) findViewById(R.id.btn_one);
        btn_two = (Button) findViewById(R.id.btn_two);
        btn_three = (Button) findViewById(R.id.btn_three);

        btn_four = (Button) findViewById(R.id.btn_four);
        NextQuestion(p);

        c = new CountDownTimer(15000, 1000) {

            public void onTick(long millisUntilFinished) {
                tv_timer.setText("Seconds Remaining: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                onClick(tv_timer);
            }
        }.start();


        btn_one.setOnClickListener(this);
        btn_two.setOnClickListener(this);
        btn_three.setOnClickListener(this);
        btn_four.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        v1 = v;
        c.cancel();

        switch (v1.getId()) {
            case R.id.btn_one:
                btn_one.setBackground(getDrawable(R.drawable.btn_option_select_background));
                if (btn_one.getText() == answer) {
                    Toast.makeText(MainActivity.this, "You Are Correct", Toast.LENGTH_SHORT).show();
                    score += 10;
                }
                break;

            case R.id.btn_two:
                btn_two.setBackground(getDrawable(R.drawable.btn_option_select_background));
                if (btn_two.getText() == answer) {
                    Toast.makeText(MainActivity.this, "You Are Correct", Toast.LENGTH_SHORT).show();
                    score += 10;
                }
                break;

            case R.id.btn_three:
                btn_three.setBackground(getDrawable(R.drawable.btn_option_select_background));
                if (btn_three.getText() == answer) {
                    Toast.makeText(MainActivity.this, "You Are Correct", Toast.LENGTH_SHORT).show();
                    score += 10;
                }
                break;

            case R.id.btn_four:
                btn_four.setBackground(getDrawable(R.drawable.btn_option_select_background));
                if (btn_four.getText() == answer) {
                    Toast.makeText(MainActivity.this, "You Are Correct", Toast.LENGTH_SHORT).show();
                    score += 10;
                }
                break;
        }

        checkAnswer();

        btn_one.setEnabled(false);
        btn_two.setEnabled(false);
        btn_three.setEnabled(false);
        btn_four.setEnabled(false);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                c.start();
                NextQuestion(p);
            }
        }, 3000);
    }

    private void checkAnswer() {
        if (btn_one.getText() == answer) {
            btn_one.setBackground(getDrawable(R.drawable.btn_background_correct));
        }
        if (btn_two.getText() == answer) {
            btn_two.setBackground(getDrawable(R.drawable.btn_background_correct));
        }
        if (btn_three.getText() == answer) {
            btn_three.setBackground(getDrawable(R.drawable.btn_background_correct));
        }
        if (btn_four.getText() == answer) {
            btn_four.setBackground(getDrawable(R.drawable.btn_background_correct));
        }
    }

    private void GameOver() {
        c.cancel();
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilder
                .setMessage("Game Over")
                .setCancelable(false)
                .setPositiveButton("New Game", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    }
                })
                .setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        System.exit(0);
                    }
                });
        alertDialogBuilder.show();

    }

    private void NextQuestion(int num) {
        btn_one.setEnabled(true);
        btn_two.setEnabled(true);
        btn_three.setEnabled(true);
        btn_four.setEnabled(true);

        btn_one.setBackground(getDrawable(R.drawable.btn_background));
        btn_two.setBackground(getDrawable(R.drawable.btn_background));
        btn_three.setBackground(getDrawable(R.drawable.btn_background));
        btn_four.setBackground(getDrawable(R.drawable.btn_background));

        tv_score.setText("Score : " + score);
        tv_question.setText(question.getQuestion(num));
        btn_one.setText(question.getchoice1(num));
        btn_two.setText(question.getchoice2(num));
        btn_three.setText(question.getchoice3(num));
        btn_four.setText(question.getchoice4(num));
        answer = question.getCorrectAnswer(num);
        if (count == 10) {
            GameOver();
        }
        count++;
        p++;
    }


}
