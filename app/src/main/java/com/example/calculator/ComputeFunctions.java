package com.example.calculator;

public class ComputeFunctions {

    protected final char ADD = '+', SUBTRACT = '-', MUTIPLY = '*', DIVIDE = '/';
    protected String holdTempResult = "";
    private Boolean initialise;

    protected int computeResult() {
        int result = 0;
        String hold = "";
        char holdPreviousOp = '0';
        initialise = true;

        for (char stringChar : holdTempResult.toCharArray()) {
            if(initialise) {
                String temp = holdTempResult;
            }
            switch (stringChar) {
                case (ADD):
                    holdPreviousOp = ADD;
                    result = operation(holdPreviousOp, result, hold);
                    hold = "";
                    break;
                case (SUBTRACT):
                    holdPreviousOp = SUBTRACT;
                    result = operation(holdPreviousOp, result, hold);
                    hold = "";
                    break;
                case (MUTIPLY):
                    holdPreviousOp = MUTIPLY;
                    result = operation(holdPreviousOp, result, hold);
                    hold = "";
                    break;
                case (DIVIDE):
                    holdPreviousOp = DIVIDE;
                    result = operation(holdPreviousOp, result, hold);
                    hold = "";
                    break;
                default:
                    hold += stringChar;
            }
        }

        result = operation(holdPreviousOp, result, hold);
        return result;
    }

    private int operation(char holdPreviousOp, int result, String num) {
        System.out.println("OP " + result + " " + holdPreviousOp + " " + num + initialise);

        if (initialise) {
            initialise = false;
            return result += Integer.parseInt(num);
        }
        System.out.println("OP " + result + " " + holdPreviousOp + " " + num + initialise);
        switch (holdPreviousOp) {
            case (ADD):
                return result += Integer.parseInt(num);
            case (SUBTRACT):
                return result -= Integer.parseInt(num);
            case (MUTIPLY):
                return result *= Integer.parseInt(num);
            case (DIVIDE):
                return result /= Integer.parseInt(num);
        }
        return 0;
    }
}

