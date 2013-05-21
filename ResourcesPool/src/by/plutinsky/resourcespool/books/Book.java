/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.plutinsky.resourcespool.books;

import by.plutinsky.resourcespool.bookgenre.BookGenre;

/**
 *
 * @author HP
 */
public class Book {
    private int id;
    private String name;
    private String author;
    private int numberOfPages;
    private BookGenre genre;

    public Book(int id, String name, String author, int numberOfPages, BookGenre genre) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.numberOfPages = numberOfPages;
        this.genre = genre;
    }
    
    public String getDescr(){
        return new String("ID: "+id+" Name: "+name+ " Author: "+
                author+ " NumberOfPages "+ numberOfPages+ " Genre "+genre);
    }    
    
    
}
