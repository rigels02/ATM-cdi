package org.rb.atm.cdi.hadlers;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.event.Observes;

/**
 *
 * @author raitis
 */
public class LogReporter {

@PostConstruct
private void postConstruct(){
    System.out.println("LogReporter.postConstruct()...");
}
 
@PreDestroy
private void preDestroy(){
    System.out.println("LogReporter.preDestroy()...");
}

public void LogEventHandler(@Observes @LoggerEvent String message){
    System.out.println("LogReporter.LogEventHandler() received: "+message);
}    
}
