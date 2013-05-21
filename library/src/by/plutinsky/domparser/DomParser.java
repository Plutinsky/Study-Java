/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.plutinsky.domparser;

import java.util.ArrayList;
import by.plutinsky.matter.AbstractPrintedMatter;
import by.plutinsky.matter.Book;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import by.plutinsky.periodical.Magazine;
import by.plutinsky.periodical.Newspaper;

/**
 *
 * @author Alex
 */
public class DomParser {

    private ArrayList<AbstractPrintedMatter> matters = new ArrayList<AbstractPrintedMatter>();

    public ArrayList<AbstractPrintedMatter> getMatters() {
        return matters;
    }
    
    

    public void listBuilder(Element root) {
        NodeList matterNodes = root.getElementsByTagName("book");
        Book book;
        for (int i = 0; i < matterNodes.getLength(); i++) {
            book = new Book();
            Element matterElement = (Element) matterNodes.item(i);
            book.setId(matterElement.getAttribute("id"));
            book.setAuthor(getBabyValue(matterElement, "author"));
            book.setImprintDate(getBabyValue(matterElement, "imprint_date"));
            book.setNumberPage(Integer.parseInt(getBabyValue(matterElement, "number_pages")));
            book.setPublishingHouse(getBabyValue(matterElement, "publishing_house"));
            book.setTitle(getBabyValue(matterElement, "title"));
            matters.add(book);
        }
        
        matterNodes = root.getElementsByTagName("magazine");
        Magazine magazine;
        for (int i = 0; i < matterNodes.getLength(); i++) {
            magazine = new Magazine();
            Element matterElement = (Element) matterNodes.item(i);
            magazine.setId(matterElement.getAttribute("id"));
            magazine.setRedactor(getBabyValue(matterElement, "redactor"));
            magazine.setNumber(getBabyValue(matterElement, "number"));
            magazine.setPeriodicity(Integer.parseInt(getBabyValue(matterElement, "periodicity")));
            magazine.setImprintDate(getBabyValue(matterElement, "imprint_date"));
            magazine.setNumberPage(Integer.parseInt(getBabyValue(matterElement, "number_pages")));
            magazine.setPublishingHouse(getBabyValue(matterElement, "publishing_house"));
            magazine.setTitle(getBabyValue(matterElement, "title"));
            matters.add(magazine);
        }
        
        
        matterNodes = root.getElementsByTagName("newspaper");
        Newspaper newspaper;
        for (int i = 0; i < matterNodes.getLength(); i++) {
            newspaper = new Newspaper();
            Element matterElement = (Element) matterNodes.item(i);
            newspaper.setId(matterElement.getAttribute("id"));
            newspaper.setRedactor(getBabyValue(matterElement, "redactor"));
            newspaper.setNumber(getBabyValue(matterElement, "number"));
            newspaper.setPeriodicity(Integer.parseInt(getBabyValue(matterElement, "periodicity")));
            newspaper.setImprintDate(getBabyValue(matterElement, "imprint_date"));
            newspaper.setNumberPage(Integer.parseInt(getBabyValue(matterElement, "number_pages")));
            newspaper.setPublishingHouse(getBabyValue(matterElement, "publishing_house"));
            newspaper.setTitle(getBabyValue(matterElement, "title"));
            newspaper.setTopicality(Integer.parseInt(getBabyValue(matterElement, "topicality")));
            matters.add(newspaper);
        }
    }

    private Element getBaby(Element parent, String childName) {
        NodeList nodeList = parent.getElementsByTagName(childName);
        Element child = (Element) nodeList.item(0);
        return child;
    }

    private String getBabyValue(Element parent, String childName) {
        Element child = getBaby(parent, childName);
        Node node = child.getFirstChild();
        String value = node.getNodeValue();
        return value;
    }
}
