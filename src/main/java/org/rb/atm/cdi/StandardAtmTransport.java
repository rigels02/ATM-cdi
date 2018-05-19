package org.rb.atm.cdi;

import javax.enterprise.inject.Default;
import static org.rb.atm.cdi.Utils.print;

/**
 *
 * @author raitis
 */
@Default
public class StandardAtmTransport implements IATMTransport{

    
    
    @Override
    public void communicateWithBank(byte[] datapacket) {
         System.out.println("communicating with bank via Standard transport");
         print(datapacket);
    }

    @Override
    public TransportType getTransportType() {
        return TransportType.Standard;
    }
    
}
