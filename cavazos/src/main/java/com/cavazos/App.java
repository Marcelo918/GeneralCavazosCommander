package com.cavazos;

import java.util.Random;
import java.util.*;
import java.io.*;
import org.json.simple.*;
import java.util.Scanner;

/**
 * Author: Marcelo Villalobos Diaz
 * Date: October 23, 2022
 * Class: CSIS26 -FA22
 * Description: The Cavazos Commander App should perform the
 * commands listed in the menu.
 */


public class App 
{
    static Stack<String> commandStack = new Stack<String>();
    static int newNum;

    public static void main( String[] args )
    {
        // path to the JSon File
        String fileName = "/Users/CAD-DESIGNER/Documents/GitHub/GeneralCavazosCommander/cavazos/src/main/java/com/cavazos/commands.json";

        // reads commands
        JSONArray commandJSONArray = JSONFile.readArray(fileName);
        String[] commandArray = getCommandArray(commandJSONArray);
        System.out.println(commandArray);

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

            } else if (answerCheck == 'q') {

                System.out.println("Thank you General Cavazos!");
                break;

            } else if (answerCheck == 'l') {

                System.out.println("------List of all commands------");
                print(commandArray);

            } else if (answerCheck == 'i') {

                System.out.print("[COMMAND ISSUED]: General Cavazos orders the troops to: ");
                randomCommand(commandArray, 1);

            } else if (answerCheck == 'r') {

                commandRedo(commandArray, newNum);


            } else if (answerCheck == 'u') {

                commandUndo();

            } else {

                System.out.println("ERROR: Uknown command!");
            }

        }

    }

    // redo the previous command issued
    public static void commandRedo(String[] commandArray, int newNum) {

        commandStack.push(commandArray[newNum]);
        System.out.println("[REDO COMMAND ISSUED]: General Cavazos orders the troops to redo: " + commandStack.peek());

    }

    // undo the last command issued
    public static void commandUndo() {

        if (commandStack.size() > 0) {

            System.out.println("[UNDO COMMAND ISSUED]: General Cavazos orders the troops to undo: " + commandStack.peek());
            commandStack.pop();

        } else {

            System.out.println("ERROR: There are no commands to undo. Please issue a new command!");
        }
    }


    // randomly issue commands from General Cavazos
    public static void randomCommand(String[] commandArray, int numCommand) {
        Random rand = new Random();
        for (int i = 0; i < numCommand; i++) {
            int randIndex = rand.nextInt(commandArray.length);
            System.out.println(commandArray[randIndex]);
            newNum = randIndex;
            commandStack.push(commandArray[randIndex]);
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
