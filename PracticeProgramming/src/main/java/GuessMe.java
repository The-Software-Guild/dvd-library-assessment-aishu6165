
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aishwarya
 */


import java.util.Scanner;

public class GuessMe {
    public static void main(String[] args) {
        int number;
        int guess;
        boolean correct = false;

        Scanner input = new Scanner(System.in);
        System.out.println("pick a number: ");
        number= input.nextInt();
        while (!correct) {
            System.out.println("guess");
            guess =input.nextInt();
            if ( guess == number) {
                correct = true;
                System.out.println("Wow, nice guess! That was it!");
            } else if (guess < number) {
                System.out.println("Ha, nice try - too low! I chose #.");
            } else if (guess > number) {
                System.out.println("Too bad, way too high. I chose #.");
            }


        }
    }
}

