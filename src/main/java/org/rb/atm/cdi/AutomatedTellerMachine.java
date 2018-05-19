package org.rb.atm.cdi;

import java.math.BigDecimal;

/**
 *
 * @author raitis
 */
public interface AutomatedTellerMachine {
    
    void deposit(BigDecimal bd);

    void withdraw(BigDecimal bd);
    
}
