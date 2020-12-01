package com.example.calculator;

import java.util.ArrayList;

public class ComputeFunctions {

    protected final char ADD = '+', SUBTRACT = '-', MULTIPLY = '*', DIVIDE = '/', NEGATIVE = '_';
    protected String holdTempResult = "";
    protected String holdTempCopy = "";
    private Boolean initialise;
    protected ArrayList<Double> numbers = new ArrayList<>();

    protected ArrayList<Character> operations = new ArrayList<>();
    protected boolean opFixed = false;
    protected boolean negativeSignChosen = false;
    protected boolean previousNumberIsNegative = false;

    // Follows PEMDAS
    protected double computeResult() {
        System.out.printf("Your string before operations: %s\n", holdTempResult);

        // if answer is negative, then I need to change my negative to the special operator
        // Ex: -10 --> _10
        if(previousNumberIsNegative)
        {
            holdTempResult =  holdTempResult.replaceFirst("-", "_");
            previousNumberIsNegative = false;
        }
        System.out.printf("Your string after operations: %s\n", holdTempResult);

        // parse String to separate the numbers from the operators
        getNumbersAndOperators();

        // Fixes the problem when I write
        // Example: 5+
        // Then equal is pressed, there is no crash
        if(theListsAreEqual(numbers, operations)) {
            System.out.printf("PASS LISTS EQUAL %s==%s\n", numbers.size(), operations.size());
            numbers.clear();
            operations.clear();
            opFixed = true;
            return 0;
        }

        System.out.printf("Your string after numop seperation: %s\n", holdTempResult);

        // Multiply and Divide first
        for(int i = 0; i < operations.size(); i++)
        {
            // Apply multiplication operator on two numbers adjacent to this operator
            if(operations.get(i) == '*')
            {
                numbers.set(i, numbers.get(i) * numbers.get(i+1));
                numbers.remove(i+1);
                operations.remove(i);
                i=0;
                i--;
                continue;
            }

            // Apply division operator on two numbers adjacent to this operator
            if(operations.get(i) == '/')
            {
                numbers.set(i, numbers.get(i) / numbers.get(i+1));
                numbers.remove(i+1);
                operations.remove(i);
                i=0;
                i--;
                continue;
            }
        }

        // Add and Subtract Second
        for(int i = 0; i < operations.size(); i += 1)
        {
            System.out.println("ADD");

            // Apply addition operator on two numbers adjacent to this operator
            if(operations.get(i) == '+')
            {
                numbers.set(i, numbers.get(i) + numbers.get(i+1));
                numbers.remove(i+1);
                operations.remove(i);
                i=0;
                i--;
                continue;
            }

            // Apply subtraction operator on two numbers adjacent to this operator
            if(operations.get(i) == '-')
            {
                numbers.set(i, numbers.get(i) - numbers.get(i+1));
                numbers.remove(i+1);
                operations.remove(i);
                i=0;
                i--;
                continue;
            }
        }
        System.out.printf("[computeResult()] Your answer: %s\n", numbers.get(0));

        return numbers.get(0);
    }

    // Checks if both lists are equal
    protected boolean theListsAreEqual(ArrayList<Double> int_list, ArrayList<Character> char_list)
    {
        return int_list.size() == char_list.size();
    }

    // Parses through the String and adds both the operators and numbers into separate lists
    private void getNumbersAndOperators()
    {
        int result = 0;
        int index = 0;
        String hold = "";
        char holdPreviousOp = '0';
        initialise = true;

        for (char stringChar : holdTempResult.toCharArray()) {
            switch (stringChar) {
                case (NEGATIVE):
                    System.out.println("Negative sign character recognized\n");
                    negativeSignChosen = true;
                    break;
                case (ADD):
                    if(negativeSignChosen)
                    {
                        System.out.printf("Hold in add = %s\n", hold);
                        hold = hold.replace("_", "");
                        numbers.add(Double.parseDouble(hold) * (-1.0));
                    }
                    else
                    {
                        numbers.add(Double.parseDouble(hold));
                    }
                    operations.add(ADD);
                    hold = "";
                    negativeSignChosen = false;
                    break;
                case (SUBTRACT):
                    if(negativeSignChosen)
                    {
                        hold = hold.replaceFirst("_", "");

                        numbers.add(Double.parseDouble(hold) * (-1.0));
                    }
                    else
                    {
                        System.out.printf("Hold in subtract = %s\n", hold);
                        numbers.add(Double.parseDouble(hold));
                    }
                    operations.add(SUBTRACT);
                    hold = "";
                    negativeSignChosen = false;
                    break;
                case (MULTIPLY):
                    if(negativeSignChosen)
                    {
                        hold = hold.replaceFirst("_", "");

                        numbers.add(Double.parseDouble(hold) * (-1.0));
                    }
                    else
                    {
                        numbers.add(Double.parseDouble(hold));
                    }
                    operations.add(MULTIPLY);
                    hold = "";
                    negativeSignChosen = false;
                    break;
                case (DIVIDE):
                    if(negativeSignChosen)
                    {
                        hold = hold.replaceFirst("_", "");

                        numbers.add(Double.parseDouble(hold) * (-1.0));
                    }
                    else
                    {
                        numbers.add(Double.parseDouble(hold));
                    }
                    operations.add(DIVIDE);
                    hold = "";
                    negativeSignChosen = false;
                    break;
                default:
                    // bug could be here
                    hold += stringChar;
            }
            index += 1;
        }
        System.out.printf("Hold after forloop = %s\n", hold);
        if(negativeSignChosen)
        {
            System.out.println("pass neg\n");
            hold = hold.replaceFirst("_", "");
            numbers.add(Double.parseDouble(hold) * (-1.0));
        }
        else
        {
            System.out.println("pass pos\n");
            numbers.add(Double.parseDouble(hold));
        }


        // checks just in case I have
        // Example: 5+
        // Then I press equal, there is no crash
        if(theListsAreEqual(numbers, operations)) return;

        System.out.printf("[getNumbersAndOperators()] Size of numbers list: %s\n", numbers.size());
        System.out.printf("[getNumbersAndOperators()] Size of operators list: %s\n", operations.size());
        printList(numbers, operations);

    }

    // For debugging purposes
    private void printList(ArrayList<Double> ints, ArrayList<Character> ops)
    {
        System.out.printf("---------------------------\nInteger List: ");
        for(Double i : ints)
        {
            System.out.printf("%s,", i);
        }
        System.out.println();
        System.out.printf("Character List: ");
        for(Character c : ops)
        {
            System.out.printf("%s,", c);
        }
        System.out.println("\n-------------------------------");
    }

    // Max's original operation function
    private int operation(char holdPreviousOp, int result, String hold) {
        System.out.println("OP " + result + " " + holdPreviousOp + " " + hold + initialise);

        // takes care of initial result being zero
        // This will take the number that was being concat in compute result, and make result equal to it
        if (initialise) {
            initialise = false;
            return result += Integer.parseInt(hold);
        }
        System.out.println("OP " + result + " " + holdPreviousOp + " " + hold + initialise);
        switch (holdPreviousOp) {
            case (ADD):
                return result += Integer.parseInt(hold);
            case (SUBTRACT):
                return result -= Integer.parseInt(hold);
            case (MULTIPLY):
                return result *= Integer.parseInt(hold);
            case (DIVIDE):
                return result /= Integer.parseInt(hold);
        }
        return 0;
    }
}

