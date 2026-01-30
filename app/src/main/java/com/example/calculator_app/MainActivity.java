package com.example.calculator_app;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText number1, number2, operator;
    Button btnCalculate;
    TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number1 = findViewById(R.id.number1);
        number2 = findViewById(R.id.number2);
        operator = findViewById(R.id.operator);
        btnCalculate = findViewById(R.id.btnCalculate);
        resultText = findViewById(R.id.resultText);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String n1 = number1.getText().toString();
                String n2 = number2.getText().toString();
                String op = operator.getText().toString();

                if (n1.isEmpty() || n2.isEmpty() || op.isEmpty()) {
                    Toast.makeText(MainActivity.this,
                            "Please fill all fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                double a = Double.parseDouble(n1);
                double b = Double.parseDouble(n2);
                double res;

                if (op.equals("+")) {
                    res = a + b;
                } else if (op.equals("-")) {
                    res = a - b;
                } else if (op.equals("*")) {
                    res = a * b;
                } else if (op.equals("/")) {
                    if (b == 0) {
                        Toast.makeText(MainActivity.this,
                                "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    res = a / b;
                } else {
                    Toast.makeText(MainActivity.this,
                            "Invalid operator", Toast.LENGTH_SHORT).show();
                    return;
                }

                resultText.setText("Result: " + res);
            }
        });
    }
}
