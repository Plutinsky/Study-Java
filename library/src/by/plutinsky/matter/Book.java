/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.plutinsky.matter;

import java.util.HashMap;

/**
 *
 * @author Alex
 */
public class Book extends AbstractPrintedMatter{
    protected String author;

    public Book(){
    }

    public Book(String author, String id, String imprintDate, String publishingHouse, int numberPage, String title) {
        super(id, imprintDate, publishingHouse, numberPage, title);
        this.author = author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    
    public String getAuthor() {
        return author;
    }
    
    @Override
    public HashMap<String, String> getInfo() {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("Id", this.getId());
        map.put("PublishingHouse",this.getPublishingHouse());
        map.put("Title", this.getTitle());
        map.put("NumberPage", String.valueOf(this.getNumberPage()));
        map.put("ImprintDate", this.getImprintDate());
        map.put("Author",this.author);
        return map;
        
    }
}
