package com.mad2019.cse18_039.kpmcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SimpleCalculator extends AppCompatActivity {

    private boolean isOpperatorPressed = false;
    private char currOpp;
    private double numBeforeOpp = 0;
    int indexOfSecondNum = 0;
    String screenContent;
    private String mem = "";
    public int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_calculator);
        getSupportActionBar().setTitle("Basic Calculator");
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        final TextView screen = findViewById(R.id.screen);
        final TextView fnWin = findViewById(R.id.fnWin);
        final Button modFn = findViewById(R.id.modFn);
        final Button memRec = findViewById(R.id.memRec);
        final Button memC = findViewById(R.id.memC);
        final Button memAdd = findViewById(R.id.memAdd);
        //final Button clear = findViewById(R.id.clearCluster);
        final Button division = findViewById(R.id.division);
        final Button add = findViewById(R.id.addition);
        final Button sub = findViewById(R.id.subtraction);
        final Button multiply = findViewById(R.id.multiplication);
        final Button decimal = findViewById(R.id.decimal);
        //final Button del = findViewById(R.id.del);
        final Button pm = findViewById(R.id.plusMinus);
        final Button equals = findViewById(R.id.equals);
        final Button num0 = findViewById(R.id.num0);
        final Button num1 = findViewById(R.id.num1);
        final Button num2 = findViewById(R.id.num2);
        final Button num3 = findViewById(R.id.num3);
        final Button num4 = findViewById(R.id.num4);
        final Button num5 = findViewById(R.id.num5);
        final Button num6 = findViewById(R.id.num6);
        final Button num7 = findViewById(R.id.num7);
        final Button num8 = findViewById(R.id.num8);
        final Button num9 = findViewById(R.id.num9);

        View.OnClickListener calculatorListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int id = v.getId();
                switch(id){
                    case R.id.num0:
                        screen.append("0");
                        break;

                    case R.id.num1:
                        screen.append("1");
                        break;

                    case R.id.num2:
                        screen.append("2");
                        break;

                    case R.id.num3:
                        screen.append("3");
                        break;

                    case R.id.num4:
                        screen.append("4");
                        break;

                    case R.id.num5:
                        screen.append("5");
                        break;

                    case R.id.num6:
                        screen.append("6");
                        break;

                    case R.id.num7:
                        screen.append("7");
                        break;

                    case R.id.num8:
                        screen.append("8");
                        break;

                    case R.id.num9:
                        screen.append("9");
                        break;

                    case R.id.addition:
                        screenContent = screen.getText().toString();
                        indexOfSecondNum = screenContent.length() + 1;
                        numBeforeOpp = Double.parseDouble(screenContent);
                        screen.append("+");


                        isOpperatorPressed = true;
                        currOpp = '+';

                        break;

                    case R.id.subtraction:
                        screenContent = screen.getText().toString();
                        indexOfSecondNum = screenContent.length() + 1;
                        numBeforeOpp = Double.parseDouble(screenContent);
                        screen.append("-");


                        isOpperatorPressed = true;
                        currOpp = '-';
                        break;

                    case R.id.multiplication:
                        screenContent = screen.getText().toString();
                        indexOfSecondNum = screenContent.length() + 1;
                        numBeforeOpp = Double.parseDouble(screenContent);
                        screen.append("*");


                        isOpperatorPressed = true;
                        currOpp = '*';
                        break;

                    case R.id.division:
                        screenContent = screen.getText().toString();
                        indexOfSecondNum = screenContent.length() + 1;
                        numBeforeOpp = Double.parseDouble(screenContent);
                        screen.append("/");


                        isOpperatorPressed = true;
                        currOpp = '/';
                        break;
                    case R.id.decimal:
                        /*screenContent = screen.getText().toString();
                        screen.setText(screenContent+decimal.getText());*/

                        if(count==0 && screen.length()!=0)
                        {
                            screen.setText(screen.getText()+".");
                            count++;
                        }
                        break;
                    case R.id.plusMinus:
                        //screen.append(Double.parseDouble(screen.getText().toString())*(-1)+"");
                        if(screen.length()!=0)
                        {
                            String s=screen.getText().toString();
                            char arr[]=s.toCharArray();
                            if(arr[0]=='-')
                                screen.setText(s.substring(1,s.length()));
                            else
                                screen.setText("-"+s);
                        }
                        break;
                    case R.id.memAdd:

                        mem = screen.getText().toString();
                        fnWin.append("M");


                        break;
                    case R.id.memC:
                        fnWin.setText("");
                        mem="";
                        break;
                    case R.id.memRec:
                        screen.append(mem);

                        break;
                    case R.id.modFn:
                        screenContent = screen.getText().toString();
                        indexOfSecondNum = screenContent.length() + 1;
                        numBeforeOpp = Double.parseDouble(screenContent);
                        screen.append("%");


                        isOpperatorPressed = true;
                        currOpp = '%';
                        break;
                    case R.id.equals:
                        try {
                            if (isOpperatorPressed) {
                                if (currOpp == '+') {
                                    screenContent = screen.getText().toString();
                                    String secondNumSt = screenContent.substring(indexOfSecondNum, screenContent.length());
                                    double secondNum = Double.parseDouble(secondNumSt);
                                    secondNum += numBeforeOpp;
                                    screen.setText(String.valueOf(secondNum));
                                }
                                if (currOpp == '-') {
                                    screenContent = screen.getText().toString();
                                    String secondNumSt = screenContent.substring(indexOfSecondNum, screenContent.length());
                                    double secondNum = Double.parseDouble(secondNumSt);
                                    secondNum -= numBeforeOpp;
                                    screen.setText(String.valueOf(secondNum));
                                }

                                if (currOpp == '*') {
                                    screenContent = screen.getText().toString();
                                    String secondNumSt = screenContent.substring(indexOfSecondNum, screenContent.length());
                                    double secondNum = Double.parseDouble(secondNumSt);
                                    secondNum *= numBeforeOpp;
                                    screen.setText(String.valueOf(secondNum));
                                }
                                if (currOpp == '/') {
                                    screenContent = screen.getText().toString();
                                    String secondNumSt = screenContent.substring(indexOfSecondNum, screenContent.length());
                                    double secondNum = Double.parseDouble(secondNumSt);
                                    secondNum = numBeforeOpp / secondNum;
                                    screen.setText(String.valueOf(secondNum));
                                }
                                if (currOpp == '%') {
                                    screenContent = screen.getText().toString();
                                    String secondNumSt = screenContent.substring(indexOfSecondNum, screenContent.length());
                                    double secondNum = Double.parseDouble(secondNumSt);
                                    secondNum %= numBeforeOpp;
                                    screen.setText(String.valueOf(secondNum));
                                }
                            }
                        } catch (Exception e){
                            screen.setText("Invalid Expression");
                            e.printStackTrace();
                        }
                        break;

                }
            }
        };

        num0.setOnClickListener(calculatorListener);
        num1.setOnClickListener(calculatorListener);
        num2.setOnClickListener(calculatorListener);
        num3.setOnClickListener(calculatorListener);
        num4.setOnClickListener(calculatorListener);
        num5.setOnClickListener(calculatorListener);
        num6.setOnClickListener(calculatorListener);
        num7.setOnClickListener(calculatorListener);
        num8.setOnClickListener(calculatorListener);
        num9.setOnClickListener(calculatorListener);
        add.setOnClickListener(calculatorListener);
        sub.setOnClickListener(calculatorListener);
        multiply.setOnClickListener(calculatorListener);
        division.setOnClickListener(calculatorListener);
        memAdd.setOnClickListener(calculatorListener);
        memC.setOnClickListener(calculatorListener);
        memRec.setOnClickListener(calculatorListener);
        modFn.setOnClickListener(calculatorListener);
        equals.setOnClickListener(calculatorListener);
        pm.setOnClickListener(calculatorListener);
        decimal.setOnClickListener(calculatorListener);

        final Button del = findViewById(R.id.del);
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String displayedElements = screen.getText().toString();
                int length = displayedElements.length();
                if(length > 0){
                    displayedElements = displayedElements.substring(0,length-1);
                    screen.setText(displayedElements);
                }
            }
        });

        final Button clear = findViewById(R.id.clearCluster);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.setText("");
            }
        });
    }
}
