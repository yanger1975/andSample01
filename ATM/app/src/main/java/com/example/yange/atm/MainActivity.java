package com.example.yange.atm;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    boolean isLoggedIn = false;
    public static int FUNC_LOGIN = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (!isLoggedIn) {
            Intent intent = new Intent(this, LoginActivity.class);

            SharedPreferences pref = getSharedPreferences("account", MODE_PRIVATE);
            String prefName = pref.getString("name", "");
            intent.putExtra("STR_ACCOUNT", prefName);
            startActivityForResult(intent, FUNC_LOGIN);

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == FUNC_LOGIN && resultCode == RESULT_OK)
        {
            String strName = data.getStringExtra("USER_NAME");
            String strPwd = data.getStringExtra("USER_PWD");
            Log.d("LOGIN", strName + "/" + strPwd);
            SharedPreferences pref = getSharedPreferences("account", MODE_PRIVATE);
            pref.edit().putString("name", strName).commit();
        }
        else
            finish();
    }
}
