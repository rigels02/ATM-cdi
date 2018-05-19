package org.rb.atm.cdi;

import java.math.BigDecimal;
import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import javax.inject.Inject;

/**
 *
 * @author raitis
 */
public class ATMCdi {

    
    
    public static void main(String[] args) {
        
        
        SeContainerInitializer initializer = SeContainerInitializer.newInstance();
        SeContainer cdicontainer = initializer.initialize();
        // TransactionStoreFactory.config("default");
        AutomatedTellerMachineImpl atm = cdicontainer.select(AutomatedTellerMachineImpl.class).get();
        
        //Configure Store type
       TransactionStoreFactory.config("default");
       //TransactionStoreFactory.config("type1");
        //default transport
        atm.withdraw(new BigDecimal("10.00"));
        atm.deposit(new BigDecimal("100.00"));
        
        //soap transport
        atm.setTransport(TransportType.Soap);
        atm.withdraw(new BigDecimal("10.00"));
        atm.deposit(new BigDecimal("100.00"));
        
        //json transport
        atm.setTransport(TransportType.Json);
        atm.withdraw(new BigDecimal("10.00"));
        atm.deposit(new BigDecimal("100.00"));
        //---//
        cdicontainer.close();
        //AutomatedTellerMachine atm = cdicontainer.;

       
    }

}
