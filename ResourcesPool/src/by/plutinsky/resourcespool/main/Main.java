/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.plutinsky.resourcespool.main;

import by.plutinsky.resourcespool.poolcreator.PoolCreator;
import org.apache.log4j.PropertyConfigurator;

/**
 *
 * @author HP
 */
public class Main {
    public static void main(String[] args) {
        PropertyConfigurator.configure("src/logproperties/log4j.properties");
        PoolCreator creator = new PoolCreator(5, 20);
        creator.start();
    }
    
}
