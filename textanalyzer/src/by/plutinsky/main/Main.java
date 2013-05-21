/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.plutinsky.main;

import by.plutinsky.creatortextparser.Creator;
import by.plutinsky.filereader.TextScanner;

/**
 *
 * @author HP
 */
public class Main {
    public static void main(String[] args) {
        Creator creator = new Creator();
        creator.createTextParser();
    }
    
}
