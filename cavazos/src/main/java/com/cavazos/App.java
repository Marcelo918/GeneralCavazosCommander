package com.cavazos;

import java.util.Random;
import java.util.*;
import java.io.*;
import org.json.simple.*;
import java.util.Scanner;

/**
 * Author: Marcelo Villalobos Diaz
 * Date: October 14, 2022
 * Class: CSIS26 -FA22
 * Description: The Cavazos Commander App should perform the
 * commands listed in the menu.
 */


public class App 
{
    public static void main( String[] args )
    {
        // path to the JSon File
        String fileName = "/Users/CAD-DESIGNER/Documents/GitHub/GeneralCavazosCommander/cavazos/src/main/java/com/cavazos/commands.json";

        // reads commands
        JSONArray commandJSONArray = JSONFile.readArray(fileName);
        String[] commandArray = getCommandArray(commandJSONArray);
        System.out.println(commandArray);

        // the following are the only characters allowed to be input
        // issue a random command from the 26 possible
        char answerI = 'i';
        // lists all of the commands
        char answerL = 'l';
        // undo the last command that was issued
        char answerU = 'u';
        // redo the last command that was issued
        char answerR = 'r';
        // quits the application
        char answerQ = 'q';

        //Stack<String> newStack = new Stack<>();

        // conditional statement for the while loop
        boolean isRunning = true;

        while (isRunning) {

            //The following print statements is the menu
            System.out.println( "--------------------------------------------" );
            System.out.println("General Cavazos Commander App");
            System.out.println("--------------------------------------------");
            System.out.println("i     Issue a comand");
            System.out.println("l     List all of the commands");
            System.out.println("u     Undo the last command that was issued");
            System.out.println("r     Redo the last command that was issued");
            System.out.println("q     Quit");
            System.out.println( "--------------------------------------------" );

            System.out.print("Enter a command: ");
            // scans for user input
            Scanner user1 = new Scanner(System.in);
            String userAnswer = user1.next();
            char answerCheck = userAnswer.charAt(0);
            // checks if the input is only one character
            if (userAnswer.length() != 1) {

                System.out.println("ERROR: Unknown command!");

            } else if (answerCheck == answerQ) {

                System.out.println("Thank you General Cavazos!");
                break;

            } else if (answerCheck == answerL) {

                System.out.println("------List of all commands------");
                print(commandArray);
                //newStack.push(answerCheck);

            } else if (answerCheck == answerI) {

                System.out.print("[COMMAND ISSUED]: General Cavazos orders the troops to: ");
                randomCommand(commandArray, 1);
                //newStack.push(commandArray);

            } else if (answerCheck == answerR) {

                myStack(commandArray, newNum);


            } else if (answerCheck == answerU) {

                stack_pop();

            } else {

                System.out.println("ERROR: Uknown command!");
            }

            //user1.close();

        }

    }

    public static void printStack(Stack<String> s) {

        if(s.isEmpty()) {
            System.out.println("You have nothing in your stack");
        } else {
            System.out.println(s.peek());
            //System.out.println("This is your stack " + s);
        }
    }

    public static void myStack(String[] commandArray, int newNum) {
        //Stack<String> newStack = new Stack<String>();
        newStack.push(commandArray[newNum]);
        System.out.println("[REDO COMMAND ISSUED]: General Cavazos orders the troops to redo: " + newStack.peek());

    }

    static Stack<String> newStack = new Stack<String>();
    static int newNum;
    static int counter = 0;

    public static void stack_push(String[] commandArray, Stack<String> stack) {

        newStack.push(commandArray[newNum]);
    }

    // undo the last command issued
    public static void stack_pop() {

        if (counter > 0) {

            System.out.println("[UNDO COMMAND ISSUED]: General Cavazos orders the troops to undo: " + newStack.peek());
            counter--;
            newStack.pop();

        } else {

            System.out.println("ERROR: There are no commands to undo. Please issue a new command!");
        }
    }


    // randomly issue commands from General Cavazos
    public static void randomCommand(String[] commandArray, int numCommand) {
        Random rand = new Random();
        //int newNum = 0;
        //Stack<String> stack = new Stack<String>();
        for (int i = 0; i < numCommand; i++) {
            int randIndex = rand.nextInt(commandArray.length);
            System.out.println(commandArray[randIndex]);
            newNum = randIndex;
            newStack.push(commandArray[randIndex]);
            counter++;
            //stack.push(commandArray[randIndex]);
            //printStack(stack);
        }
    }

    // prints command array
    public static void print(String[] commandArray) {
        System.out.printf("Number\tCommand\n");
        System.out.printf("------\t------------\n");
        for (int i = 0; i < commandArray.length; i++) {
            System.out.printf("%02d\t%s\n", i, commandArray[i]);
        }
    }

    // gets array of commands
    public static String[] getCommandArray(JSONArray commandArray) {
        String[] arr = new String[commandArray.size()];

        // gets names from JSon object
        for (int i = 0; i < commandArray.size(); i++) {
            String command = commandArray.get(i).toString();
            arr[i] = command;
        }
        return arr;
    }
}
