package com.example.andrewmaganito.warriorsquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /*
    * Initialize score array
     */
    int[] score = new int[6];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //This method checks if question 1 is answered correctly
    public void radioButtonQ1(View view) {
        if (view.getId() == R.id.rb_q1_answer_30) {
            score[0] = 1;
        } else {
            score[0] = 0;
        }
    }

    //This method checks if question 4 is answered correctly
    public void radioButtonQ4(View view) {
        if (view.getId() == R.id.rb_q4_answer_5) {
            score[3] = 1;
        } else {
            score[3] = 0;
        }
    }

    //This method checks if question 2 is answered correctly
    public void checkBoxQ2(View view) {
        CheckBox answer_one = findViewById(R.id.cb_q2_answer1_sonics);
        CheckBox answer_two = findViewById(R.id.cb_q2_answer2_lakers);
        CheckBox answer_three = findViewById(R.id.cb_q2_answer3_thunder);
        CheckBox answer_four = findViewById(R.id.cb_q2_answer4_bull);
        boolean check_one = answer_one.isChecked();
        boolean check_two = answer_two.isChecked();
        boolean check_three = answer_three.isChecked();
        boolean check_four = answer_four.isChecked();
        if (check_one && !check_two && check_three && !check_four) {
            score[1] = 1;
        } else {
            score[1] = 0;
        }
    }

    //This method checks if question 3 is answered correctly
    public void checkBoxQ3(View view) {
        CheckBox answer_one = findViewById(R.id.cb_q3_answer1_durant);
        CheckBox answer_two = findViewById(R.id.cb_q3_answer2_mcgee);
        CheckBox answer_three = findViewById(R.id.cb_q3_answer3_thomas);
        CheckBox answer_four = findViewById(R.id.cb_q3_answer4_curry);
        boolean check_one = answer_one.isChecked();
        boolean check_two = answer_two.isChecked();
        boolean check_three = answer_three.isChecked();
        boolean check_four = answer_four.isChecked();
        if (check_one && !check_two && !check_three && check_four) {
            score[2] = 1;
        } else {
            score[2] = 0;
        }
    }

    //This method checks if question 5 is answered correctly
    private void editTextQ5() {
        EditText answer = findViewById(R.id.q5_answer);
        String string = answer.getText().toString();
        if (string.equalsIgnoreCase(getString(R.string.Q5answr))) {
            score[4] = 1;
        } else {
            score[4] = 0;
        }
    }

    //This method checks if question 5 is answered correctly
    private void editTextQ6() {
        EditText answer = findViewById(R.id.q6_answer);
        String string = answer.getText().toString();
        if (string.equalsIgnoreCase(getString(R.string.Q6answr))) {
            score[5] = 1;
        } else {
            score[5] = 0;
        }
    }

    //Calculates the total quiz score
    public void calculateScore(View view) {
        editTextQ5();
        editTextQ6();
        int scoreTotal = 0;
        for (int n : score)
            scoreTotal += n;
        Toast.makeText(this, ("Score: " + scoreTotal + "/6"), Toast.LENGTH_SHORT).show();
    }

}
