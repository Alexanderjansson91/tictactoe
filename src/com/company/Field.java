package com.company;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Field {

    private String[] gameboard;
    private int counter = 0;

    //Constructor for my array (gameboard)
    public Field() {
        gameboard = new String[9];
        gameboard[0] = " ";
        gameboard[1] = " ";
        gameboard[2] = " ";
        gameboard[3] = " ";
        gameboard[4] = " ";
        gameboard[5] = " ";
        gameboard[6] = " ";
        gameboard[7] = " ";
        gameboard[8] = " ";
    }
    //method of placing symbol
    public void placeMarker(String marker, int position) {
        gameboard[position - 1] = marker;
        counter++;
    }

    //method to se if position is available
    public boolean available(int position) {

        if (gameboard[position - 1].equals(" ")) {
            return true;
        }
        return false;
    }

    //method of finding a result. "Switch" define thoose ways you can win on
    public boolean results() {

        for (int a = 0; a < 8; a++) {
            String line = null;
            switch (a) {
                case 0:
                    line = gameboard[0] + gameboard[1] + gameboard[2];
                    break;
                case 1:
                    line = gameboard[3] + gameboard[4] + gameboard[5];
                    break;
                case 2:
                    line = gameboard[6] + gameboard[7] + gameboard[8];
                    break;
                case 3:
                    line = gameboard[0] + gameboard[3] + gameboard[6];
                    break;
                case 4:
                    line = gameboard[1] + gameboard[4] + gameboard[7];
                    break;
                case 5:
                    line = gameboard[2] + gameboard[5] + gameboard[8];
                    break;
                case 6:
                    line = gameboard[0] + gameboard[4] + gameboard[8];
                    break;
                case 7:
                    line = gameboard[2] + gameboard[4] + gameboard[6];
                    break;
            }
            //if the winner is "x", this is printed
            if (line.equals("xxx")) {
                System.out.println("Grattis, vinnaren är x!");
                return true;
            }
            //if the winner is "o", this is printed
            if (line.equals("ooo")) {
                System.out.println("Grattis, vinnaren är o!");
                return true;
            }
        }
        //9 turns is a tie game.
        if (counter == 9) {
            System.out.println("Spelet slutade lika, ingen vann!");
            return true;
        }
        return false;
    }

    //Print out my gameboard.
    public void print() {
        System.out.println("-------");
        System.out.print("|");
        System.out.print(gameboard[0]);
        System.out.print("|");
        System.out.print(gameboard[1]);
        System.out.print("|");
        System.out.print(gameboard[2]);
        System.out.println("|");
        System.out.print("|");
        System.out.print(gameboard[3]);
        System.out.print("|");
        System.out.print(gameboard[4]);
        System.out.print("|");
        System.out.print(gameboard[5]);
        System.out.println("|");
        System.out.print("|");
        System.out.print(gameboard[6]);
        System.out.print("|");
        System.out.print(gameboard[7]);
        System.out.print("|");
        System.out.print(gameboard[8]);
        System.out.println("|");
        System.out.println("-------");

    }
//Menu for the game
    public boolean newGame() {

        boolean option = false;
        while (option == false) {
            try {
                Scanner input = new Scanner(System.in);
                System.out.print("1) Starta nytt spel:  2) Avsluta:");
                int menu = input.nextInt();
                // Starts a newgame
                if (menu == 1) {
                    System.out.println("Låt bästa spelare vinna!");
                    return true;
                }
                //ends the program
                if (menu == 2) {
                    System.out.println("Spelet är avslutat, hoppas vi ses snart igen!");
                    return false;
                }

            } catch (InputMismatchException err) {
                System.out.println("\nFel inmatning!");

            }

        }
        return true;
    }
}
