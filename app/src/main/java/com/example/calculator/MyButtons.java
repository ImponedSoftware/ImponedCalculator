package com.example.calculator;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.calculator.R;


public class MyButtons extends ComputeFunctions implements View.OnClickListener {
    private Activity activity;
    private TextView textView;


    public MyButtons(Activity activity) {
        this.activity = activity;
        this.textView = (TextView) activity.findViewById(R.id.textView);
        textView.setText(holdTempResult);
        createButtons();
    }


    public void createButtons() {
        Button button0 = (Button) activity.findViewById(R.id.button0);
        button0.setOnClickListener(this);
        Button button1 = (Button) activity.findViewById(R.id.button1);
        button1.setOnClickListener(this);
        Button button2 = (Button) activity.findViewById(R.id.button2);
        button2.setOnClickListener(this);
        Button button3 = (Button) activity.findViewById(R.id.button3);
        button3.setOnClickListener(this);
        Button button4 = (Button) activity.findViewById(R.id.button4);
        button4.setOnClickListener(this);
        Button button5 = (Button) activity.findViewById(R.id.button5);
        button5.setOnClickListener(this);
        Button button6 = (Button) activity.findViewById(R.id.button6);
        button6.setOnClickListener(this);
        Button button7 = (Button) activity.findViewById(R.id.button7);
        button7.setOnClickListener(this);
        Button button8 = (Button) activity.findViewById(R.id.button8);
        button8.setOnClickListener(this);
        Button button9 = (Button) activity.findViewById(R.id.button9);
        button9.setOnClickListener(this);
        Button buttonAdd = (Button) activity.findViewById(R.id.buttonAdd);
        buttonAdd.setOnClickListener(this);
        Button buttonSubtract = (Button) activity.findViewById(R.id.buttonSubtract);
        buttonSubtract.setOnClickListener(this);
        Button buttonMultiply = (Button) activity.findViewById(R.id.buttonMultiply);
        buttonMultiply.setOnClickListener(this);
        Button buttonDivide = (Button) activity.findViewById(R.id.buttonDivide);
        buttonDivide.setOnClickListener(this);
        Button buttonEquals = (Button) activity.findViewById(R.id.buttonEquals);
        buttonEquals.setOnClickListener(this);
        Button buttonDec = (Button) activity.findViewById(R.id.buttonDec);
        buttonDec.setOnClickListener(this);
        Button buttonClear = (Button) activity.findViewById(R.id.buttonClear);
        buttonClear.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button0:
                holdTempResult += "0";
                textView.setText(holdTempResult);
                break;
            case R.id.button1:
                holdTempResult += "1";
                textView.setText(holdTempResult);
                break;
            case R.id.button2:
                holdTempResult += "2";
                textView.setText(holdTempResult);
                break;
            case R.id.button3:
                holdTempResult += "3";
                textView.setText(holdTempResult);
                break;
            case R.id.button4:
                holdTempResult += "4";
                textView.setText(holdTempResult);
                break;
            case R.id.button5:
                holdTempResult += "5";
                textView.setText(holdTempResult);
                break;
            case R.id.button6:
                holdTempResult += "6";
                textView.setText(holdTempResult);
                break;
            case R.id.button7:
                holdTempResult += "7";
                textView.setText(holdTempResult);
                break;
            case R.id.button8:
                holdTempResult += "8";
                textView.setText(holdTempResult);
                break;
            case R.id.button9:
                v.setBackgroundResource(R.drawable.custom_dialog);
                holdTempResult += "9";
                textView.setText(holdTempResult);
                break;
            case R.id.buttonAdd:
                holdTempResult += ADD;
                textView.setText(holdTempResult);
                break;
            case R.id.buttonMultiply:
                holdTempResult += MUTIPLY;
                textView.setText(holdTempResult);
                break;
            case R.id.buttonSubtract:
                holdTempResult += SUBTRACT;
                textView.setText(holdTempResult);
                break;
            case R.id.buttonDivide:
                holdTempResult += DIVIDE;
                textView.setText(holdTempResult);
                break;
            case R.id.buttonDec:
                holdTempResult += ".";
                textView.setText(holdTempResult);
                break;
            case R.id.buttonEquals:
                holdTempResult = Integer.toString(computeResult());
                textView.setText(holdTempResult);
                break;
            case R.id.buttonClear:
                holdTempResult = "";
                textView.setText(holdTempResult);
                break;
        }
    }
}
