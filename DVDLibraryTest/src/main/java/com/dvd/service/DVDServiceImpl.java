/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dvd.service;

import com.dvd.model.DVDLibrary;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Aishwarya
 */
public class DVDServiceImpl implements DVDService {
    //declaring and intialzing this variable for reusing this thorughout the application life
    private static List<DVDLibrary> dvdList = new ArrayList<>();
    
    @Override
    public String  add(DVDLibrary dvdLibrary){
         //Adding dvdLibrary to List
        dvdList.add(dvdLibrary);


        return "Dvd added";
    }

    @Override
    public String  edit(DVDLibrary dvdLibrary){
        DVDLibrary library = dvdList.stream().filter(dvd->dvd.getTitle().equals(dvdLibrary.getTitle())).findAny().orElse(null);

        int index = 0;
        if(library!=null){
           index = dvdList.indexOf(library);
        }
        else{
            index=-1;
        }
        if(index > -1){
           
            dvdList.set(index,dvdLibrary);
            return "updated";
        }
        else{
            return "Object not found";
        }


    }

    @Override
    public String  remove(String title){
        DVDLibrary library = dvdList.stream().filter(dvd->dvd.getTitle().equals(title)).findAny().orElse(null);
        boolean removed = dvdList.remove(library);
        if(removed)
            return "Removed";
        else
            return "Object already removed";
    }

    @Override
    public  List<DVDLibrary> getListDvd(){
        return dvdList;
    }

    @Override
    public DVDLibrary getByTitle(String title){
        DVDLibrary library = dvdList.stream().filter(dvd->dvd.getTitle().equals(title)).findAny().orElse(null);
        return library;
    }

    @Override
    public DVDLibrary getDVDInformation(String name){
        DVDLibrary library = dvdList.stream().filter(dvd->dvd.getTitle().equals(name)|| dvd.getDirectorsName().equals(name)
        || dvd.getMpaaRating().equals(name)|| dvd.getReleaseDate().equals(name)||dvd.getNote().equals(name)||dvd.getStudio().equals(name)).findAny().orElse(null);
        return library;
    }
}
