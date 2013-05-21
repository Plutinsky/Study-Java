/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.plutinsky.resourcespool.poolcreator;

import by.plutinsky.resourcespool.bookgenre.BookGenre;
import by.plutinsky.resourcespool.books.Book;
import by.plutinsky.resourcespool.library.Library;
import by.plutinsky.resourcespool.readers.Readers;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class PoolCreator {
    private ArrayList<Readers> readers;
    private Library library;

    public PoolCreator(int amountBooks, int amountReaders){
        library = Library.getIstance(this.createBooks(amountBooks), amountBooks);
        readers = new ArrayList<Readers>();
        this.createReaders(amountReaders);
    }
    
    
    private ArrayList<Book> createBooks(int amountBooks){
        ArrayList<Book> books = new ArrayList<Book>();
        for(int i = 0; i <= amountBooks; i++){
            Book book = new Book(i, "kniga", "author", 123, BookGenre.DRAMA);
            books.add(book);
        }
        return books;
    }
    
    private void createReaders(int amountReaders){
        for(int i= 0; i <= amountReaders; i++){
            Readers client = new Readers(i,library);
            readers.add(client);
        }
    }
    
    public void start(){
        for(Readers reader : readers){
            reader.start();
        }
    }
    
}
