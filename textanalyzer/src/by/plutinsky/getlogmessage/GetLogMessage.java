/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.plutinsky.getlogmessage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.Logger;

/**
 *
 * @author HP
 */
public class GetLogMessage {
    private Properties prop;
    public static final Logger log = Logger.getLogger(GetLogMessage.class);
    
    public GetLogMessage(){
        try{
            prop = new Properties();
            prop.load(new FileInputStream("src/logproperties/logmessages.properties"));
        }
        catch(FileNotFoundException e){
            log.error(fileNotFound());
        }
        catch(IOException ex){
            log.error(fileNotFound());
        }
    }
    
    public String fileNotFound(){
        return prop.getProperty("log.filenotfound");
    }
    
    public String getLogParagraph(){
        return prop.getProperty("log.paragraph");
    }
    
    public String getLogListing(){
        return prop.getProperty("log.listing");
    }
    
    public String getLogSentance(){
        return prop.getProperty("log.sentance");
    }
    
    public String getLogInputText(){
        return prop.getProperty("log.inputtext");
    }
    
    public String getLogOutputText(){
        return prop.getProperty("log.outputtext");
    }
    
    public String getLogWord(){
        return prop.getProperty("log.word");
    }
    
    public String getLogSortedSentance(){
        return prop.getProperty("log.sorted");
    }
    
    public String getLogPunctuation(){
        return prop.getProperty("log.punctuation");
    }
    
    
    
}
