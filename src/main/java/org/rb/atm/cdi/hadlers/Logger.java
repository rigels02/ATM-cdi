package org.rb.atm.cdi.hadlers;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author raitis
 */
@Named
public class Logger implements ILogger{

    @Inject @LoggerEvent Event<String> log_event;
    
    @Override
    public void log(String message) {
        log_event.fire(message);
    }
    
}
