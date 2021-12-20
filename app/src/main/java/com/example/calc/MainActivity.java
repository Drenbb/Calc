package com.example.calc;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnClear, btnPlus, btnMinus, btnEqual, btnCos, btnSin, btnMul, btnDiv, btnPrev;
    EditText etFrstNum, etSign, etScndNum;
    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnClear = (Button) findViewById(R.id.btnClear);
        btnClear.setOnClickListener(this);
        btnPlus = (Button) findViewById(R.id.btnPlus);
        btnPlus.setOnClickListener(this);
        btnMinus = (Button) findViewById(R.id.btnMinus);
        btnMinus.setOnClickListener(this);
        btnEqual = (Button) findViewById(R.id.btnEq);
        btnEqual.setOnClickListener(this);
        btnCos = (Button) findViewById(R.id.btnCos);
        btnCos.setOnClickListener(this);
        btnSin = (Button) findViewById(R.id.btnSin);
        btnSin.setOnClickListener(this);
        btnMul = (Button) findViewById(R.id.btnMul);
        btnMul.setOnClickListener(this);
        btnDiv = (Button) findViewById(R.id.btnDiv);
        btnDiv.setOnClickListener(this);
        btnPrev = (Button) findViewById(R.id.btnPrev);
        btnPrev.setOnClickListener(this);
        etFrstNum = (EditText) findViewById(R.id.etFrstNum);
        etSign = (EditText) findViewById(R.id.etSign);
        etScndNum = (EditText) findViewById(R.id.etScndNum);
        txtResult = (TextView) findViewById(R.id.txtResult);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnPlus:
                etSign.setText("+");
                break;
            case R.id.btnClear:
                etFrstNum.setText("");
                etScndNum.setText("");
                etSign.setText("");
                txtResult.setText("");
                Toast.makeText(this, "" + Check.result, Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnMinus:
                if (etSign.hasFocus() == true) {
                    etSign.setText("-");
                }
                if (etFrstNum.hasFocus() == true) {
                    if (etFrstNum.getText().toString().equals(""))
                        Toast.makeText(this, "Поле не должно быть пустым", Toast.LENGTH_SHORT).show();
                    else {
                        double d = Double.parseDouble(etFrstNum.getText().toString()) * -1;
                        etFrstNum.setText(Double.toString(d));
                    }

                }
                if (etScndNum.hasFocus() == true) {
                    if (etScndNum.getText().toString().equals(""))
                        Toast.makeText(this, "Поле не должно быть пустым", Toast.LENGTH_SHORT).show();
                    else {
                        double d = Double.parseDouble(etScndNum.getText().toString()) * -1;
                        etScndNum.setText(Double.toString(d));
                    }
                }
                break;
            case R.id.btnMul:
                etSign.setText("*");
                break;
            case R.id.btnDiv:
                etSign.setText("/");
                break;
            case R.id.btnSin:
                Check.sin_cos = true;
                Intent intent1 = new Intent(this, Sin_Cos.class);
                startActivity(intent1);
                break;
            case R.id.btnCos:
                Check.sin_cos = false;
                Intent intent2 = new Intent(this, Sin_Cos.class);
                startActivity(intent2);
                break;
            case R.id.btnPrev:
                if (Check.check_prev == true) {
                    if (etFrstNum.hasFocus() == true) {
                        etFrstNum.setText(Double.toString(Check.result));

                    }
                    if (etScndNum.hasFocus() == true) {
                        etScndNum.setText(Double.toString(Check.result));

                    }

                } else {
                    Toast.makeText(this, "Предыдущего результата еще не было", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btnEq:
                if (etSign.getText().toString().equals("+")) {
                    if (etFrstNum.getText().toString().equals("") && etScndNum.getText().toString().equals("")) {
                        Toast.makeText(this, "Введены некорректные данные", Toast.LENGTH_SHORT).show();
                    } else {
                        Check.result = Double.parseDouble(etFrstNum.getText().toString()) + Double.parseDouble(etScndNum.getText().toString());
                        txtResult.setText(Double.toString(Check.result));
                        Check.check_prev = true;
                    }

                }
                if (etSign.getText().toString().equals("-")) {
                    if (etFrstNum.getText().toString().equals("") && etScndNum.getText().toString().equals("")) {
                        Toast.makeText(this, "Введены некорректные данные", Toast.LENGTH_SHORT).show();
                    } else {
                        Check.result = Double.parseDouble(etFrstNum.getText().toString()) - Double.parseDouble(etScndNum.getText().toString());
                        txtResult.setText(Double.toString(Check.result));
                        Check.check_prev = true;
                    }

                }
                if (etSign.getText().toString().equals("*")) {
                    if (etFrstNum.getText().toString().equals("") && etScndNum.getText().toString().equals("")) {
                        Toast.makeText(this, "Введены некорректные данные", Toast.LENGTH_SHORT).show();
                    } else {
                        Check.result = Double.parseDouble(etFrstNum.getText().toString()) * Double.parseDouble(etScndNum.getText().toString());
                        txtResult.setText(Double.toString(Check.result));
                        Check.check_prev = true;
                    }

                }
                if (etSign.getText().toString().equals("/")) {
                    if (etFrstNum.getText().toString().equals("0") || etScndNum.getText().toString().equals("0")) {
                        txtResult.setText("Ошибка!");
                        Toast.makeText(this, "Попытка работы с нулем", Toast.LENGTH_SHORT).show();
                    } else {
                        if (etFrstNum.getText().toString().equals("") && etScndNum.getText().toString().equals("")) {
                            Toast.makeText(this, "Введены некорректные данные", Toast.LENGTH_SHORT).show();
                        } else {
                            Check.result = Double.parseDouble(etFrstNum.getText().toString()) / Double.parseDouble(etScndNum.getText().toString());
                            txtResult.setText(Double.toString(Check.result));
                            Check.check_prev = true;
                        }
                    }

                }
                break;

        }
    }
}