package com.example.yange.app01;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView txtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }

    private void findViews() {
        txtView = (TextView) findViewById(R.id.textView01);
    }

    public void btnTest_onClick(View v)
    {
        txtView.setText("Welcome");
        Toast.makeText(this, "Hello", Toast.LENGTH_LONG).show();
    }

    public void btnAlert_onClick(View v)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        //builder.setIcon(R.drawable.)
        builder.setTitle("Alert");
        builder.setPositiveButton("OK", null);
        builder.setNeutralButton("Cancel", null);
        builder.setMessage("Test Alert");
        builder.show();
    }
}
