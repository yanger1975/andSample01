package com.example.yange.app01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView textViewLabel;
    TextView textViewNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        int num = bundle.getInt("RESULT_INT");
        String strResult = bundle.getString("RESULT_STR");

        findViews();

        textViewLabel.setText(strResult);
        textViewNum.setText(Integer.toString(num));
    }

    private void findViews() {
        textViewNum = (TextView) findViewById(R.id.textViewNum);
        textViewLabel = (TextView) findViewById(R.id.textViewLabel);
    }
}
