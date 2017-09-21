package com.giorgosioak.comparisons;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Random randomGenerator = new Random();
    int left_value = 0 , right_value = 0;
    TextView answer_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView left_tv = (TextView) findViewById(R.id.number_left);
        TextView right_tv = (TextView) findViewById(R.id.number_right);

        answer_tv = (TextView) findViewById(R.id.answer);


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

        answer_tv.setText("Correct");
        answer_tv.setTextColor(Color.GREEN);
        answer_tv.setShadowLayer(1, 0, 0, Color.BLACK);

    }

    private void setAnswerWrong() {

        answer_tv.setText("Wrong Answer");
        answer_tv.setTextColor(Color.RED);
        answer_tv.setShadowLayer(1, 0, 0, Color.BLACK);

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
