package com.example.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Sin_Cos extends AppCompatActivity implements View.OnClickListener {
    EditText etNum;
    TextView txtSin_Cos,txtResult;
    Button btnEqu, btnBack,btnClear,btnPrev;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sin_cos);
        etNum = (EditText) findViewById(R.id.etNum);
        txtSin_Cos = (TextView) findViewById(R.id.txtSin_Cos);
        txtResult = (TextView) findViewById(R.id.txtResult);
        btnEqu = (Button) findViewById(R.id.btnEqu);
        btnEqu.setOnClickListener(this);
        btnBack = (Button) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(this);
        btnClear = (Button) findViewById(R.id.btnClear);
        btnClear.setOnClickListener(this);
        btnPrev = (Button) findViewById(R.id.btnPrev);
        btnPrev.setOnClickListener(this);
        if (Check.sin_cos == true)
        {
            txtSin_Cos.setText("Sin(");
        }
        else
        {
            txtSin_Cos.setText("Cos(");
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnEqu:
                if (!etNum.getText().toString().equals(""))
                {
                    if (Check.sin_cos == true)
                    {
                        Check.result = Math.sin(Math.toRadians(Double.parseDouble(etNum.getText().toString())));
                    }
                    else
                    {
                        Check.result = Math.cos(Math.toRadians(Double.parseDouble(etNum.getText().toString())));
                    }
                    txtResult.setText(Double.toString(Check.result));
                }
                else
                    Toast.makeText(this, "Заполните поле числа", Toast.LENGTH_SHORT).show();
            break;
            case R.id.btnPrev:
                if(Check.check_prev == true)
                {
                    etNum.setText(Double.toString(Check.result));
                }
                else
                    Toast.makeText(this, "Предыдущего результата еще не было", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnClear:
                etNum.setText("");
                txtResult.setText("");
                break;
            case R.id.btnBack:
                Intent intent = new Intent(this,MainActivity.class);
                startActivity(intent);
                break;
        }
    }
}