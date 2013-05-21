/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.plutinsky.exception;

import java.lang.Exception;
import org.apache.log4j.Logger;




/**
 *
 * @author Alex
 */
public class ParserException extends Exception{
    private static final Logger LOG = Logger
			.getLogger(ParserException.class);

    public ParserException(Exception e) {
        LOG.error("ошибка  парсера", e);
    }
}
