package com.example.library;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class borrowmenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_borrowmenu);
        Intent intent = getIntent();
        try {
            //データベースに接続
            Connection con = MySQLconnect.getConnection();
            //ステートメントオブジェクトを作成
            Statement stmt = (Statement) con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id,name from books where flag = 0;");
            Spinner spMenu = findViewById(R.id.spinner);
            List<String> menuList =new ArrayList<>();
            while (rs.next()){
                String book = rs.getString("name");
                menuList.add(book);
            }
            ArrayAdapter<String> adapter=new ArrayAdapter<>(borrowmenu.this, android.R.layout.simple_list_item_1,menuList);
            spMenu.setAdapter(adapter);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void onRestart(){
        super.onRestart();
        try {
            //データベースに接続
            Connection con = MySQLconnect.getConnection();
            //ステートメントオブジェクトを作成
            Statement stmt = (Statement) con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id,name from books where flag = 0;");
            Spinner spMenu = findViewById(R.id.spinner);
            List<String> menuList =new ArrayList<>();
            while (rs.next()){
                String book = rs.getString("name");
                menuList.add(book);
            }
            ArrayAdapter<String> adapter=new ArrayAdapter<>(borrowmenu.this, android.R.layout.simple_list_item_1,menuList);
            spMenu.setAdapter(adapter);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void onBackButtonClick(View view){
        finish();
    }
    public void onborrowbutton(View view){

        Intent intent =new Intent(borrowmenu.this,borrow.class);
        Spinner spOutput = findViewById(R.id.spinner);
        String selected_book =(String)spOutput.getSelectedItem();
        intent.putExtra("selected_book",selected_book);
        startActivity(intent);

    }
}