package com.example.calculator;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Stack;
public class MainActivity extends AppCompatActivity {
    String s = "0", lhs = "", rhs = "", operator = "";
    Stack<String> inpStack, operatorStack;
    int flag = 0;
    EditText input;
    TextView output;
    Button ac, bksp, mod, divide, multiply, minus, plus, equal, dot;
    Button one, two, three, four, five, six, seven, eight, nine, zero;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input = (EditText) findViewById(R.id.input);
        output = (TextView) findViewById(R.id.output);
        s = input.getText().toString();
        ac = (Button) findViewById(R.id.ac);
        bksp = (Button) findViewById(R.id.bksp);
        mod = (Button) findViewById(R.id.mod);
        divide = (Button) findViewById(R.id.divide);
        multiply = (Button) findViewById(R.id.multip);
        minus = (Button) findViewById(R.id.minus);
        plus = (Button) findViewById(R.id.plus);
        equal = (Button) findViewById(R.id.equal);
        dot = (Button) findViewById(R.id.dot);
        one = (Button)findViewById(R.id.one);
        two = (Button)findViewById(R.id.two);
        three = (Button)findViewById(R.id.three);
        four = (Button)findViewById(R.id.four);
        five = (Button)findViewById(R.id.five);
        six = (Button)findViewById(R.id.six);
        seven = (Button)findViewById(R.id.seven);
        eight = (Button)findViewById(R.id.eight);
        nine = (Button)findViewById(R.id.nine);
        zero = (Button)findViewById(R.id.zero);
        output.setText("0");
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lhs = input.getText().toString();
                rhs = output.getText().toString();
                input.setText("0");
                if(rhs.equals("0")) output.setText(lhs);
                flag = 0;
                operator = "+";
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lhs = input.getText().toString();
                rhs = output.getText().toString();
                input.setText("0");
                if(rhs.equals("0")) output.setText(lhs);
                flag = 0;
                operator = "-";
            }
        });
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lhs = input.getText().toString();
                rhs = output.getText().toString();
                input.setText("0");
                if(rhs.equals("0")) output.setText(lhs);
                flag = 0;
                operator = "*";
            }
        });
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lhs = input.getText().toString();
                rhs = output.getText().toString();
                input.setText("0");
                if(rhs.equals("0")) output.setText(lhs);
                flag = 0;
                operator = "/";
            }
        });
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rhs = input.getText().toString();
                lhs = output.getText().toString();
                String temp = operator;
                operator = ""; flag = 0;
                if(temp.equals("")) {
                    lhs = input.getText().toString();
                    input.setText("0");
                    output.setText(lhs);
                }
                else if(temp.equals("+")) {
                    Double ans = Double.parseDouble(lhs) + Double.parseDouble(rhs);
                    lhs = Double.toString(ans);
                    input.setText("0");
                    output.setText(lhs);
                } else if(temp.equals("-")) {
                    Double ans = Double.parseDouble(lhs) - Double.parseDouble(rhs);
                    lhs = Double.toString(ans);
                    input.setText("0");
                    output.setText(lhs);
                }else if(temp.equals("*")) {
                    Double ans = Double.parseDouble(lhs) * Double.parseDouble(rhs);
                    lhs = Double.toString(ans);
                    input.setText("0");
                    output.setText(lhs);
                } else if(temp.equals("/")) {
                    if(rhs.equals("")) {
                        input.setText("0");
                        output.setText(lhs);
                        return;
                    }
                    if(Double.parseDouble(rhs) > -0.1 && Double.parseDouble(rhs) < 0.1) {
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                output.setText("INF");
                            }
                        }, 5000);
                        input.setText("0");
                        output.setText("0");
                        return;
                    }
                    Double ans = Double.parseDouble(lhs) / Double.parseDouble(rhs);
                    lhs = Double.toString(ans);
                    input.setText("0");
                    output.setText(lhs);
                }
            }
        });
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(input.getText().toString().length() == 0) {
                    input.setText("0.");
                    flag = 1;
                }
                if(flag == 1) return;
                input.setText(input.getText().toString()+".");
                flag = 1;
            }
        });
        bksp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(input.getText().toString().length() > 0) {
                    String num = input.getText().toString();
                    char ch = num.charAt(num.length()-1);
                    input.setText(num.substring(0, num.length()-1));
                    if(ch == '+' || ch == '-' || ch == '+' || ch == '-' || ch == '%') {
                        operator = "";
                    }
                    if(num.charAt(num.length()-1) == '.') {
                        flag = 0;
                    }
                    if(input.getText().toString().length() == 0) {
                        input.setText("0");
                    }
                }
            }
        });
        ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag = 0;
                operator = "";
                input.setText("0");
                output.setText("0");
            }
        });
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(input.getText().toString().length() == 0) {
                    input.setText("0.");
                    flag = 1;
                }
                if(flag == 1) return;
                input.setText(input.getText().toString()+".");
                flag = 1;
            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(input.getText().toString().length() == 0) {
                    input.setText("0");
                }
                double num = Double.parseDouble(input.getText().toString());
                if(input.getText().toString().length() == 1 && num == 0) return;
                input.setText(input.getText().toString()+"0");
            }
        });
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(input.getText().toString().length() == 1 && input.getText().toString().equals("0")) {
                    input.setText("1");
                    return;
                }
                input.setText(input.getText().toString()+"1");
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(input.getText().toString().length() == 1 && input.getText().toString().equals("0")) {
                    input.setText("2");
                    return;
                }
                input.setText(input.getText().toString()+"2");
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(input.getText().toString().length() == 1 && input.getText().toString().equals("0")) {
                    input.setText("3");
                    return;
                }
                input.setText(input.getText().toString()+"3");
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(input.getText().toString().length() == 1 && input.getText().toString().equals("0")) {
                    input.setText("4");
                    return;
                }
                input.setText(input.getText().toString()+"4");
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(input.getText().toString().length() == 1 && input.getText().toString().equals("0")) {
                    input.setText("5");
                    return;
                }
                input.setText(input.getText().toString()+"5");
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(input.getText().toString().length() == 1 && input.getText().toString().equals("0")) {
                    input.setText("6");
                    return;
                }
                input.setText(input.getText().toString()+"6");
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(input.getText().toString().length() == 1 && input.getText().toString().equals("0")) {
                    input.setText("7");
                    return;
                }
                input.setText(input.getText().toString()+"7");
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(input.getText().toString().length() == 1 && input.getText().toString().equals("0")) {
                    input.setText("8");
                    return;
                }
                input.setText(input.getText().toString()+"8");
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(input.getText().toString().length() == 1 && input.getText().toString().equals("0")) {
                    input.setText("9");
                    return;
                }
                input.setText(input.getText().toString()+"9");
            }
        });
    }
}