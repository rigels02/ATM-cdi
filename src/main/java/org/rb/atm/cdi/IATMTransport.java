package org.rb.atm.cdi;

/**
 *
 * @author raitis
 */
public interface IATMTransport {
    
    void communicateWithBank(byte[] datapacket);
    TransportType getTransportType();
}
