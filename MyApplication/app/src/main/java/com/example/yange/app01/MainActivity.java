package com.example.yange.app01;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private TextView txtView;
    private Button btnPlus;
    private EditText editTextNum1, editTextNum2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }

    private void findViews() {
        txtView = (TextView) findViewById(R.id.textView01);
        btnPlus = (Button) findViewById(R.id.btnPlus);
        editTextNum1 = (EditText) findViewById(R.id.editNum1);
        editTextNum2 = (EditText) findViewById(R.id.editNum2);
    }

    public void btnTest_onClick(View v)
    {
        txtView.setText(R.string.STR_WELCOME);
        Toast.makeText(this, R.string.STR_HELLO, Toast.LENGTH_LONG).show();
    }

    public void btnAlert_onClick(View v)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        //builder.setIcon(R.drawable.)
        builder.setTitle("Alert");
        builder.setPositiveButton(R.string.STR_OK, null);
        builder.setNeutralButton(R.string.STR_CANCEL, null);
        builder.setMessage("Test Alert");
        builder.show();
    }

    public void btnPlus_onClick(View v)
    {
        int num1, num2;

        try {
            num1 = Integer.parseInt(editTextNum1.getText().toString()) ;
        }
        catch (Exception ex)
        {
            Toast.makeText(this, ex.toString(), Toast.LENGTH_LONG).show();
            return;
        }


        num2 = Integer.parseInt(editTextNum2.getText().toString()) ;
        int nResult = num1 + num2;

        Log.d("RESULT", Integer.toString(nResult));

        Intent intent = new Intent(this, ResultActivity.class);
        Bundle bundleResult = new Bundle();
        bundleResult.putString("RESULT_STR", "result");
        bundleResult.putInt("RESULT_INT", nResult);
        intent.putExtras(bundleResult);
        startActivity(intent);


    }

    public void editNum1_onClick(View view) {
        EditText editText = (EditText) view;
        editText.setText("");
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
