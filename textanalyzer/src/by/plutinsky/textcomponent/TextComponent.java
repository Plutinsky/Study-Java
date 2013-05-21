/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.plutinsky.textcomponent;
import by.plutinsky.typelexemes.TypeLexemes;
import java.util.ArrayList;
/**
 *
 * @author Alex
 */
public class TextComponent implements ITextComponent{
    private TypeLexemes typeLexeme;
    private ArrayList<ITextComponent> listChilds;

    public TextComponent(TypeLexemes type) {
        //super();
        this.typeLexeme = type;
	this.listChilds = new ArrayList<ITextComponent>();
    }

    @Override
    public TypeLexemes getTypeOfLexeme() {
        return typeLexeme;
    }

    public ArrayList<ITextComponent> getListOfChilds() {
        return listChilds;
    }

    public void setListOfChilds(ArrayList<ITextComponent> listOfChilds) {
        this.listChilds = listOfChilds;
	}

    @Override
    public boolean print() {
        return false;
    }
    
    @Override
    public boolean addLexeme(ITextComponent lexeme) {
        if (lexeme == null) {
            return false;
        }
        listChilds.add(lexeme);
        return false;
    }

    @Override
    public boolean removeLexeme(ITextComponent lexeme) {
        if (lexeme == null) {
            return false;
        } else {
            boolean answer = listChilds.remove(lexeme);
            return answer;
        }
    }    
}
