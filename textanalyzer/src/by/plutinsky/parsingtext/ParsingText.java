/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.plutinsky.parsingtext;

import by.plutinsky.textcomponent.ITextComponent;
import by.plutinsky.textcomponent.TextComponent;
import by.plutinsky.textcomponent.Lexeme;
import by.plutinsky.typelexemes.TypeLexemes;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.log4j.Logger;
import by.plutinsky.getlogmessage.GetLogMessage;
import java.util.LinkedList;

/**
 *
 * @author Alex
 */
public class ParsingText {
    private TextComponent text;
    private final static Pattern listingExp = Pattern.compile("(###([^@][@]{0,2})*@[\\n\\s])");
    private final static Pattern paragraphExp = Pattern.compile("(.+[\\r\\n])");
    private final static Pattern sentencesExp = Pattern.compile("(?sx-m)[^\\r\\n].*?(?:(?:\\.|\\?|!)\\s)");
    private final static Pattern wordAndPunctuationExp = Pattern.compile("([А-Яа-я\\w]*\\.?[А-Яа-я\\w]+\\s?)|([\\.?!,]\\s)");
    private final static Pattern wordExp = Pattern.compile("([А-Яа-я\\w]*\\.?[А-Яа-я\\w]+\\s?)");
    private final static Pattern punctuationExp = Pattern.compile("([,.!?])[\\s\\n]");
    private static final Logger log = Logger.getLogger(ParsingText.class);
    private GetLogMessage logMessage = new GetLogMessage();
    
    public TextComponent getText() {
        return text;
    }
    
    public boolean parseText(String fullText) {
        text = new TextComponent(TypeLexemes.TEXT);
        String[] textWithoutListings = listingExp.split(fullText);
        Matcher listingMatcher = listingExp.matcher(fullText);
        for(String paragraphs: textWithoutListings){
            Matcher paragraphMatcher = paragraphExp.matcher(paragraphs);
            while(paragraphMatcher.find()){
                log.info(logMessage.getLogParagraph());
                log.info(paragraphMatcher.group());
                TextComponent paragraph = parseParagraph(paragraphMatcher.group());
                text.addLexeme(paragraph);
            }
            if(listingMatcher.find()){
                TextComponent listing = new TextComponent(TypeLexemes.LISTING);
                Lexeme lexeme = new Lexeme(TypeLexemes.LEXEME);
                lexeme.setLexemeValue(listingMatcher.group());
                listing.addLexeme(lexeme);
                text.addLexeme(listing);
                log.info(logMessage.getLogListing());
                log.info("\n"+listingMatcher.group());
            }

        }       
        return true;
    }
//    public boolean parseText(String fullText){
//        text = new TextComponent(TypeLexemes.TEXT);

//        return true;
//    }

    private TextComponent parseParagraph(String paragraphStr) {
        TextComponent paragraph = new TextComponent(TypeLexemes.PARAGRAPH);
        Matcher sentencesMatcher = sentencesExp.matcher(paragraphStr);
        while(sentencesMatcher.find()){
            log.info(logMessage.getLogSentance());
            log.info(sentencesMatcher.group());
            TextComponent sentance = parseSentance(sentencesMatcher.group());
            paragraph.addLexeme(sentance);
        }
        return paragraph;
    }
 
    private TextComponent parseSentance(String sentanceStr) {
        TextComponent sentance = new TextComponent(TypeLexemes.SENTENCE);
        Matcher wordAndPunctuationMatcher = wordAndPunctuationExp.matcher(sentanceStr);
        while(wordAndPunctuationMatcher.find()){
            Matcher wordMatcher = wordExp.matcher(wordAndPunctuationMatcher.group());
            while(wordMatcher.find()){
                TextComponent word = new TextComponent(TypeLexemes.WORD);
                Lexeme lexeme = new Lexeme(TypeLexemes.LEXEME);
                lexeme.setLexemeValue(wordMatcher.group());
                word.addLexeme(lexeme);
                sentance.addLexeme(word);
                log.info(logMessage.getLogWord());
                log.info(wordMatcher.group());
            }
            Matcher punctuationMatcher = punctuationExp.matcher(wordAndPunctuationMatcher.group());
            while(punctuationMatcher.find()){
                TextComponent punctuation = new TextComponent(TypeLexemes.PUNCTUATION);
                Lexeme lexeme = new Lexeme(TypeLexemes.LEXEME);
                lexeme.setLexemeValue(punctuationMatcher.group());
                punctuation.addLexeme(lexeme);
                sentance.addLexeme(punctuation);
                log.info(logMessage.getLogPunctuation());
                log.info(punctuationMatcher.group());
            }
        }
        return sentance;
    }
}
