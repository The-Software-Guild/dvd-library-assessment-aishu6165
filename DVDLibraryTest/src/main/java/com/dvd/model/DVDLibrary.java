/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dvd.model;

/**
 *
 * @author Aishwarya
 */
public class DVDLibrary {
    private String title;
    private String releaseDate;
    private String mpaaRating;
    private String directorsName;
    private String studio;
    private String note;
    
     public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getMpaaRating() {
        return mpaaRating;
    }

    public void setMpaaRating(String mpaaRating) {
        this.mpaaRating = mpaaRating;
    }

    public String getDirectorsName() {
        return directorsName;
    }

    public void setDirectorsName(String directorsName) {
        this.directorsName = directorsName;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
    
     public String toString() {
        return "DVDLibrary{" +
                "title='" + title + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", mpaaRating='" + mpaaRating + '\'' +
                ", directorsName='" + directorsName + '\'' +
                ", studio='" + studio + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
    
}
