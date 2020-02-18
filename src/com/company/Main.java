package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //declare two new persons
        Person p1 = new Person("PlayerOne ", "x");
        Person p2 = new Person("PlayerTwo ", "o");
        Scanner scan = new Scanner(System.in);

        //While loop for the the entire game
        boolean gamerun = true;
        while (gamerun) {

        //Prints out information and a blank Field

            System.out.println("______________________________________");
            System.out.println("Nytt spel");
            Field field = new Field();
            field.print();

        //Playerone game round
            boolean results = false;
            while (results == false) {
                System.out.println(p1.getName() + " " + p1.getSymbol() + " Välj en siffra mellan 1-9 och placera ut din markör:");
                boolean vaildchooice = false;
                while (vaildchooice == false) {
                    int choice = scan.nextInt();
        //if chooice is free return true, else false
                    if (field.available(choice) == true) {
                        field.placeMarker(p1.getSymbol(), choice);
                        vaildchooice = true;
                    } else {
                        System.out.println("Posistion är upptagen!");
                        System.out.println(p1.getName() + " " + p1.getSymbol() + " Välj en siffra mellan 1-9 och placera ut din markör:");
                    }


                }

//Declure winner or draw game
                results = field.results();
                field.print();

// when the game is complete, the loop stops

                if (results == true) {
                    break;
                }
//Playertwo game round
                System.out.println(p2.getName() + " " + p2.getSymbol() + " Välj en siffra mellan 1-9 och placera ut din markör:");
                boolean vaildchooice2 = false;
                while (vaildchooice2 == false) {

                    int choice = scan.nextInt();
//if chooice is free return true, else false
                    if (field.available(choice) == true) {
                        field.placeMarker(p2.getSymbol(), choice);
                        vaildchooice2 = true;
                    } else {
                        System.out.println("Posistion är upptagen!");
                        System.out.println(p2.getName() + " " + p2.getSymbol() + " Välj en siffra mellan 1-9 och placera ut din markör:");
                    }
//Declure winner or draw game

                    results = field.results();
                    field.print();
                    // when the game is complete, the loop stops
                }
                if (results == true) {
                    break;
                }

            }
//Menu whit two diffrent options (newgame or end the program)
            gamerun = field.newGame();
        }

    }

}


