/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dvd.service;

import com.dvd.model.DVDLibrary;
import java.util.List;

/**
 *
 * @author Aishwarya
 */
public interface DVDService {
    
     public String  add(DVDLibrary dvdLibrary);
     public String  edit(DVDLibrary dvdLibrary);
     public String  remove(String title);
     public  List<DVDLibrary> getListDvd();
     public DVDLibrary getByTitle(String title);
     public DVDLibrary getDVDInformation(String name);
    
}
