/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.plutinsky.textcomponent;
import by.plutinsky.typelexemes.TypeLexemes;

/**
 *
 * @author Alex
 */
public interface ITextComponent {
    public boolean print();
    public boolean addLexeme(ITextComponent lexeme);
    public boolean removeLexeme(ITextComponent lexeme);
    public TypeLexemes getTypeOfLexeme();
    
}
