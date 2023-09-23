package com.example.library;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class borrow extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_borrow);
        Intent intent = getIntent();
        String selected_book = intent.getStringExtra("selected_book");
        TextView tvcheck =findViewById(R.id.tvborrowcheck);
        tvcheck.setText(selected_book+"\nを借りますか?");
    }
    public void borrowbackbutton(View view){
        finish();
    }
    public void btBorrow(View view){
        try {
            //データベースに接続
            Connection con = MySQLconnect.getConnection();
            //ステートメントオブジェクトを作成
            Statement stmt = (Statement) con.createStatement();
            Intent intent = getIntent();
            String selected_book = intent.getStringExtra("selected_book");
            stmt.executeUpdate("update books set flag=1 where name="+"'"+selected_book+"'"+";");
            String show=selected_book+"を借りました";
            Toast.makeText(borrow.this,show,Toast.LENGTH_LONG).show();
            con.close();
            stmt.close();
            finish();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}