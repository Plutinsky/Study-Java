/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.plutinsky.resourcespool.readers;

import by.plutinsky.resourcespool.books.Book;
import by.plutinsky.resourcespool.library.Library;
import org.apache.log4j.Logger;
import java.util.Random;

/**
 *
 * @author HP
 */
public class Readers extends Thread{
    private static Logger log = Logger.getLogger(Readers.class);
    private int id;
    private Library library;

    public Readers(int id, Library library) {
        this.id = id;
        this.library = library;
    }
    
    public void takeBook(Book book){
        log.info("reader with id: " + id + " reading book: "+ book.getDescr());
    }
    
    public void returnBook(Book book){
        log.info("reader with id: " + id + " have finished reading: "+ book.getDescr());
        library.returnBook(book);
    }

    @Override
    public void run() {
        try{
            Random randomInt = new Random();
            Book book = library.getBook();
            takeBook(book);
            Thread.sleep(1000 + randomInt.nextInt(1500));
            
            returnBook(book);
        }catch(InterruptedException e){
            log.error("Problems with reader thread");
        }
    }

    
    
}
