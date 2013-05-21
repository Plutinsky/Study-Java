/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.plutinsky.actiononthetext;

import by.plutinsky.textcomponent.ITextComponent;
import by.plutinsky.textcomponent.TextComponent;
import by.plutinsky.typelexemes.TypeLexemes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Alex
 */
public class SortSentance {
    private TextComponent text;
    private ArrayList<TextComponent> sentances;
    
    public SortSentance(TextComponent text){
        this.text = text;
        sentances = new ArrayList<TextComponent>();
    }
    
//    public void sort() {
//        Collections.sort(sentances, new Comparator() {
//            @Override
//            public int compare(Object o1, Object o2) {
//                
//            }
//        });
 //   }
    

    
    private void findAllSentances(){
        for(ITextComponent tmpComp: text.getListOfChilds()){
            if(TypeLexemes.PARAGRAPH.equals(tmpComp.getTypeOfLexeme())){
                //buildParagraph((TextComponent) tmpComp);
                findSentance((TextComponent) tmpComp);
            }
        }  
    }
    
    private void findSentance(TextComponent paragraph){
        for(ITextComponent tmpComp: paragraph.getListOfChilds()){
            if(TypeLexemes.SENTENCE.equals(tmpComp.getTypeOfLexeme())){
                sentances.add((TextComponent) tmpComp);
                //Collections.sort(sentances, );
            }
        }
    }
    
    private int numberWordsInSentance(TextComponent sentance){
       int i = 0;
       for(ITextComponent tmpComp: sentance.getListOfChilds()){
            if(TypeLexemes.WORD.equals(tmpComp.getTypeOfLexeme())){
                i++;
            }
        } 
       return i;
    }
    
    public void sort(){
        findAllSentances();
        Collections.sort(sentances, new Comparator<TextComponent>(){

            @Override
            public int compare(TextComponent o1, TextComponent o2) {
                return numberWordsInSentance(o1)-numberWordsInSentance(o2);
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
           
        });
    }
    
    public TextComponent getSortedText(){
        TextComponent outputText = new TextComponent(TypeLexemes.TEXT);
        TextComponent outputParagraph = new TextComponent(TypeLexemes.PARAGRAPH);
        outputText.addLexeme(outputParagraph);
        for(TextComponent tempLexeme: sentances){
            outputParagraph.addLexeme(tempLexeme);
        }
        return outputText;
    }
    
}
