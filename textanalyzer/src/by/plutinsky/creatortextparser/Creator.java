/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.plutinsky.creatortextparser;

import by.plutinsky.filereader.TextScanner;
import by.plutinsky.parsingtext.ParsingText;
import by.plutinsky.actiononthetext.BuildText;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import by.plutinsky.getlogmessage.GetLogMessage;
import by.plutinsky.actiononthetext.SortSentance;

/**
 *
 * @author HP
 */
public class Creator {
    private static final Logger log = Logger.getLogger(Creator.class);
    private GetLogMessage logMessage = new GetLogMessage();
    public Creator(){
        PropertyConfigurator.configure("src/logproperties/log4j.properties");
    }
    public void createTextParser(){
        ParsingText parsingText = new ParsingText();
        TextScanner scan = new TextScanner("test5.txt");
        String inputText = scan.fileParser();
        log.info(logMessage.getLogInputText());
        log.info("\n"+inputText);
        parsingText.parseText(inputText);
        BuildText outputText = new BuildText(parsingText.getText());
        outputText.buildText();
        log.info(logMessage.getLogOutputText());
        log.info("\n"+outputText.getText());
        
        log.info(logMessage.getLogSortedSentance());
        SortSentance sortText = new SortSentance(parsingText.getText());
        sortText.sort();
        BuildText outputSortText = new BuildText(sortText.getSortedText());
        outputSortText.buildText();
        log.info("\n"+outputSortText.getText());
    }
    
}
