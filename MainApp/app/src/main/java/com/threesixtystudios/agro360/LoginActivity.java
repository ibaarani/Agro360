package com.threesixtystudios.agro360;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.concurrent.TimeUnit;

public class LoginActivity extends AppCompatActivity {

    int userTypeFlag =0; //0 is buyer 1 is seller
    private LinearLayout loginLinearLayout1;
    private LinearLayout loginLinearLayout2;
    private EditText mEditText;
    private EditText otpEdittext;
    private EditText nameEdittext;
    private String number, name;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginLinearLayout1 = (LinearLayout) findViewById(R.id.login_linear_layout_1);
        loginLinearLayout2 = (LinearLayout) findViewById(R.id.login_linear_layout_2);
        mEditText = (EditText) findViewById(R.id.number_text);
        otpEdittext = (EditText) findViewById(R.id.otp_text);
        nameEdittext = (EditText) findViewById(R.id.name_Text);
    }

    public void openLogin(View view) {
        switch (view.getId()){
            case R.id.buyer_button:
                userTypeFlag = 1;
                login();
                break;

            case R.id.seller_button:
                userTypeFlag =0;
                login();
                break;
        }
    }

    private void login() {
        //once buyer or seller button is pressed
        LinearLayout buttonLayout = findViewById(R.id.button_lay);
        buttonLayout.setVisibility(View.GONE);
        RelativeLayout loginLayout = findViewById(R.id.login_lay);
        loginLayout.setVisibility(View.VISIBLE);
    }

    boolean flag = false;
    public void loginCall(View view) {
        if(!flag) {
            //flag = true;
            //user entered a number and calls for login
            number = "+91" + mEditText.getText().toString();
            name = nameEdittext.getText().toString();

            SaveNUM("NUMBER", number);
            SaveName("NAME", name);
            // ...
            Intent mHomeIntent = new Intent(LoginActivity.this, MapAddressActivity.class);
            startActivity(mHomeIntent);
        }

    }

    public void SaveNUM(String key, String value){
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public void SaveName(String key, String value){
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }


}
