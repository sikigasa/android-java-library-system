package com.example.library;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btBrrow=findViewById(R.id.bt_borrow);
        Button btReturn=findViewById(R.id.bt_return);
        Button btItiran=findViewById(R.id.bt_itiran);
        HelloListener listener = new HelloListener();
        btBrrow.setOnClickListener(listener);
        btReturn.setOnClickListener(listener);
        btItiran.setOnClickListener(listener);
    }
    private class HelloListener implements View.OnClickListener{
        @Override
        public void onClick(View view){
            int id = view.getId();
            Intent intent;
            switch (id){
                case R.id.bt_borrow:
                    intent = new Intent(MainActivity.this, borrowmenu.class);
                    startActivity(intent);
                    break;
                case R.id.bt_return:
                    intent = new Intent(MainActivity.this, returnmenu.class);
                    startActivity(intent);
                    break;
                case R.id.bt_itiran:
                    intent = new Intent(MainActivity.this, itiranmenu.class);
                    startActivity(intent);
            }
        }

    }
}