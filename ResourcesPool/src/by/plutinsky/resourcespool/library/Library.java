/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.plutinsky.resourcespool.library;

import by.plutinsky.resourcespool.books.Book;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;
import org.apache.log4j.Logger;

/**
 *
 * @author HP
 */
public class Library {
    private static Logger log = Logger.getLogger(Library.class);
    private ArrayList<Book> books;
    private final static ReentrantLock LOCK = new ReentrantLock();
    private Semaphore semaphore;
    private static Library instance;

    private Library(ArrayList<Book> books, int amountBooks) {
        this.books = books;
        this.semaphore = new Semaphore(amountBooks);
    }
    
    public static Library getIstance(ArrayList<Book> books, int amountBooks){
        LOCK.lock();
        if(instance == null){
            instance = new Library(books, amountBooks);
        }
        LOCK.unlock();
        return instance;
    }
    
    public Book getBook(){
        try{
            semaphore.acquire();
        } catch(InterruptedException e){
            log.error("Problems with library semafore");
        }
        Book book = books.remove(0);
        return book;
        
    }
    
    public void returnBook(Book book){
        books.add(book);
        semaphore.release();
    }
    
    
    
}
