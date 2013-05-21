/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.plutinsky.exception;

import java.io.IOException;
import org.apache.log4j.Logger;

/**
 *
 * @author Alex
 */
public class IOParserException extends IOException{
    private static final Logger LOG = Logger
			.getLogger(IOParserException.class);

    public IOParserException(Throwable cause) {
        LOG.error("ошибка I/О потока", cause);
    }
    
}
