package org.rb.atm.cdi;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 * @author raitis
 */
public class Utils {

   private Utils(){}
   
   public static void print(byte[] datapacket){
        BigInteger bi = new BigInteger(datapacket);
        BigDecimal bd = new BigDecimal(bi,2);
        System.out.println("BigDEcimal=> "+bd.toString());
    
    }
}
