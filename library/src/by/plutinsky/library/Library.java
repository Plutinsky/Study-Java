/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.plutinsky.library;

import by.plutinsky.buildermatters.BuilderMatters;
import by.plutinsky.matter.AbstractPrintedMatter;
import java.util.ArrayList;
import org.apache.log4j.Logger;

/**
 *
 * @author Alex
 */
public class Library {
    
    private static Logger log = Logger.getLogger(Library.class);
    private ArrayList<AbstractPrintedMatter> abstractPrintedMatters;
    

    public void setAbstractPrintedMatters(ArrayList<AbstractPrintedMatter> abstractPrintedMatters) {
        this.abstractPrintedMatters = abstractPrintedMatters;
    }

    public Library() {
        abstractPrintedMatters = new ArrayList<AbstractPrintedMatter>();
        //PropertyConfigurator.configure("src/properties/log4j.properties");
    }
    
    public void addPrintedMatter(AbstractPrintedMatter printedMatter){
        this.abstractPrintedMatters.add(printedMatter);
    }
    
    public void showAllBooks(){
        for(AbstractPrintedMatter abstractPrintedMatter: abstractPrintedMatters){
            log.info(abstractPrintedMatter.getClass().getName());
            log.info(abstractPrintedMatter.getInfo());
            //System.out.println(abstractPrintedMatter.getClass().getName());
            //System.out.println(abstractPrintedMatter.getInfo());
        }
    }
    
    public int numberOfPages(){
        int pages = 0;
        for(AbstractPrintedMatter abstractPrintedMatter: abstractPrintedMatters){
            pages+=abstractPrintedMatter.getNumberPage();
        }
        return pages;
    }
    
    public ArrayList<AbstractPrintedMatter> buildMatters(BuilderMatters builder){
        try{
            builder.build();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return builder.getMatters();
        
    }
    
    
    

    /**
     * @param args the command line arguments
     */
//    public static void main(String[] args) {
//        // TODO code application logic here
//          Library library = new Library();
//          //(new SAXBuilder()).build();
//          library.setAbstractPrintedMatters(buildMatters(new SAXBuilder()));
//          
//          
//          
//          
////        
////        AbstractPrintedMatter newspaper1 = new Newspaper(77, 3, "vasya", 1991, "New-York Times", 10, "sport Times", 3);
////        library.addPrintedMatter(newspaper1);
////        
////        AbstractPrintedMatter magazine1 = new Magazine(11, 10, "alex", 1944, "piter", 100, "house");
////        library.addPrintedMatter(magazine1);
////        
////        AbstractPrintedMatter book1 = new Book("john", 1999, "moskva", 543, "math");
////        library.addPrintedMatter(book1);
////        
//        library.showAllBooks();
//        log.info("sum pages = " + library.numberOfPages());
//        
//        //System.out.println("sum pages = " + library.numberOfPages());
//        
//    }
}
