/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.plutinsky.buildermatters;

import by.plutinsky.exception.IOParserException;
import by.plutinsky.exception.ParserException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import by.plutinsky.saxparser.MatterHandler;

/**
 *
 * @author Alex
 */
public class SAXBuilder extends BuilderMatters {

    private Properties prop;

    public SAXBuilder() {
        try {
            prop = new Properties();
            prop.load(new FileInputStream("src/properties/properties.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void build() throws ParserException,
            IOParserException{
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            MatterHandler matterHandler = new MatterHandler();
            reader.setContentHandler(matterHandler);
            if (matterHandler != null) {
                reader.parse((prop.getProperty("xmlPath")));
                matters = matterHandler.getMatters();
            }
        } catch (SAXException e) {
            throw new ParserException(e);
        }  catch (IOException e) {
            throw new IOParserException(e);
        }
    }
}
