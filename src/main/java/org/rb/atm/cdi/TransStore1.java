package org.rb.atm.cdi;

import java.math.BigDecimal;

/**
 *
 * @author raitis
 */
@Store1
public class TransStore1 implements ITransactionStore{

    @Override
    public void keep(TransportType type, BigDecimal amount) {
        System.out.println("keep from TransStore1...");
    }
    
}
