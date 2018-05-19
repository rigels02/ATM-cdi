package org.rb.atm.cdi;


import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import org.rb.atm.cdi.hadlers.ILogger;
import org.rb.atm.cdi.hadlers.INotifier;
import org.rb.atm.cdi.hadlers.Notify;

/**
 *
 * @author raitis
 */
@Named("atm")
public class AutomatedTellerMachineImpl implements AutomatedTellerMachine {

    @Inject ITransactionStore transStore;
    
    @Inject IATMTransport standart;
    @Inject @Soap IATMTransport soapTrans;
    @Inject @Json IATMTransport jsonTrans;
    
    @Inject @Notify INotifier notifier;
    @Inject ILogger logger;
    
    private IATMTransport transport;

    @PostConstruct
    private void defaultTransport(){
        transport = standart;
    }
    
    public void setTransport(TransportType type) {
        switch(type){
        case Json:
            transport= jsonTrans;
            break;
        case Soap:
            transport= soapTrans;
            break;    
        default:
            transport = standart;
        }
    }

    
    @Override
    public void deposit(BigDecimal bd) {
        System.out.println("deposit called");
        transStore.keep(transport.getTransportType(), bd);
        BigInteger usv = bd.unscaledValue();
        byte[] barr = usv.toByteArray();
        notifier.send(
                String.format("deposit, transport:%s, amount:%s",transport.getTransportType(),bd )
        );
        logger.log(
                String.format("deposit, transport:%s, amount:%s",transport.getTransportType(),bd )
        );
        transport.communicateWithBank(barr);
    }

    @Override
    public void withdraw(BigDecimal bd) {
        System.out.println("withdraw called");
         transStore.keep(transport.getTransportType(), bd);
        BigInteger usv = bd.unscaledValue();
        byte[] barr = usv.toByteArray();
        notifier.send(
                String.format("withdraw, transport:%s, amount:%s",transport.getTransportType(),bd )
        );
        logger.log(
                String.format("withdraw, transport:%s, amount:%s",transport.getTransportType(),bd )
        );
        transport.communicateWithBank(barr);
    }

}
