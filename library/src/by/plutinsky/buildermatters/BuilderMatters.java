/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.plutinsky.buildermatters;

import by.plutinsky.exception.IOParserException;
import by.plutinsky.exception.ParserException;
import java.util.ArrayList;
import by.plutinsky.matter.AbstractPrintedMatter;

/**
 *
 * @author Alex
 */
public abstract class BuilderMatters {
    protected ArrayList<AbstractPrintedMatter> matters = new ArrayList<AbstractPrintedMatter>();

    public ArrayList<AbstractPrintedMatter> getMatters() {
        return matters;
    }
    
    public abstract void build() throws ParserException, IOParserException;
    
    
}
