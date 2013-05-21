/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.plutinsky.buildermatters;

import by.plutinsky.domparser.DomParser;
import by.plutinsky.exception.IOParserException;
import by.plutinsky.exception.ParserException;
import com.sun.org.apache.bcel.internal.generic.D2F;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

/**
 *
 * @author Alex
 */
public class DomBuilder extends BuilderMatters {
    
    private Properties prop;

    public DomBuilder() {
        try {
            prop = new Properties();
            prop.load(new FileInputStream("src/properties/properties.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void build() throws ParserException, IOParserException {
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document;
            document = (Document) documentBuilder.parse(prop.getProperty("xmlPath"));
            Element root = document.getDocumentElement();
            DomParser domParser = new DomParser();
            domParser.listBuilder(root);
            matters = domParser.getMatters();
        } catch (IOException e) {
            throw new IOParserException(e);
        } catch (SAXException e) {
            throw new ParserException(e);
        } catch (ParserConfigurationException e) {
            throw new ParserException(e);
        }
    }
}
