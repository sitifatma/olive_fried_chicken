package com.example.nurad.finalprojejtandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText username, password;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_login );

        username = (EditText) findViewById( R.id.Username );
        password = (EditText) findViewById( R.id.Password );
        btnLogin = (Button) findViewById( R.id.BtnLogin );

        btnLogin.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String usernameKey = username.getText().toString();
                String passwordKey = password.getText().toString();

                if (usernameKey.equals( "user@gmail.com" ) && passwordKey.equals( "11111" )) {
                    //jika login berhasil
                    Toast.makeText( getApplicationContext(), "LOGIN SUKSES",
                            Toast.LENGTH_SHORT ).show();
                    Intent intent = new Intent( Login.this, MainActivity.class );
                    Login.this.startActivity( intent );
                    finish();
                } else {
                    //jika login gagal
                    AlertDialog.Builder builder = new AlertDialog.Builder(Login.this );
                    builder.setMessage( "Alamat E-mail atau Password Anda salah!" )
                            .setNegativeButton( "Retry", null ).create().show();
                }
            }

        } );

        final EditText ed = (EditText) findViewById(R.id.Password );
        CheckBox c = (CheckBox) findViewById(R.id.checkBox1);

        c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (!isChecked) {
                    ed.setTransformationMethod( PasswordTransformationMethod.getInstance());
                } else {
                    ed.setTransformationMethod( HideReturnsTransformationMethod.getInstance());
                }

            }
        });

    }
}