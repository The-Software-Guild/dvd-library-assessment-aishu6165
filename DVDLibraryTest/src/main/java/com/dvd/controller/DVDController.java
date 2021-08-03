/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dvd.controller;

import com.dvd.model.DVDLibrary;
import com.dvd.dao.DVDDaoImpl;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.List;
import com.dvd.dao.DVDDao;
import com.dvd.ui.DVDLibraryView;
import java.io.IOException;

/**
 *
 * @author Aishwarya
 * This will be work as a controller it will take request from user and send to service
 * Service is dependent class of Controller
 * we are providing service object to controller
 */
public class DVDController {
     private DVDDao dvdService ;
     
  private DVDLibraryView dvdView ;

    public DVDController(DVDDao dvdDao, DVDLibraryView dvdLibraryView) {
         //To change body of generated methods, choose Tools | Templates.
         this.dvdService=dvdDao;
         this.dvdView = dvdLibraryView;
    }

     public void run() throws IOException {
         dvdView.execute();
    }
    public String add( DVDLibrary dvdLibrary){
        String str = dvdService.add(dvdLibrary);

        return str;
    }

    
    public String edit( DVDLibrary dvdLibrary){
        String str = dvdService.edit(dvdLibrary);

        return str;
    }

    
    public String remove( String title){
        String str = dvdService.remove(title);

        return str;
    }

    
    public List<DVDLibrary> getListDvd(){

        return dvdService.getListDvd();
    }

    
    public DVDLibrary getByTitle( String title){
        DVDLibrary library = dvdService.getByTitle(title);

        return library;
    }

    
    public DVDLibrary getDVDInformation( String name){
        DVDLibrary library = dvdService.getDVDInformation(name);

        return library;
    }

    
    public String saveToFile() throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(new FileOutputStream("dvdFile"));
        List<DVDLibrary> dvdLibraries = dvdService.getListDvd();
        for (DVDLibrary dvdLibrary : dvdLibraries)
        {
            System.out.println("Data to be saved to file -----------------------"+dvdLibrary);
            pw.println(dvdLibrary); //
        }
        
        pw.close();

        return "save with file dvdFile";
    }


    public File getfile(){
        File file = new File("dvdFile");

        return file;
    }

    
}
