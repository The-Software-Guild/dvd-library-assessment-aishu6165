
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
public class TheProblemwithScanner {
    public static void main(String[]args){
        String name;
        int age;
        
        Scanner sc = new Scanner(System.in);
        System.out.println("please enter your name: ");
        name = sc.nextLine();
        System.out.println("you said:" );
         System.out.println("name: " +name);
    }
}
