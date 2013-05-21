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
public abstract class AbstractPrintedMatter {
    private String id;
    private String imprintDate;
    private String publishingHouse;
    private int numberPage;
    private String title;

    public AbstractPrintedMatter(String id, String imprintDate, String publishingHouse, int numberPage, String title) {
        this.id = id;
        this.imprintDate = imprintDate;
        this.publishingHouse = publishingHouse;
        this.numberPage = numberPage;
        this.title = title;
    }

    public AbstractPrintedMatter() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public abstract HashMap<String , String> getInfo(); 
    
    public String getImprintDate(){
        return this.imprintDate;
    }
    
    public String getPublishingHouse(){
        return this.publishingHouse;
    }
    
    public int getNumberPage(){
        return this.numberPage;
    }
    
    public String getTitle(){
        return this.title;
    }

    public void setImprintDate(String imprintDate) {
        this.imprintDate = imprintDate;
    }

    public void setNumberPage(int numberPage) {
        this.numberPage = numberPage;
    }

    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    
    
}
