package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting);
        findViewById(R.id.button).setOnClickListener(
                (v)->{
//                  返回MAC地址
                    Intent intent = new Intent();
                    EditText et= findViewById(R.id.editText);
                    String mac = et.getText().toString();
                    intent.putExtra("mac", mac);
                    setResult(1, intent);

                    finish();
                }
        );

    }
}
