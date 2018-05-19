package org.rb.atm.cdi;

import java.math.BigDecimal;

/**
 *
 * @author raitis
 */
@Store2
public class TransStore2 implements ITransactionStore{

    @Override
    public void keep(TransportType type, BigDecimal amount) {
        System.out.printf("keep from TransStore2: type= %s, amount= %s \n",type,amount );  
    }
    
}
