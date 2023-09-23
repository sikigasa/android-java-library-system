package com.example.library;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.sql.Connection;
import java.sql.Statement;
public class returncheck extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_returncheck);
        Intent intent = getIntent();
        String selected_book = intent.getStringExtra("selected_book");
        TextView tvcheck =findViewById(R.id.tvreturncheck);
        tvcheck.setText(selected_book+"\nを返しますか?");
    }
    public void onreturnbackbutton(View view){
        finish();
    }
    public void onbtReturn(View view){
        try {
            //データベースに接続
            Connection con = MySQLconnect.getConnection();
            //ステートメントオブジェクトを作成
            Statement stmt = (Statement) con.createStatement();
            Intent intent = getIntent();
            String selected_book = intent.getStringExtra("selected_book");
            stmt.executeUpdate("update books set flag=0 where name="+"'"+selected_book+"'"+";");
            String show=selected_book+"を返しました";
            Toast.makeText(returncheck.this,show,Toast.LENGTH_LONG).show();
            con.close();
            stmt.close();
            finish();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}
