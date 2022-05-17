//6206021611125 น.ส.ธรรณศร เมตตา

package com.thannasorn.assign03_02_6206021611125;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText Mid, Final, Homework;
    private Button btnOk;
    private TextView total, Grade;

    private final String total2 = "คะแนนรวม : ";
    private final String grade2 = "เกรดที่ได้ : ";

    int Mid1, Final1, Homework1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Mid = (EditText) findViewById(R.id.Mid);
        Final = (EditText) findViewById(R.id.Final);
        Homework = (EditText) findViewById(R.id.Homework);

        btnOk = (Button) findViewById(R.id.btnOk);
        btnOk.setOnClickListener(this);

        total = (TextView) findViewById(R.id.total);
        Grade = (TextView) findViewById(R.id.Grade);
    }

    @Override
    public void onClick(View view) {

        Mid1 = Integer.parseInt(Mid.getText().toString());
        Final1 = Integer.parseInt(Final.getText().toString());
        Homework1 = Integer.parseInt(Homework.getText().toString());
        if (Mid1 > 30) {
            Toast.makeText(this, "กรุณาป้อนคะแนนกลางภาคไม่เกิน 30", Toast.LENGTH_SHORT).show();
            return;
        }

        if (Final1 > 40) {
            Toast.makeText(this, "กรุณาป้อนคะแนนปลายภาคไม่เกิน 40", Toast.LENGTH_SHORT).show();
            return;
        }

        if (Homework1 > 30) {
            Toast.makeText(this, "กรุณาป้อนคะแนนการบ้านไม่เกิน 30", Toast.LENGTH_SHORT).show();
            return;
        }
        CalGrade(Mid1, Final1, Homework1);
    }

    public void CalGrade(int Mid, int Final, int Homework) {
        int Showtotal = Mid + Final + Homework;
        total.setText(total2 + Showtotal);

        String grade;
        if (Showtotal >= 80) {
            grade = "A";
        } else if (Showtotal >= 75) {
            grade = "B+";
        } else if (Showtotal >= 70) {
            grade = "B";
        } else if (Showtotal >= 65) {
            grade = "C+";
        } else if (Showtotal >= 60) {
            grade = "C";
        } else if (Showtotal >= 55) {
            grade = "D+";
        } else if (Showtotal >= 50) {
            grade = "D";
        } else grade = "F";

        Grade.setText(grade2 + grade);
    }
}



