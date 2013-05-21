/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.plutinsky.buildermatters;

import by.plutinsky.exception.IOParserException;
import by.plutinsky.exception.ParserException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import by.plutinsky.staxparser.StaxParser;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

/**
 *
 * @author Alex
 */
public class StaxBuilder extends BuilderMatters{
        
    private Properties prop;

    public StaxBuilder() {
        try {
            prop = new Properties();
            prop.load(new FileInputStream("src/properties/properties.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void build() throws ParserException, IOParserException {
          InputStream inputStream = null;
        try {
            StaxParser staxParser = new StaxParser();
            inputStream = new FileInputStream(prop.getProperty("xmlPath"));
            XMLInputFactory inputFactory = XMLInputFactory.newInstance();
            XMLStreamReader reader = inputFactory.createXMLStreamReader(inputStream);
            staxParser.process(reader);
            matters = staxParser.getMatters();
            }catch(IOException e){
                throw new IOParserException(e);
            }catch(XMLStreamException e){
                throw new ParserException(e);
            }finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException ex) {
                   throw new IOParserException(ex);
                }
            }
        }
        
    }
    
    
    
    
}
