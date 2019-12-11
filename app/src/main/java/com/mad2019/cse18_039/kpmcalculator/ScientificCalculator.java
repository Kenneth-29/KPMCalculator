package com.mad2019.cse18_039.kpmcalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Math.PI;

public class ScientificCalculator extends AppCompatActivity {

    private boolean isOpperatorPressed = false;
    private char currOpp;
    String opp;
    private double numBeforeOpp = 0;
    int indexOfSecondNum = 0;
    String screenContent;
    private String mem = "";
    public int count=0;
    public int toggleMode=1;
    public int angleMode=1;
    int fct =0;
    double temp = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scientific_calculator);
        getSupportActionBar().setTitle("Scientific Calculator");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


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
        final Button toggle = findViewById(R.id.FnMode);
        final Button mode = findViewById(R.id.mode);
        final Button sin = findViewById(R.id.sin);
        final Button cos = findViewById(R.id.cos);
        final Button tan = findViewById(R.id.tan);
        final Button xsq = findViewById(R.id.xsq);
        final Button pi = findViewById(R.id.pi);
        final Button epown = findViewById(R.id.epown);
        final Button log = findViewById(R.id.log);
        final Button fact = findViewById(R.id.factorial);
        mode.setTag(1);
        toggle.setTag(1);


        View.OnClickListener calculatorListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final int id = v.getId();

                toggleMode=(int)toggle.getTag();
                angleMode=(int)mode.getTag();
                switch(id){
                    case R.id.FnMode:

                        //change the button text if switch button is clicked
                        if(toggleMode==1)
                        {
                            toggle.setTag(2);
                            sin.setText(R.string.sininv);
                            cos.setText(R.string.cosinv);
                            tan.setText(R.string.taninv);
                            epown.setText(R.string.tenpow);
                            xsq.setText(R.string.xpown);
                            pi.setText(R.string.sqrt);
                            log.setText(R.string.naturalLog);
                            fact.setText(R.string.inverse);

                        }
                        else
                        {
                            toggle.setTag(1);
                            sin.setText(R.string.sin);
                            cos.setText(R.string.cos);
                            tan.setText(R.string.tan);
                            epown.setText(R.string.epown);
                            xsq.setText(R.string.xsq);
                            pi.setText(R.string.pi);
                            log.setText(R.string.log);
                            fact.setText(R.string.factorial);
                        }
                        break;

                    case R.id.mode:
                        //change the angle property for trignometric operations if mode button is clicked
                        if(angleMode==1)
                        {
                            mode.setTag(2);
                            mode.setText(R.string.mode2);
                        }
                        else
                        {
                            mode.setTag(1);
                            mode.setText(R.string.mode1);
                        }
                        break;
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
                    case R.id.sin:
                        if(screen.length() !=0) {
                            screenContent = screen.getText().toString();
                            double angle;
                            if (angleMode == 1) {

                                if (toggleMode == 1) {
                                    screen.setText("sin(" + screenContent + ")");
                                    angle = Math.toRadians(Math.sin(Double.parseDouble(screenContent)));
                                    temp = angle;
                                } else if (toggleMode == 2) {
                                    screen.setText("sinInv(" + screenContent + ")");
                                    angle = Math.toRadians(Math.asin(Double.parseDouble(screenContent)));
                                    temp = angle;
                                }

                            } else if (angleMode == 2) {
                                if (toggleMode == 1) {
                                    screen.setText("sin(" + screenContent + ")");
                                    angle = Math.toDegrees(Math.sin(Double.parseDouble(screenContent)));
                                    temp = angle;
                                } else if (toggleMode == 2) {
                                    screen.setText("sinInv(" + screenContent + ")");
                                    angle = Math.toDegrees(Math.asin(Double.parseDouble(screenContent)));
                                    temp = angle;
                                }
                            }
                        }
                        isOpperatorPressed = true;
                        currOpp = 's';
                        break;

                    case R.id.cos:
                        if(screen.length() !=0) {
                            screenContent = screen.getText().toString();
                            double angle;
                            if (angleMode == 1) {

                                if (toggleMode == 1) {
                                    screen.setText("cos(" + screenContent + ")");
                                    angle = Math.toRadians(Math.cos(Double.parseDouble(screenContent)));
                                    temp = angle;
                                } else if (toggleMode == 2) {
                                    screen.setText("cosInv(" + screenContent + ")");
                                    angle = Math.toRadians(Math.acos(Double.parseDouble(screenContent)));
                                    temp = angle;
                                }

                            } else if (angleMode == 2) {
                                if (toggleMode == 1) {
                                    screen.setText("cos(" + screenContent + ")");
                                    angle = Math.toDegrees(Math.tan(Double.parseDouble(screenContent)));
                                    temp = angle;
                                } else if (toggleMode == 2) {
                                    screen.setText("cosInv(" + screenContent + ")");
                                    angle = Math.toDegrees(Math.atan(Double.parseDouble(screenContent)));
                                    temp = angle;
                                }
                            }
                        }
                        isOpperatorPressed = true;
                        currOpp = 'c';
                        break;

                    case R.id.tan:
                        if(screen.length() !=0) {
                            screenContent = screen.getText().toString();
                            double angle;
                            if (angleMode == 1) {

                                if (toggleMode == 1) {
                                    screen.setText("tan(" + screenContent + ")");
                                    angle = Math.toRadians(Math.tan(Double.parseDouble(screenContent)));
                                    temp = angle;
                                } else if (toggleMode == 2) {
                                    screen.setText("tanInv(" + screenContent + ")");
                                    angle = Math.toRadians(Math.atan(Double.parseDouble(screenContent)));
                                    temp = angle;
                                }

                            } else if (angleMode == 2) {
                                if (toggleMode == 1) {
                                    screen.setText("tan(" + screenContent + ")");
                                    angle = Math.toDegrees(Math.tan(Double.parseDouble(screenContent)));
                                    temp = angle;
                                } else if (toggleMode == 2) {
                                    screen.setText("tanInv(" + screenContent + ")");
                                    angle = Math.toDegrees(Math.atan(Double.parseDouble(screenContent)));
                                    temp = angle;
                                }
                            }
                        }

                        isOpperatorPressed = true;
                        currOpp = 't';
                        break;
                    case R.id.pi:
                        if(screen.length() !=0){
                            screenContent = screen.getText().toString();
                            if(toggleMode==1){
                               screen.setText("π" + screenContent);
                               temp=Double.parseDouble(screenContent);
                               temp*= PI;
                            }else{
                                screen.setText("√"+ screenContent);
                                temp=Double.parseDouble(screenContent);
                                Math.sqrt(temp);
                            }
                        }
                        isOpperatorPressed = true;
                        currOpp = 'π';

                        break;
                    case R.id.xsq:
                        if (screen.length() != 0) {
                            screenContent = screen.getText().toString();
                            if(toggleMode==1){
                                screen.setText("(" + screenContent + ")^2");
                            temp=Math.pow(Double.parseDouble(screenContent), 2.0);}
                          }


                            else if (toggleMode==2){
                                screen.setText("(" + screenContent + ")^");
                            String secondNumSt = screenContent.substring(indexOfSecondNum, screenContent.length());
                            double secondNum= Double.parseDouble(secondNumSt);
                            temp = Math.pow(Double.parseDouble(screenContent), secondNum);
                        }
                        isOpperatorPressed = true;
                        currOpp = '^';


                        break;
                    case R.id.epown:
                        if(screen.length()!=0){
                            screenContent = screen.getText().toString();
                            if(toggleMode==1){
                                screen.setText("e^(" + screenContent + ")");
                                temp = Math.exp(Double.parseDouble(screenContent));
                            }else {
                                screen.setText("10^("+ screenContent +")");
                                String secondNumSt = screenContent.substring(indexOfSecondNum, screenContent.length());
                                double secondNum= Double.parseDouble(secondNumSt);
                                temp=Double.parseDouble(screenContent);
                                temp *= Math.pow(10.0, secondNum);
                            }
                        }
                        isOpperatorPressed=true;
                        currOpp='e';
                        break;
                    case R.id.log:
                        if (screen.length() != 0) {
                            screenContent = screen.getText().toString();
                            if (toggleMode == 2)
                                screen.setText("ln(" + screenContent + ")");
                            temp = Double.parseDouble(screenContent);
                            Math.log10(temp);
                        }
                            else {
                                screen.setText("log(" + screenContent + ")");
                                temp = Double.parseDouble(screenContent);
                                Math.log(temp);
                        }
                        isOpperatorPressed = true;
                        currOpp = '&';

                        break;
                    case R.id.factorial:
                        if(screen.length() !=0){
                            screenContent = screen.getText().toString();
                            if(toggleMode==1) {
                                try {
                                    for (int i = 1; i < Integer.parseInt(screenContent); i++) {
                                        fct *= i;
                                    }

                                    screen.setText(screenContent + "!");


                                } catch (Exception e) {
                                    if (e.toString().contains("ArrayIndexOutOfBoundsException")) {
                                        screen.setText("Result too big!");
                                    } else
                                        screen.setText("Invalid!!");
                                    e.printStackTrace();
                                }
                            }else if (toggleMode==2){

                            }
                        }
                        isOpperatorPressed = true;
                        currOpp = '!';

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
                                    secondNum = numBeforeOpp% secondNum;
                                    screen.setText(String.valueOf(secondNum));
                                }
                                if(currOpp == '^'){
                                    screen.setText(String.valueOf(temp));
                                }
                                if(currOpp=='!'){
                                    screen.setText(String.valueOf(temp));
                                }
                                if(currOpp == 'π'){
                                    screen.setText(String.valueOf(temp));
                                }
                                if(currOpp=='s'){
                                    screen.setText(String.valueOf(temp));
                                }
                                if(currOpp=='c'){
                                    screen.setText(String.valueOf(temp));
                                }
                                if(currOpp=='t'){
                                    screen.setText(String.valueOf(temp));
                                }
                                if(currOpp=='&'){
                                    screen.setText(String.valueOf(temp));
                                }
                                if(currOpp=='e'){
                                    screen.setText(String.valueOf(temp));
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
        toggle.setOnClickListener(calculatorListener);
        mode.setOnClickListener(calculatorListener);
        sin.setOnClickListener(calculatorListener);
        cos.setOnClickListener(calculatorListener);
        tan.setOnClickListener(calculatorListener);
        xsq.setOnClickListener(calculatorListener);
        pi.setOnClickListener(calculatorListener);
        epown.setOnClickListener(calculatorListener);
        log.setOnClickListener(calculatorListener);
        fact.setOnClickListener(calculatorListener);


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
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mF = getMenuInflater();
        mF.inflate(R.menu.calc_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                Toast.makeText(this, "Settings Selected", Toast.LENGTH_SHORT).show();
                openSet();
                return true;

            case R.id.item2:
                Toast.makeText(this, "NOT AVAILABLE", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.item3:
                Toast.makeText(this, "Help Selected", Toast.LENGTH_SHORT).show();
                openHelp();
                return true;
            case R.id.item4:
                Toast.makeText(this, "App closed, Goodbye!!", Toast.LENGTH_LONG).show();
                finish();
            default:
                return super.onOptionsItemSelected(item);
        }

    }
    public void openSet(){
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
    }
    public void openHelp(){
        Intent intent = new Intent(this, Help.class);
        startActivity(intent);
    }


}
