package org.rb.atm.cdi.hadlers;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.event.Observes;

/**
 *
 * @author raitis
 */
//@RequestScoped
public class NotifyReporter {
    
    public void notifyHander(@Observes @NotifyEvent String msg){
        System.out.println("notifyHandler received: "+msg);
    }
    
 @PostConstruct
 private void postConstr(){
     System.out.println("NotifyReporter.postConstr() ...");
 }
 @PreDestroy
 private void preDestroy(){
     System.out.println("NotifyReporter.preDestroy()...");
 }
}
