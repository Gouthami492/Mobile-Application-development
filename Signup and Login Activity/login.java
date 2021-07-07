package com.example.signupactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText lu,lp;
    Button si;
    String suser,spass;
    int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        lu=(EditText)findViewById(R.id.unameinpl);
        lp=(EditText)findViewById(R.id.upwinpl);
        si=(Button)findViewById(R.id.signin);
        si.setOnClickListener(this);
        Bundle bundle=getIntent().getBundleExtra("data");
        suser=bundle.getString("user");
        spass=bundle.getString("pass");
    }

    @Override
    public void onClick(View v) {

        String login_usr=lu.getText().toString();
        String login_pwd=lp.getText().toString();
        if(suser.equals(login_usr)&&(spass.equals(login_pwd)))
        {
            Toast.makeText(getBaseContext(),"Login Successfull",Toast.LENGTH_LONG).show();
        }
        else
        {
            count++;
            if(count==3)
            {
                si.setEnabled(false);
                Toast.makeText(getBaseContext(),"Incorrect credentials,login attemp exceeded",Toast.LENGTH_LONG).show();
            }
            else
            {
                Toast.makeText(getBaseContext(), "Login Failed", Toast.LENGTH_SHORT).show();
            }
        }

    }
}
