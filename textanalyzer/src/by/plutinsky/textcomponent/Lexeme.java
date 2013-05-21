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
public class Lexeme implements ITextComponent{
    private String lexValue;
    private TypeLexemes typeLexeme;

    public Lexeme(TypeLexemes type) {
        this.typeLexeme = type;
	}

    @Override
    public TypeLexemes getTypeOfLexeme() {
        return typeLexeme;
    }
    
    @Override
    public boolean print() {
        return false;
    }

    @Override
    public boolean addLexeme(ITextComponent lexeme) {
        return false;
    }

    @Override
    public boolean removeLexeme(ITextComponent lexeme) {
        return false;
    }

    public String getLexemeValue() {
        return this.lexValue;
    }

    public boolean setLexemeValue(String lexemeValue) {
        if (lexemeValue.isEmpty()) {
            return false;
        }
        this.lexValue = lexemeValue;
        return true;
	}
}
