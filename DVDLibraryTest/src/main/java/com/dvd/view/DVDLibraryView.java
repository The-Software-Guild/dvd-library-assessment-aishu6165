/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dvd.view;

import com.dvd.controller.DVDController;
import com.dvd.model.DVDLibrary;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Aishwarya
 */
public class DVDLibraryView {
    
    public static void main(String[] args) throws FileNotFoundException{
        Scanner sc = new Scanner(System.in);
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
        
            DVDLibrary library = new DVDLibrary();
		library.setTitle("FirstDvd");library.setReleaseDate("12/07/2021");library.setMpaaRating("4");
		library.setDirectorsName("Test");library.setStudio("Test Studio");library.setNote("Good");
		DVDLibrary library1 = new DVDLibrary();
		library1.setTitle("SecondDvd");library1.setReleaseDate("13/07/2021");library1.setMpaaRating("3");
		library1.setDirectorsName("Test");library1.setStudio("Test Studio");library1.setNote("Average");

		DVDLibrary library2 = new DVDLibrary();
		library2.setTitle("ThirdDvd");library2.setReleaseDate("14/07/2021");library2.setMpaaRating("5");
		library2.setDirectorsName("Test Dir");library2.setStudio("Test Film");library2.setNote("Good to watch");
		DVDController controller = new DVDController();//controlleer class
                //Inserting dvd library to the collection
		String str =  controller.insertDvd(library);
		String str1 = controller.insertDvd(library1);
		String str2 = controller.insertDvd(library2);
                String str3 =  controller.insertDvd(userLibrary);
		System.out.println(str +" "+ str1 +" "+ str2);
                
                //gettingcollection of dvd
		List<DVDLibrary> list = controller.getListDvd();

		System.out.println("List dvd "+list);

                //updating library 2 release date 
		library1.setReleaseDate("14/07/2021");
                   //calling edit functionality
		String edit = controller.edit(library2);

		System.out.println("Edit "+edit);
                
		List<DVDLibrary> list1 = controller.getListDvd();
                System.out.println(list1);
                
                
                //Removing the record from collection
                controller.remove(library2);
                
               
		
                //Get Dvd  Library detail based on tiltle
		DVDLibrary dvdLibrary = controller.getByTitle("FirstDvd");

		System.out.println("By Title "+dvdLibrary);
                
                
                //get Dvd info based on user value
		DVDLibrary dvdLibrary1 = controller.getDVDInformation("Test");

		System.out.println("DVD Info "+dvdLibrary1);

                 //Saving  collections into the file
                String save = controller.saveToFile();
		System.out.println("File save "+save);
                //getting file name
		File file = controller.getfile();

		System.out.println(file.toString());
        
    }
    
}
