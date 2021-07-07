package com.example.signupactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText su,sp;
    Button sb;
    String re="(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!])[A-Za-z\\d@$!]{8,}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        su= (EditText)findViewById(R.id.nametext);
        sp=(EditText)findViewById(R.id.pwtext);
        sb=(Button)findViewById(R.id.signup);
        sb.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        String usersignup=su.getText().toString();
        String passsignup=sp.getText().toString();
        if(validatepass(passsignup))
        {
            Bundle bundle=new Bundle();
            bundle.putString("user",usersignup);
            bundle.putString("pass",passsignup);
            Intent it=new  Intent(this,LoginActivity.class);
            it.putExtra("data",bundle);
            startActivity(it);
        }
        else
        {
            Toast.makeText(getBaseContext(), "Invalid Password",Toast.LENGTH_LONG).show();
        }
    }

    private boolean validatepass(String passsignup) {
        Pattern pattern= Pattern.compile(re);
        Matcher matcher=pattern.matcher(passsignup);
        return matcher.matches();


    }
}
