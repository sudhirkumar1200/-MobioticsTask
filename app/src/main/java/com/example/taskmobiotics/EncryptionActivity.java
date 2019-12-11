package com.example.taskmobiotics;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.database.DatabaseUtils;
import android.os.Bundle;
import android.view.View;

import com.example.taskmobiotics.databinding.ActivityEncryptionBinding;

public class EncryptionActivity extends BaseActivity {
    private ActivityEncryptionBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_encryption);

       inittView();
    }
    private void inittView() {

        binding.btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.tvDecrypt.setText(encrypt(binding.etString.getText().toString().toCharArray()));
                hideKeyboardFrom(EncryptionActivity.this,v);
            }
        });
        binding.header.tvTitle.setText("Encryption");
        binding.header.btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    public String encrypt(char[] a)
    {
        String decryptStr="";
        int k,x;
        int [] c=new int[a.length];
        char[] b=new char[a.length];
        k=1;x=0;
        for(int i=0;i<a.length;i++)
        {
            if(i!=a.length-1)
            {
                if(a[i]==a[i+1])
                {
                    k++;
                    continue;
                }
            }
            c[x]=k;
            b[x]=a[i];
            x++;
            k=1;
        }
        for(int i=0;i<x;i++) {
            decryptStr = decryptStr + b[i] + "" + c[i];
            System.out.print(b[i] + "" + c[i]);
        }
        return decryptStr;
    }
}
