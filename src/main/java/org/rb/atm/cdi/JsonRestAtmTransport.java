package org.rb.atm.cdi;

import javax.enterprise.inject.Alternative;
import static org.rb.atm.cdi.Utils.print;



/**
 *
 * @author raitis
 */
@Json
public class JsonRestAtmTransport implements IATMTransport{

  
    @Override
    public void communicateWithBank(byte[] datapacket) {
        System.out.println("communicating with bank via JSON REST transport");
        print(datapacket);
    }

    @Override
    public TransportType getTransportType() {
        return TransportType.Json;
    }
    
}
