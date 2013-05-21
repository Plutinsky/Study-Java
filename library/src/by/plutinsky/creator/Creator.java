/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.plutinsky.creator;

import by.plutinsky.buildermatters.DomBuilder;
import by.plutinsky.buildermatters.SAXBuilder;
import by.plutinsky.buildermatters.StaxBuilder;
import by.plutinsky.library.Library;
import org.apache.log4j.Logger;

/**
 *
 * @author Alex
 */
public class Creator {
    private static final Logger LOG = Logger
			.getLogger(Creator.class);
    public Creator(){
        LOG.info("SAX");
        Library library = new Library();
        library.setAbstractPrintedMatters(library.buildMatters(new SAXBuilder()));
        library.showAllBooks();
        LOG.info("Stax");
        library.setAbstractPrintedMatters(library.buildMatters(new StaxBuilder()));
        library.showAllBooks();
        LOG.info("DOM");
        library.setAbstractPrintedMatters(library.buildMatters(new DomBuilder()));
        library.showAllBooks();
        
    }
    
}
