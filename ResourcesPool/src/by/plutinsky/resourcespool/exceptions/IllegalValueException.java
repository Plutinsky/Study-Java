/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.plutinsky.resourcespool.exceptions;
import org.apache.log4j.Logger;

/**
 *
 * @author HP
 */
public class IllegalValueException extends IllegalArgumentException{
    	private static Logger log = Logger
			.getLogger(IllegalValueException.class);
	public IllegalValueException() {
		log.error("Illegal variable value");
	}

    
}
