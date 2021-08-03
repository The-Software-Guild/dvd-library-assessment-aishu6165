/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dvdlibrary;

import com.dvd.controller.DVDController;
import com.dvd.dao.DVDDao;
import com.dvd.dao.DVDDaoImpl;
import com.dvd.ui.DVDLibraryView;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;



/**
 *
 * @author Aishwarya
 */
public class App {
     public static void main(String[] args) throws IOException {
        // UserIO userIo= new UserIOConsoleImpl();
         DVDLibraryView dvdLibraryView= new DVDLibraryView();
         DVDDao dvdDao= new DVDDaoImpl();
         DVDController controller= new DVDController(dvdDao,dvdLibraryView);
         dvdLibraryView.setController(controller);
        
        controller.run();
    } 
}