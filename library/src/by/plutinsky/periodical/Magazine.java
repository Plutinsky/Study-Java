/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.plutinsky.periodical;

import java.util.HashMap;

/**
 *
 * @author Alex
 */
public class Magazine extends AbstractPeriodical{

    public Magazine(String number, int periodicity, String redactor, String id, String imprintDate, String publishingHouse, int numberPage, String title) {
        super(number, periodicity, redactor, id, imprintDate, publishingHouse, numberPage, title);
    } 

    public Magazine() {
    }
    
    
    
    @Override
    public HashMap<String, String> getInfo() {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("Id", this.getId());
        map.put("PublishingHouse",this.getPublishingHouse());
        map.put("Title", this.getTitle());
        map.put("NumberPage", String.valueOf(this.getNumberPage()));
        map.put("ImprintDate", this.getImprintDate());
        map.put("Number",this.getNumber());
        map.put("Periodicity",String.valueOf(this.getPeriodicity()));
        map.put("Redactor",this.getRedactor());
        return map;
        
    }
    
}
