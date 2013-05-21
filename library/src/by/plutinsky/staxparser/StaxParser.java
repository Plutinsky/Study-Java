/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.plutinsky.staxparser;


import by.plutinsky.exception.ParserException;
import java.io.InputStream;
import java.util.ArrayList;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import by.plutinsky.matter.AbstractPrintedMatter;
import by.plutinsky.matter.Book;
import by.plutinsky.periodical.AbstractPeriodical;
import by.plutinsky.periodical.Magazine;
import by.plutinsky.periodical.Newspaper;
import by.plutinsky.saxparser.MatterEnum;

/**
 *
 * @author Alex
 */
public class StaxParser {

    private ArrayList<AbstractPrintedMatter> matters = new ArrayList<AbstractPrintedMatter>();

    public void setMatters(ArrayList<AbstractPrintedMatter> matters) {
        this.matters = matters;
    }

    public ArrayList<AbstractPrintedMatter> getMatters() {
        return matters;
    }
    
    

    public String readTag(XMLStreamReader reader)
            throws XMLStreamException {
        String text = "";
        //try {
        text = reader.getElementText().trim();
        //} catch (XMLStreamException ex) {
        //      LOG.info(ex.toString());
        //}
        return text;
    }

//    public void parse(InputStream input) throws ParserException{
//        try {
//            XMLInputFactory inputFactory = XMLInputFactory.newInstance();
//            XMLStreamReader reader = inputFactory.createXMLStreamReader(input);
//            process(reader);
//        } catch (XMLStreamException ex) {
//            throw new ParserException(ex);
//        }
//    }

    public void process(XMLStreamReader reader) {
        try {
            AbstractPrintedMatter matter = null;
            String name;
            while (reader.hasNext()) {
                int type = reader.next();
                switch (type) {
                    case XMLStreamConstants.START_ELEMENT:
                        name = reader.getLocalName();
                        switch (MatterEnum.valueOf(name.toUpperCase())) {
                            case MATTERS:
                                break;
                            case BOOK:
                                matter = new Book();
                                matter.setId(reader.getAttributeValue(0));
                                break;
                            case MAGAZINE:
                                matter = new Magazine();
                                matter.setId(reader.getAttributeValue(0));
                                break;
                            case NEWSPAPER:
                                matter = new Newspaper();
                                matter.setId(reader.getAttributeValue(0));
                                break;
                            case IMPRINT_DATE:
                                matter.setImprintDate(readTag(reader));
                                break;
                            case NUMBER_PAGES:
                                matter.setNumberPage(Integer.parseInt(readTag(reader)));
                                break;
                            case PUBLISHING_HOUSE:
                                matter.setPublishingHouse(readTag(reader));
                                break;
                            case TITLE:
                                matter.setTitle(readTag(reader));
                                break;
                            case AUTHOR:
                                ((Book) matter).setAuthor(readTag(reader));
                                break;
                            case NUMBER:
                                ((AbstractPeriodical) matter).setNumber(readTag(reader));
                                break;
                            case PERIODICITY:
                                ((AbstractPeriodical) matter).setPeriodicity(Integer.parseInt(readTag(reader)));
                                break;
                            case REDACTOR:
                                ((AbstractPeriodical) matter).setRedactor(readTag(reader));
                                break;
                            case TOPICALITY:
                                ((Newspaper) matter).setTopicality(Integer.parseInt(readTag(reader)));
                            default:
                                break;
                        }
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        name = reader.getLocalName();
                        switch (MatterEnum.valueOf(name.toUpperCase())) {
                            case BOOK:
                                matters.add(matter);
                                break;
                            case MAGAZINE:
                                matters.add(matter);
                                break;
                            case NEWSPAPER:
                                matters.add(matter);
                                break;
                            default:
                                break;
                        }
                    default:
                        break;
                }
            }

        } catch (XMLStreamException ex) {
        }
    }
}
