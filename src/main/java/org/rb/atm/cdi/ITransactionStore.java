package org.rb.atm.cdi;

import java.math.BigDecimal;

/**
 *
 * @author raitis
 */
public interface ITransactionStore {

    void keep(TransportType type, BigDecimal amount);
}
