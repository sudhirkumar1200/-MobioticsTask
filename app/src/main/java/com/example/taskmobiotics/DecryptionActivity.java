package com.example.taskmobiotics;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.taskmobiotics.databinding.ActivityDecryptionBinding;

public class DecryptionActivity extends BaseActivity {
    private ActivityDecryptionBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_decryption);
        inittView();
    }

    private void inittView() {

        binding.btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(isLengthEven(binding.etString.getText().toString().length())&& isStrValid(binding.etString.getText().toString())){
                   binding.tvDecrypt.setText(decrypt(binding.etString.getText().toString().toCharArray()));

               }else{
                   Toast.makeText(DecryptionActivity.this,"please enter proper decrypt string.",Toast.LENGTH_LONG).show();
               }
                hideKeyboardFrom(DecryptionActivity.this,v);
            }
        });
        binding.header.tvTitle.setText("Decryption");
        binding.header.btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private boolean isLengthEven(int lenght) {
        if (lenght%2==0)
            return true;
        else{
            return false;
        }

    }

    private boolean isStrValid(String str){
        boolean isValid=false;
        for (int i = 0; i <str.length() ; i++) {
            if (i%2==0){

                Log.e("mod if ","=="+str.charAt(i));
            }else{
                isValid=true;
                if (Character.isDigit(str.charAt(i))
                        == false){
                    isValid=false;
                    Log.e("mod else if ","=="+str.charAt(i));
                    break;

                }else{
                    isValid=true;
                    Log.e("mod else else ","=="+str.charAt(i));
                }

            }
        }
        return isValid;
    }
    private String decrypt(char[] a) {
        String encryptStr = "";
        int[] c = new int[a.length+1];
        char[] b = new char[a.length+1];
        int i, j, k, x, z;
        j = 0;
        for (i = 1; i <= a.length; i++) {
            if (i % 2 == 0) {
                c[j] = a[i - 1] - 48;
                j++;
            } else {
                x = j;
                z = a[i] - 48;
                if (z > 1) {
                    for (k = 0; k < z - 1; k++) {
                        b[x] = a[i - 1];
                        x++;
                    }
                    j = x;
                }
                b[j] = a[i - 1];
            }
            if (i == a.length) {
                b[j + 1] = '\0';
                c[j + 1] = '\0';
            }
        }
        for (i = 0; i < b.length; i++) {
            System.out.print("" + b[i]);
            encryptStr = encryptStr + b[i];
            if (b[i] == '\0')
                break;
        }
        return encryptStr;
    }


}
