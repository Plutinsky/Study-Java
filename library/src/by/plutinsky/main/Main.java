/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.plutinsky.main;

import org.apache.log4j.PropertyConfigurator;
import by.plutinsky.creator.Creator;


/**
 *
 * @author Alex
 */
public class Main {
    public static void main(String[] args) {
        PropertyConfigurator.configure("src/properties/log4j.properties");
        Creator creator = new Creator();
        
        //Library library = new Library();
        //library.setAbstractPrintedMatters(buildMatters(new SAXBuilder()));
        
        
    }
    
}
