/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.plutinsky.filereader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author HP
 */
public class TextScanner {
    private File file;
    
    public TextScanner(String fileName){
        if (fileName.isEmpty()) {
            //throw 
        }
        this.file = new File(fileName);
    }
    
    public String fileParser(){
        StringBuffer fileContent = new StringBuffer();
        try{
            Scanner scan = new Scanner(file);
            scan.useDelimiter("\\Z");
            if (scan.hasNext()) {
                fileContent.append(scan.next());
            }
        }
        catch(FileNotFoundException e)
        {
            System.err.println(e);
        }
        return fileContent.toString();
    }
    
}
