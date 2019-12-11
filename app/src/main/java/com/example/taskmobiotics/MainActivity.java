package com.example.taskmobiotics;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.taskmobiotics.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
       initView();
    }

    private void initView() {
        binding.header.btnback.setVisibility(View.GONE);
        binding.header.tvBack.setVisibility(View.GONE);
        binding.btnDecryption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,DecryptionActivity.class);
                startActivity(intent);
            }
        });
        binding.btnEncryption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,EncryptionActivity.class);
                startActivity(intent);
            }
        });
    }
}
