/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.plutinsky.periodical;

import by.plutinsky.matter.AbstractPrintedMatter;

/**
 *
 * @author Alex
 */
public abstract class AbstractPeriodical extends AbstractPrintedMatter{
    private String number;
    private int periodicity;
    private String redactor;

    public AbstractPeriodical(String number, int periodicity, String redactor, String id, 
            String imprintDate, String publishingHouse, int numberPage, String title) {
        super(id, imprintDate, publishingHouse, numberPage, title);
        this.number = number;
        this.periodicity = periodicity;
        this.redactor = redactor;
    }
    
    

    public AbstractPeriodical() {
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setPeriodicity(int periodicity) {
        this.periodicity = periodicity;
    }

    public void setRedactor(String redactor) {
        this.redactor = redactor;
    }
    
    public String getNumber(){
        return this.number;
    }
    
    public int getPeriodicity(){
        return this.periodicity;
    }
    
    public String getRedactor(){
        return this.redactor;
    }  
    
}
