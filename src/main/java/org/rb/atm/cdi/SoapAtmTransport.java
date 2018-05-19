package org.rb.atm.cdi;

import javax.enterprise.inject.Alternative;
import static org.rb.atm.cdi.Utils.print;

/**
 *
 * @author raitis
 */
@Soap
public class SoapAtmTransport implements IATMTransport{

    
    @Override
    public void communicateWithBank(byte[] datapacket) {
    System.out.println("communicating with bank via Soap transport");
        print(datapacket);
    }

    @Override
    public TransportType getTransportType() {
        return TransportType.Soap;
    }
    
}
