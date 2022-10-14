package com.cavazos;

import java.util.Random;
import org.json.simple.*;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String fileName = "/Users/CAD-DESIGNER/Documents/GitHub/GeneralCavazosCommander/cavazos/src/main/java/com/cavazos/commands.json";

        JSONArray commandJSONArray = JSONFile.readArray(fileName);
        String[] commandArray = getCommandArray(commandJSONArray);
        System.out.println(commandArray);

        char answerI = 'i';
        char answerL = 'l';
        char answerU = 'u';
        char answerR = 'r';
        char answerQ = 'q';

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

            Scanner user1 = new Scanner(System.in);
            String userAnswer = user1.next();
            char answerCheck = userAnswer.charAt(0);

            if (userAnswer.length() != 1) {

                System.out.println("Invalid input. Please enter a valid command!");

            } else if (answerCheck == answerQ) {

                System.out.println("Goodbye! See you soon!");
                break;

            } else if (answerCheck == answerL) {

                System.out.println("------List of all commands------");
                print(commandArray);

            } else {

                System.out.println("Invalid input. Please enter a valid command!");
            }

            //user1.close();

        }

    }

    public static void print(String[] commandArray) {
        System.out.printf("Number\tCommand\n");
        System.out.printf("------\t------------\n");
        for (int i = 1; i < commandArray.length; i++) {
            System.out.printf("%02d\t%s\n", i, commandArray[i]);
        }
    }

    public static String[] getCommandArray(JSONArray commandArray) {
        String[] arr = new String[commandArray.size()];

        for (int i = 0; i < commandArray.size(); i++) {
            String command = commandArray.get(i).toString();
            arr[i] = command;
        }
        return arr;
    }
}
