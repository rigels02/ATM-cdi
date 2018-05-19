package org.rb.atm.cdi.hadlers;

import javax.enterprise.event.Event;
import javax.inject.Inject;

/**
 *
 * @author raitis
 */
@Notify
public class Notifier implements INotifier{

    @Inject @NotifyEvent Event<String> event_notify;
    
    @Override
    public void send(String message) {
      event_notify.fire(message);
    }
    
}
