package com.example.calculator;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MyButtons extends ComputeFunctions implements View.OnClickListener {
    private Activity activity;
    private TextView textView;
    private boolean previousResultActivated;

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
        Button buttonNegative = (Button) activity.findViewById(R.id.buttonNegative);
        buttonNegative.setOnClickListener(this);
        Button buttonClear = (Button) activity.findViewById(R.id.buttonClear);
        buttonClear.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button0:
                if(previousResultActivated) break;
                holdTempResult += "0";
                holdTempCopy += "0";
                textView.setText(holdTempCopy);
                break;
            case R.id.button1:
                if(previousResultActivated) break;
                holdTempResult += "1";
                holdTempCopy += "1";
                textView.setText(holdTempCopy);
                break;
            case R.id.button2:
                if(previousResultActivated) break;
                holdTempResult += "2";
                holdTempCopy += "2";
                textView.setText(holdTempCopy);
                break;
            case R.id.button3:
                if(previousResultActivated) break;
                holdTempResult += "3";
                holdTempCopy += "3";
                textView.setText(holdTempCopy);
                break;
            case R.id.button4:
                if(previousResultActivated) break;
                holdTempResult += "4";
                holdTempCopy += "4";
                textView.setText(holdTempCopy);
                break;
            case R.id.button5:
                if(previousResultActivated) break;
                holdTempResult += "5";
                holdTempCopy += "5";
                textView.setText(holdTempCopy);
                break;
            case R.id.button6:
                if(previousResultActivated) break;
                holdTempResult += "6";
                holdTempCopy += "6";
                textView.setText(holdTempCopy);
                break;
            case R.id.button7:
                if(previousResultActivated) break;
                holdTempResult += "7";
                holdTempCopy += "7";
                textView.setText(holdTempCopy);
                break;
            case R.id.button8:
                if(previousResultActivated) break;
                holdTempResult += "8";
                holdTempCopy += "8";
                textView.setText(holdTempCopy);
                break;
            case R.id.button9:
                if(previousResultActivated) break;
                holdTempResult += "9";
                holdTempCopy += "9";
                textView.setText(holdTempCopy);
                break;
            case R.id.buttonAdd:
                if(previousResultActivated) {
                    holdTempCopy = "";
                    numbers.remove(0); // del
                }

                previousResultActivated = false;
                holdTempResult += ADD;
                holdTempCopy += ADD;
                textView.setText(holdTempCopy);
                break;
            case R.id.buttonMultiply:
                if(previousResultActivated){
                    holdTempCopy = "";
                    numbers.remove(0); // del
                }

                previousResultActivated = false;
                holdTempResult += MULTIPLY;
                holdTempCopy += MULTIPLY;
                textView.setText(holdTempCopy);
                break;
            case R.id.buttonSubtract:
                if(previousResultActivated)
                {
                    holdTempCopy = "";
                    numbers.remove(0); // del
                }

                previousResultActivated = false;
                holdTempResult += SUBTRACT;
                holdTempCopy += SUBTRACT;
                textView.setText(holdTempCopy);
                break;
            case R.id.buttonDivide:
                if(previousResultActivated)
                {
                    holdTempCopy = "";
                    numbers.remove(0); // del
                }

                previousResultActivated = false;
                holdTempResult += DIVIDE;
                holdTempCopy += DIVIDE;
                textView.setText(holdTempCopy);
                break;
            case R.id.buttonDec:
                holdTempResult += ".";
                System.out.println("Decimal pressed");
                holdTempCopy += ".";
                textView.setText(holdTempCopy);
                break;
            case R.id.buttonNegative:
                holdTempCopy += "-";
                holdTempResult += "_";
                System.out.println("Negative pressed");
                textView.setText(holdTempCopy);
                break;
            case R.id.buttonEquals:
                double answer = computeResult();
                holdTempResult = Double.toString(answer);
                System.out.printf("Your holdTempResult when equal is pressed is: %s\n", holdTempResult);

                // to account for a negative number not having the underscore prefix
                // Ex: -10 will throw error because program recognizes "-" as an operator
                //   : This will replace "-" with "_", so the program can distinguish operator versus sign

                previousResultActivated = true;
                previousNumberIsNegative = answer < 0 ? true : false;

                System.out.printf("Your holdTempResult when after operator change: %s\n", holdTempResult);

                textView.setText(holdTempResult);
                break;
            case R.id.buttonClear:
                if(previousResultActivated && numbers.size() != 0) numbers.remove(0);
                holdTempResult = "";
                holdTempCopy = "";
                previousResultActivated = false;
                previousNumberIsNegative = false;
                textView.setText(holdTempResult);
                break;
        }
    }


}
