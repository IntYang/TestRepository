package com.mycompany.myapplication.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.mycompany.myapplication.R;

public class ReturnValueActivity extends AppCompatActivity {
    private TextView txtX;
    private TextView txtY;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_return_value);
        txtX = (TextView)findViewById(R.id.txtX);
        txtY = (TextView)findViewById(R.id.txtY);

        Intent intent = getIntent();
        txtX.setText(String.valueOf(intent.getIntExtra("x",0)));
        txtY.setText(String.valueOf(intent.getIntExtra("y",0)));

    }

    public void handleBtnCalcValueReturn(View v){
        int x = Integer.parseInt(txtX.getText().toString());
        int y = Integer.parseInt(txtY.getText().toString());
        int result = x+y;

        Intent resultIntent = new Intent();
        resultIntent.putExtra("result", result);
        setResult(RESULT_OK, resultIntent);
        finish(); // 액티비티를 코드로 죽임임
    }

    @Override
    public void onBackPressed() {
        setResult(RESULT_CANCELED);
        super.onBackPressed(); // 부모꺼 호출

    }
}