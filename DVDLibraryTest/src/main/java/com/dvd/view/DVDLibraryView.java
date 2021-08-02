/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dvd.view;

import com.dvd.controller.DVDController;
import com.dvd.model.DVDLibrary;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Aishwarya
 */
public class DVDLibraryView {

    private static Scanner sc = new Scanner(System.in);
    private static DVDController controller = new DVDController();//controlleer class 

    public static void main(String[] args) throws FileNotFoundException, IOException {
        boolean flag = true;
        int value = 0;
        while(flag){
        System.out.println("Menu");    
        System.out.println("1. Add Library ");
        System.out.println("2. Edit Library :");
        System.out.println("3. Remove");
        System.out.println("4. Get DVD Library List");
        System.out.println("5. Get DVD Library By Title");
        System.out.println("6. Get Particular DVD Library Info");
        System.out.println("7. Do want Continue");
        System.out.println("8. Exit");
        System.out.println("Enter your choice");
        
        value = sc.nextInt();
        sc.nextLine();
        if (value == 1) {
            flag = true;
            addLibrary();
        } else if (value == 2) {
            flag = true;
            editLibrary();
        } else if (value == 3) {
            flag = true;
            removeLibrary();
        } else if (value == 4) {
            flag = true;
            //gettingcollection of dvd
            List<DVDLibrary> list = controller.getListDvd();
            System.out.println("List dvd " + list);
        } else if (value == 5) {
            flag = true;
            getLibraryByTitle();
        } else if (value == 6) {
            getLibraryInfo();
        }
        else if(value == 7){
            flag = true;
        }
        else if(value == 8){
            flag = false;
            //Saving  collections into the file
        String save = controller.saveToFile();
        System.out.println("File save " + save);
        //getting file name
        File file = controller.getfile();
        BufferedReader bufReader = new BufferedReader(new FileReader(file.toString()));
        ArrayList<String> listOfLines = new ArrayList<>(); 
        String line = bufReader.readLine();
        while (line != null) { 
            listOfLines.add(line);
            line = bufReader.readLine(); 
        }



        System.out.println("File Name "+listOfLines);
        }
        else{
            flag = true;
            System.out.println("please enter given options only");
        }
        }

    }

    private static void addLibrary() {
        System.out.println("Please Enter Title :");
        String title = sc.nextLine();
        System.out.println("Please Enter Release Date :");
        String date = sc.nextLine();
        System.out.println("Please Enter MPAA Rating :");
        String mpaaRating = sc.nextLine();
        System.out.println("Please Enter Directors Name :");
        String directorsName = sc.nextLine();
        System.out.println("Please Enter Studio :");
        String studio = sc.nextLine();
        System.out.println("Please Enter Note :");
        String note = sc.nextLine();

        DVDLibrary userLibrary = new DVDLibrary();
        userLibrary.setTitle(title);
        userLibrary.setReleaseDate(date);
        userLibrary.setDirectorsName(directorsName);
        userLibrary.setMpaaRating(mpaaRating);
        userLibrary.setStudio(studio);
        userLibrary.setNote(note);

        //Inserting dvd library to the collection
        String str = controller.insertDvd(userLibrary);
        System.out.println("DVD " + str);
    }

    private static void editLibrary() {
        System.out.println("Please Enter Title :");
        String title = sc.nextLine();
        System.out.println("Please Enter Release Date :");
        String date = sc.nextLine();
        System.out.println("Please Enter MPAA Rating :");
        String mpaaRating = sc.nextLine();
        System.out.println("Please Enter Directors Name :");
        String directorsName = sc.nextLine();
        System.out.println("Please Enter Studio :");
        String studio = sc.nextLine();
        System.out.println("Please Enter Note :");
        String note = sc.nextLine();

        DVDLibrary editLibrary = new DVDLibrary();
        editLibrary.setTitle(title);
        editLibrary.setReleaseDate(date);
        editLibrary.setDirectorsName(directorsName);
        editLibrary.setMpaaRating(mpaaRating);
        editLibrary.setStudio(studio);
        editLibrary.setNote(note);
        String edit = controller.edit(editLibrary);

        System.out.println("DVD " + edit);
    }

    private static void removeLibrary() {
        System.out.println("Please Enter Title :");
        String title = sc.nextLine();
      
        //Removing the record from collection
        String str = controller.remove(title);
        System.out.println("DVD " + str);
    }

    private static void getLibraryByTitle() {
        System.out.println("Please Enter Title: ");
        String title = sc.nextLine();
        DVDLibrary dvdLibrary = controller.getByTitle(title);

        System.out.println("By Title " + dvdLibrary);
    }

    private static void getLibraryInfo() {
        System.out.println("Please Enter Text: ");
        String value = sc.nextLine();
        //get Dvd info based on user value
        DVDLibrary dvdLibrary1 = controller.getDVDInformation(value);

        System.out.println("DVD Info " + dvdLibrary1);
    }

}
