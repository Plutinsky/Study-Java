/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.plutinsky.saxparser;

import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import by.plutinsky.matter.AbstractPrintedMatter;
import by.plutinsky.matter.Book;
import org.xml.sax.Locator;
import by.plutinsky.periodical.Magazine;
import by.plutinsky.periodical.Newspaper;
import by.plutinsky.periodical.AbstractPeriodical;

/**
 *
 * @author Alex
 */
public class MatterHandler implements ContentHandler {

    private ArrayList<AbstractPrintedMatter> matters = new ArrayList<AbstractPrintedMatter>();
    private AbstractPrintedMatter curr = null;
    private MatterEnum currEnum = null;

    public ArrayList<AbstractPrintedMatter> getMatters() {
        return matters;
    }

    @Override
    public void startDocument() throws SAXException {
        //вывести в лог 
    }

    @Override
    public void endDocument() throws SAXException {
    }
    

    @Override
    public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
        if (qName.equals("book")) {
            curr = new Book();
            curr.setId(atts.getValue(0));
        }

        if (qName.equals("magazine")) {
            curr = new Magazine();
            curr.setId(atts.getValue(0));
        }

        if (qName.equals("newspaper")) {
            curr = new Newspaper();
            curr.setId(atts.getValue(0));
        }

        if (!qName.equals("book") && !qName.equals("magazine") && !qName.equals("newspaper")
                && !qName.equals("matters")) {
            currEnum = MatterEnum.valueOf(qName.toUpperCase());
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("book")) {
            matters.add(curr);
        }
        if (qName.equals("magazine")) {
            matters.add(curr);
        }
        if (qName.equals("newspaper")) {
            matters.add(curr);
        }
        currEnum = null;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String s = new String(ch, start, length).trim();
        if (currEnum == null) {
            return;
        }

        switch (currEnum) {
            case AUTHOR:
                ((Book) curr).setAuthor(s);
                break;

            case TITLE:
                curr.setTitle(s);
                break;

            case IMPRINT_DATE:
                curr.setImprintDate(s);
                break;

            case NUMBER_PAGES:
                curr.setNumberPage(Integer.parseInt(s));
                break;
            case PUBLISHING_HOUSE:
                curr.setPublishingHouse(s);
                break;
            case NUMBER:
                ((AbstractPeriodical) curr).setNumber(s);
                break;
            case REDACTOR:
                ((AbstractPeriodical) curr).setRedactor(s);
                break;
            case PERIODICITY:
                ((AbstractPeriodical) curr).setPeriodicity(Integer.parseInt(s));
                break;
            case TOPICALITY:
                ((Newspaper) curr).setTopicality(Integer.parseInt(s));
                break;


        }
    }

    @Override
    public void endPrefixMapping(String prefix) throws SAXException {
    }

    @Override
    public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void processingInstruction(String target, String data) throws SAXException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void startPrefixMapping(String prefix, String uri) throws SAXException {
    }

    @Override
    public void setDocumentLocator(Locator locator) {
    }

    @Override
    public void skippedEntity(String name) throws SAXException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
