/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dvd.dao;

import com.dvd.model.DVDLibrary;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aishwarya
 */
public class DVDDaoImpl implements DVDDao {

    //declaring and intialzing this variable for reusing this throughout the application life
    private static List<DVDLibrary> dvdList = new ArrayList<>();

    @Override
    public String add(DVDLibrary dvdLibrary) {
        //Adding dvdLibrary to List
        dvdList.add(dvdLibrary);

        return "Dvd added";
    }

    @Override
    public String edit(DVDLibrary dvdLibrary) {
        DVDLibrary library = dvdList.stream().filter(dvd -> dvd.getTitle().equals(dvdLibrary.getTitle())).findAny().orElse(null);

        int index = 0;
        if (library != null) {
            index = dvdList.indexOf(library);
        } else {
            index = -1;
        }
        if (index > -1) {

            dvdList.set(index, dvdLibrary);
            return "updated";
        } else {
            return "Object not found";
        }

    }

    @Override
    public String remove(String title) {
        //Iterates that list and try to filter based on given value
        DVDLibrary library = dvdList.stream().filter(dvd -> dvd.getTitle().replace("'", "").equals(title)).findAny().orElse(null);
        boolean removed = dvdList.remove(library);
        if (removed) {
            return "Removed";
        } else {
            return "Object already removed";
        }
    }

    @Override
    public List<DVDLibrary> getListDvd() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new BufferedReader(new FileReader(new File("dvdFile"))));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DVDDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<String> listOfLines = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
              DVDLibrary dvd = new DVDLibrary();
            String[] words = line.split(",");

            for (String word : words) {
              
                String[] w = word.split("=");
                if (word.contains("title")) {
                    dvd.setTitle(w[1]);
                }
                if (word.contains("releaseDate")) {
                    dvd.setReleaseDate(w[1]);
                }
                if (word.contains("mpaaRating")) {
                    dvd.setMpaaRating(w[1]);
                }
                
                if (word.contains("directorsName")) {
                    dvd.setDirectorsName(w[1]);
                }
                if (word.contains("studio")) {
                    dvd.setStudio(w[1]);
                }
                if (word.contains("note")) {
                    dvd.setNote(w[1]);
                }             
            }
            if(dvd.getTitle()!=null)
                dvdList.add(dvd);
            //split string// name, id, tile, rating,
        }
        
        return dvdList;
    }

    @Override
    public DVDLibrary getByTitle(String title) {
        
        DVDLibrary library = dvdList.stream().filter(dvd -> dvd.getTitle().replace("'", "").equalsIgnoreCase(title)).findFirst().orElse(null);
        return library;
    }

    @Override
    public DVDLibrary getDVDInformation(String name) {
        DVDLibrary library = dvdList.stream().filter(dvd -> dvd.getTitle().replace("'", "").equals(name) || dvd.getDirectorsName().replace("'", "").equals(name)
                || dvd.getMpaaRating().replace("'", "").equals(name) || dvd.getReleaseDate().replace("'", "").equals(name) || dvd.getNote().replace("'", "").equals(name) || dvd.getStudio().replace("'", "").equals(name)).findAny().orElse(null);
        return library;
    }
}
