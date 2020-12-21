package com.inthecarapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.inthecarapp.R;

//rahul jain
public class RegisterActivity extends AppCompatActivity {
    TextView tvExistingUser;
    TextView tvRegisterUser;
    RelativeLayout rlLogin;
    RelativeLayout rlSignup;
    LinearLayout llSignin;
    LinearLayout llSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        initData();
        initListener();
    }

    private void initView() {
        tvExistingUser=(TextView)findViewById(R.id.tvExistingUser);
        tvRegisterUser=(TextView)findViewById(R.id.tvRegisterUser);
        rlLogin=(RelativeLayout)findViewById(R.id.rlLogin);
        rlSignup=(RelativeLayout)findViewById(R.id.rlSignup);
        llSignin=(LinearLayout) findViewById(R.id.llSignin);
        llSignup=(LinearLayout) findViewById(R.id.llSignin2);
    }

    private void initData() {

    }

    private void initListener() {
        tvExistingUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rlLogin.setVisibility(View.VISIBLE);
                rlSignup.setVisibility(View.GONE);
            }
        });
        tvRegisterUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rlLogin.setVisibility(View.GONE);
                rlSignup.setVisibility(View.VISIBLE);
            }
        });
        llSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        llSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}