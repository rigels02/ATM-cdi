package org.rb.atm.cdi;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

/**
 *
 * @author raitis
 */
public class TransactionStoreFactory {

    public static void config(String type) {
       TransactionStoreFactory.type = type;
    }

    private static String type="type1";

    
    @Produces @ApplicationScoped
    ITransactionStore createTransStore(
            @Store1 ITransactionStore store1,
            @Store2 ITransactionStore store2){
        System.out.println("createTransStore() from Producer...");
        switch(type){
            case "type1":
            case "type2":
                return store2;
            default:
                return store1;
                        
        }
    }
}
