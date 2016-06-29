package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    /*
    *these parameters indicate the total score and individual question scores 1 or 0
     */
    int score = 0;
    int q1Score = 0;
    int q2Score = 0;
    int q3Score = 0;
    int q4Score = 0;
    int q5Score = 0;
    int q6Score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*
    *This method checks the first radio button answer inputs, each time the method is called the score for the question defaults to 0
    * The correct answer is no. 1
     */
    public void radioButtonQ1(View view) {
        q1Score = 0;
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.q1_ans1:
                if (checked) {
                    q1Score = 1;
                    break;
                }
            case R.id.q1_ans2:
                if (checked)
                    break;
            case R.id.q1_ans3:
                if (checked)
                    break;
            case R.id.q1_ans4:
                if (checked)
                    break;
        }
    }

    /*
    *This is a checkbox method that checks for the answer (1&2) and checks again that (3&4) aren't checked to avoid any problems with ticking all boxes
     */
    public void checkBoxQ2(View view) {
        CheckBox ans1 = (CheckBox) findViewById(R.id.q2_ans1);
        boolean check1 = ans1.isChecked();
        CheckBox ans2 = (CheckBox) findViewById(R.id.q2_ans2);
        boolean check2 = ans2.isChecked();
        CheckBox ans3 = (CheckBox) findViewById(R.id.q2_ans3);
        boolean check3 = ans3.isChecked();
        CheckBox ans4 = (CheckBox) findViewById(R.id.q2_ans4);
        boolean check4 = ans4.isChecked();

        if (check1 && check2) {
            q2Score = 1;
            if (check3 || check4) {
                q2Score = 0;
            }
        } else {
            q2Score = 0;
        }

    }

    /*
    *This question brings the string typed in which is defaulted to capital letters only so that comparison can be made easily
     */
    public void editTextQ3() {
        String correctAnswer = getString(R.string.answerForQ3);
        String Answer = ((EditText) findViewById(R.id.editTextQ3)).getText().toString();
        if (correctAnswer.equals(Answer)) {
            q3Score = 1;
        } else {
            q3Score = 0;
        }
    }

    /*
    * Like question 1 but the answer is no. 4
     */
    public void radioButtonQ4(View view) {
        q4Score = 0;
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.q4_ans4:
                if (checked) {
                    q4Score = 1;
                    break;
                }
            case R.id.q4_ans2:
                if (checked)
                    break;
            case R.id.q4_ans3:
                if (checked)
                    break;
            case R.id.q4_ans1:
                if (checked)
                    break;
        }
    }

    /*
    *like question 2 but the answer is 1 and 4
     */
    public void checkBoxQ5(View view) {
        CheckBox ans1 = (CheckBox) findViewById(R.id.q5_ans1);
        boolean check1 = ans1.isChecked();
        CheckBox ans2 = (CheckBox) findViewById(R.id.q5_ans4);
        boolean check2 = ans2.isChecked();

        if (check1 && check2) {
            q5Score = 1;
        } else {
            q5Score = 0;
        }

    }

    /*
    *like question 3 but a different answer
     */
    public void editTextQ6() {
        String correctAnswer = getString(R.string.answerForQ6);
        String Answer = ((EditText) findViewById(R.id.editTextQ6)).getText().toString();
        if (correctAnswer.equals(Answer)) {
            q6Score = 1;
        } else {
            q6Score = 0;
        }
    }

    public void calculateScore(View view) {
        editTextQ3();
        editTextQ6();
        score = q1Score + q2Score + q3Score + q4Score + q5Score + q6Score;
        Toast.makeText(this, ("You scored: " + score + "/6"), Toast.LENGTH_SHORT).show();
    }
}
