package com.example.library;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        setContentView(R.layout.activity_login);
    }






    public void pushlogin(View view){
        try {
                //データベースに接続
                Connection con = MySQLconnect.getConnection();
                //ステートメントオブジェクトを作成
                Statement stmt = (Statement) con.createStatement();
            //SQL
            System.out.println("connection success");
            EditText etinput_name = findViewById(R.id.etName);
            String input_name=etinput_name.getText().toString();
            ResultSet rs = stmt.executeQuery("select id from user where id ='"+input_name+"'");
            boolean next = rs.next();
            if (next == false) {
                String show="IDまたはパスワードが違っています";
                Toast.makeText(login.this,show,Toast.LENGTH_LONG).show();
                return;
            }
            EditText etinput_pass = findViewById(R.id.etPass);
            String input_pass=etinput_pass.getText().toString();
            ResultSet rs1=stmt.executeQuery("select id,pass from user where id like '"+input_name+"' and pass = sha1('"+input_pass+"')");
            next=rs1.next();
            if(next==false) {
                String show = "IDまたはパスワードが違っています";
                Toast.makeText(login.this, show, Toast.LENGTH_LONG).show();
                return;
            }
            System.out.println("loginsuccess");
            //オブジェクトを解放
            rs.close();
            stmt.close();
            con.close();
            rs1.close();
            //画面遷移処理
            Intent intent = new Intent(login.this,MainActivity.class);
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




}