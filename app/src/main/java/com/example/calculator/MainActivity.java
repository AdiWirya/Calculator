package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private TextView View;

    private Button clear, clearall, delete, divide, addition, subtract, multiply, equal, minus;

    private Button one, two, three, four, five, six, seven, eight, nine, point, zero;

    private boolean sub = false, add = false, multi = false, div = false, min=false, dot=false;

    private double valueOne = Double.NaN, valueTwo = Double.NaN;

    private int tp;

    private String input="";

    private DecimalFormat df;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        df = new DecimalFormat("###,###.##");
        df.setGroupingSize(3);
        View = findViewById(R.id.Hasil);

        clear = findViewById(R.id.buttonClearText);
        clearall = findViewById(R.id.buttonClearAll);
        delete = findViewById(R.id.buttonDelete);
        divide = findViewById(R.id.buttonDivide);
        addition = findViewById(R.id.buttonAdd);
        subtract = findViewById(R.id.buttonSubtraction);
        multiply = findViewById(R.id.buttonMultiply);
        equal = findViewById(R.id.buttonEqual);
        minus = findViewById(R.id.buttonMinus);

        one = findViewById(R.id.button1);
        two = findViewById(R.id.button2);
        three = findViewById(R.id.button3);
        four = findViewById(R.id.button4);
        five = findViewById(R.id.button5);
        six = findViewById(R.id.button6);
        seven = findViewById(R.id.button7);
        eight = findViewById(R.id.button8);
        nine = findViewById(R.id.button9);
        point = findViewById(R.id.buttonPoint);
        zero = findViewById(R.id.buttonZero);

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                View.setText(null);
                input="";
            }
        });

        clearall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                View.setText(null);
                input="";
                valueOne = Double.NaN;
                valueTwo = Double.NaN;
                sub = false;
                add = false;
                multi = false;
                div = false;
                min = false;
                dot = false;
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(View.getText().length() > 0) {
                    CharSequence currentText = View.getText();
                    View.setText(currentText.subSequence(0, currentText.length()-1));
                }
                else {
                    valueOne = Double.NaN;
                    valueTwo = Double.NaN;
                    View.setText("");
                }
                if(!Double.isNaN(valueOne)){
                    input = View.getText().toString();
                    valueOne = Double.valueOf(input);
                }
            }
        });

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Double.isNaN(valueOne) && input != ""){
                    sub = false;
                    add = false;
                    multi = false;
                    div = true;
                    valueOne = Double.valueOf(input);
                    input="";
                }
                else{
                    if(input != ""){
                        calculate(input);
                        input="";
                        div=true;
                    }
                }
            }
        });

        addition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Double.isNaN(valueOne) && input != ""){
                    sub = false;
                    add = true;
                    multi = false;
                    div = false;
                    valueOne = Double.valueOf(input);
                    input="";
                }
                else{
                    if(input != ""){
                        calculate(input);
                        input="";
                        add =true;
                    }
                }
            }
        });

        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Double.isNaN(valueOne) && input != ""){
                    sub = true;
                    add = false;
                    multi = false;
                    div = false;
                    valueOne = Double.valueOf(input);
                    input="";
                    min=false;
                }
                else{
                    if(input != ""){
                        calculate(input);
                        input="";
                        sub=true;
                    }
                }

            }
        });


        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Double.isNaN(valueOne) && input != ""){
                    sub = false;
                    add = false;
                    multi = true;
                    div = false;
                    valueOne = Double.valueOf(input);
                    input="";
                }
                else{
                    if(input != ""){
                        calculate(input);
                        input="";
                        multi=true;
                    }
                }
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(min==false){
                    input = '-' + input;
                    View.setText(input);
                    min = true;
                }
                else{
                    input = View.getText().toString();
                    tp = input.length();
                    input = input.substring(1,tp);
                    View.setText(input);
                    min = false;
                }
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Double.isNaN(valueOne) && input != ""){
                    input = View.getText().toString();
                    View.setText(input);
                }
                else{
                    if(input != ""){
                        calculate(input);
                    }
                }
            }
        });


        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Double.isNaN(valueOne)){
                    input = View.getText().toString();
                    input += '1';
                    View.setText(input);
                }
                else{
                    if(input == ""){
                        input += '1';
                        View.setText(input);
                    }
                    else {
                        input = View.getText().toString();
                        input += '1';
                        View.setText(input);
                    }
                }
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Double.isNaN(valueOne)){
                    input = View.getText().toString();
                    input += '2';
                    View.setText(input);
                }
                else{
                    if(input == ""){
                        input += '2';
                        View.setText(input);
                    }
                    else {
                        input = View.getText().toString();
                        input += '2';
                        View.setText(input);
                    }
                }
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Double.isNaN(valueOne)){
                    input = View.getText().toString();
                    input += '3';
                    View.setText(input);
                }
                else{
                    if(input == ""){
                        input += '3';
                        View.setText(input);
                    }
                    else {
                        input = View.getText().toString();
                        input += '3';
                        View.setText(input);
                    }
                }
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Double.isNaN(valueOne)){
                    input = View.getText().toString();
                    input += '4';
                    View.setText(input);
                }
                else{
                    if(input == ""){
                        input += '4';
                        View.setText(input);
                    }
                    else {
                        input = View.getText().toString();
                        input += '4';
                        View.setText(input);
                    }
                }
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Double.isNaN(valueOne)){
                    input = View.getText().toString();
                    input += '5';
                    View.setText(input);
                }
                else{
                    if(input == ""){
                        input += '5';
                        View.setText(input);
                    }
                    else {
                        input = View.getText().toString();
                        input += '5';
                        View.setText(input);
                    }
                }
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Double.isNaN(valueOne)){
                    input = View.getText().toString();
                    input += '6';
                    View.setText(input);
                }
                else{
                    if(input == ""){
                        input += '6';
                        View.setText(input);
                    }
                    else {
                        input = View.getText().toString();
                        input += '6';
                        View.setText(input);
                    }
                }
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Double.isNaN(valueOne)){
                    input = View.getText().toString();
                    input += '7';
                    View.setText(input);
                }
                else{
                    if(input == ""){
                        input += '7';
                        View.setText(input);
                    }
                    else {
                        input = View.getText().toString();
                        input += '7';
                        View.setText(input);
                    }
                }
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Double.isNaN(valueOne)){
                    input = View.getText().toString();
                    input += '8';
                    View.setText(input);
                }
                else{
                    if(input == ""){
                        input += '8';
                        View.setText(input);
                    }
                    else {
                        input = View.getText().toString();
                        input += '8';
                        View.setText(input);
                    }
                }
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Double.isNaN(valueOne)){
                    input = View.getText().toString();
                    input += '9';
                    View.setText(input);
                }
                else{
                    if(input == ""){
                        input += '9';
                        View.setText(input);
                    }
                    else {
                        input = View.getText().toString();
                        input += '9';
                        View.setText(input);
                    }
                }
            }
        });

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Double.isNaN(valueOne)){
                    input = View.getText().toString();
                    input += '0';
                    View.setText(input);
                }
                else{
                    if(input == ""){
                        input += '0';
                        View.setText(input);
                    }
                    else {
                        input = View.getText().toString();
                        input += '0';
                        View.setText(input);
                    }
                }
            }
        });
        point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(input == ""){
                    input = "0.";
                    View.setText(input);
                    dot=true;
                }
                else{
                    if(dot==false){
                        input = View.getText().toString();
                        input += '.';
                        View.setText(input);
                        dot = true;
                    }
                }
            }
        });
    }

    private void calculate(String input){
            valueTwo = Double.parseDouble(input);
            View.setText(null);

            if(add == true)
                valueOne = this.valueOne + valueTwo;
            else if(sub == true)
                valueOne = this.valueOne - valueTwo;
            else if(multi == true)
                valueOne = this.valueOne * valueTwo;
            else if(div == true)
                valueOne = this.valueOne / valueTwo;

            valueTwo=Double.NaN;
            input = df.format(valueOne);
            View.setText(input);
            sub = false;
            add = false;
            multi = false;
            div = false;
            min=false;
            dot=false;
    }

}
