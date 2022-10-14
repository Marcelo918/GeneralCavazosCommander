package com.cavazos;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
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
            } else {

                System.out.println("Invalid input. Please enter a valid command!");
            }

            //user1.close();

        }

    }
}
