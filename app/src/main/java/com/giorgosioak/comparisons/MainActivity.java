package com.giorgosioak.comparisons;

import android.graphics.Color;
import android.graphics.Interpolator;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Random randomGenerator = new Random();
    int left_value = 0 , right_value = 0, game_active=0, active_game_points=0;
    LinearLayout game_lt, points_lt;
    TextView answer_tv,left_tv,right_tv,points_tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        left_tv = (TextView) findViewById(R.id.number_left);
        right_tv = (TextView) findViewById(R.id.number_right);

        answer_tv = (TextView) findViewById(R.id.answer);
        points_tv = (TextView) findViewById(R.id.points_number);


        game_lt = (LinearLayout) findViewById(R.id.game_layout);
        game_lt.setVisibility(View.INVISIBLE);

        points_lt = (LinearLayout) findViewById(R.id.points_layout);
        points_lt.setVisibility(View.INVISIBLE);

        answer_tv.setText(R.string.new_game);

    }

    public void new_game(View view){

        if ( 0 == game_active ) {

            active_game_points = 0;
            game_active = 1;
            answer_tv.setText(" ");
            game_lt.setVisibility(View.VISIBLE);
            points_lt.setVisibility(View.VISIBLE);
            new_round();

        }
    }

    private void new_round() {

        points_tv.setText(Integer.toString(active_game_points));

        left_value = getRandomNumber(30);
        right_value = getRandomNumber(30);

        setTextOnTextView(left_tv,right_tv,left_value,right_value);
    }

    private int getRandomNumber(int right) {
        return randomGenerator.nextInt(right);
    }

    private void setTextOnTextView(TextView left, TextView right, int left_value, int right_value) {
        left.setText(Integer.toString(left_value));
        right.setText(Integer.toString(right_value));
    }


    private void setAnswerCorrect() {

        answer_tv.setText(R.string.correct);
        active_game_points++;

        new_round();

    }


    private void setAnswerWrong() {

        answer_tv.setText(R.string.wrong_answer);

        game_active = 0;

    }

    // BUTTON FUNCTIONS

    public void isLess(View view) {

        if (left_value < right_value) {
            setAnswerCorrect();
        } else {
            setAnswerWrong();
        }

    }

    public void isEqual(View view){

        if ( left_value == right_value ) {
            setAnswerCorrect();
        } else {
            setAnswerWrong();
        }


    }

    public void isGreater(View view){

        if ( left_value > right_value ) {
            setAnswerCorrect();
        } else {
            setAnswerWrong();
        }

    }
}
