package ca.yorku.d5_capsapp;

import java.util.List;
import java.util.Map;

import ca.roumani.i2c.Country;
import ca.roumani.i2c.CountryDB;

public class Game {
    private CountryDB db;
    private String result;


    public Game(){
        this.db= new CountryDB();

    }
    public String qa(){
        List<String> capitals=db.getCapitals();
        int numberOfCapitals= capitals.size();
        int index = (int)(numberOfCapitals  * Math.random()) ;
        String c =capitals.get(index);

        Map<String, Country> data=db.getData() ;
        Country ref =data.get(c) ;

        String countryName , capitalName ;
        countryName=ref.getName();
        capitalName=ref.getCapital();


        if (Math.random() < 0.5){
            String question= "What is the capital of  " + countryName+ " ?" ;
            this.result = question + "\n" + capitalName ;
        }
        else {
            String question= ref.getCapital() + " is capital of?" ;
            this.result = capitalName +" is the capital of? \n"+ countryName ;

        }
        return result;
    }

}
