package com.example.yange.atm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText editTextAccount;
    EditText editTextPassword;
    String strSavedName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        findView();

        /* Get the saved name (passed by the intent from MainActivity) */
        Intent intent = getIntent();
        strSavedName = intent.getStringExtra("STR_ACCOUNT");
        editTextAccount.setText(strSavedName);

        /* If the saved name exists, move focus to the password entry  */
        if (!strSavedName.equals(""))
            editTextPassword.requestFocus();
    }

    private void findView() {
        editTextAccount = (EditText) findViewById(R.id.editTextAccount);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
    }


    public void onBtnCancel_Clicked(View view) {
        setResult(RESULT_CANCELED, getIntent());
        finish();
    }

    public void BtnLogin_onClicked(View view) {
        String strName = editTextAccount.getText().toString();
        String strPassword = editTextPassword.getText().toString();

        if ( strName.equals("jack")  && strPassword.equals("1234") ) {
            getIntent().putExtra("USER_NAME", strName);
            getIntent().putExtra("USER_PWD", strPassword);
            setResult(RESULT_OK, getIntent());
            finish();
        }
        else{
            Toast.makeText(this, "Wrong password. Try again.", Toast.LENGTH_LONG).show();
            editTextAccount.setText("");
            editTextPassword.setText("");
        }



    }
}
