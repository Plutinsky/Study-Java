/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.plutinsky.actiononthetext;
import by.plutinsky.textcomponent.TextComponent;
import by.plutinsky.textcomponent.ITextComponent;
import by.plutinsky.textcomponent.Lexeme;
import by.plutinsky.typelexemes.TypeLexemes;
import java.util.ArrayList;

/**
 *
 * @author Alex
 */
public class BuildText {
    private TextComponent text;
    private ArrayList<String> textList;
    
    public ArrayList<String> getTextList(){
        return this.textList;
    }
    
    public BuildText(TextComponent text){
        this.text = text;
        this.textList = new ArrayList<String>();
    }
    
    public String getText(){
        String text="";
        for(String tempLexeme: textList){
            text+=tempLexeme;
        }
        return text;
    }
    
    public void buildText(){
        for(ITextComponent tmpComp: text.getListOfChilds()){
            if(TypeLexemes.PARAGRAPH.equals(tmpComp.getTypeOfLexeme())){
                buildParagraph((TextComponent) tmpComp);
            }
            if(TypeLexemes.LISTING.equals(tmpComp.getTypeOfLexeme())){
                buildListing((TextComponent) tmpComp);
            }
        }        
    }
    
    public void buildParagraph(TextComponent paragraph){
        for(ITextComponent tmpComp: paragraph.getListOfChilds()){
            if(TypeLexemes.SENTENCE.equals(tmpComp.getTypeOfLexeme())){
                buildSentence((TextComponent) tmpComp);
            }
        }
    }
    
    public void buildSentence(TextComponent sentence){
        for(ITextComponent tmpComp: sentence.getListOfChilds()){
            if(TypeLexemes.WORD.equals(tmpComp.getTypeOfLexeme())){
                buildWord((TextComponent)tmpComp);
            }
            if(TypeLexemes.PUNCTUATION.equals(tmpComp.getTypeOfLexeme())){
                buildPunctuation((TextComponent)tmpComp);
            }
        }
        
    }
    
    public void buildPunctuation(TextComponent punctuation){
        for(ITextComponent tmpComp: punctuation.getListOfChilds()){
            if(TypeLexemes.LEXEME.equals(tmpComp.getTypeOfLexeme())){
                Lexeme lexeme = (Lexeme) tmpComp;
                textList.add(lexeme.getLexemeValue());
            }
        }
    }
    
    public void buildWord(TextComponent word){
        for(ITextComponent tmpComp: word.getListOfChilds()){
            if(TypeLexemes.LEXEME.equals(tmpComp.getTypeOfLexeme())){
                Lexeme lexeme = (Lexeme) tmpComp;
                textList.add(lexeme.getLexemeValue());
            }
        }
    }
    
    public void buildListing(TextComponent listing){
        for(ITextComponent tmpComp: listing.getListOfChilds()){
            if(TypeLexemes.LEXEME.equals(tmpComp.getTypeOfLexeme())){
                Lexeme lexeme = (Lexeme) tmpComp;
                textList.add(lexeme.getLexemeValue());
            }
        }
    }
}
