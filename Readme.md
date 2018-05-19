# JavaSE application with CDI example (Weld-SE)

This is just CDI use case example application.
For CDI support the Weld SE is used:

~~~~
<dependency>
    <groupId>org.jboss.weld.se</groupId>
    <artifactId>weld-se-core</artifactId>
    <version>3.0.1.Final</version>
</dependency>
~~~~

To use CDI to manage the dependencies, do the following:

   - Create an empty bean.xml file under META-INF resource folder src\main\resources\META-INF\beans.xml
   - Use the @Inject annotation in AutomatedTellerMachineImpl to inject IATMTransport types. The CDI uses
        qualifiers to separate different transport types: @Soap, @Json, Standard by default.
   - Use the @Default annotation to annotate the StandardAtmTransport
   - Use the qualifiers @Soap, @Json to annotate the SoapAtmTransport, and JsonRestAtmTransport.
   - Use the @Named annotation to make the AutomatedTellerMachineImpl easy to look up; 
        give it the name "atm"
   - Use the CDI beanContainer (Weld-SE) to look up the atm, makes some deposits and withdraws 
     via different transports and transaction store. The transport is selected by setTransport() method.

## Use of different transactions stores 

There are two ITransactionStore implementations, for example, TransStore1, TransStore2.  
They are annotated with qualifiers @Store1, @Store2 respectively 
to make those distinguish for CDI container. 
As configuration bean TransactionStoreFactory is used to setup necessary
Transaction store during application
initialization by TransactionStoreFactory.config("default").
The TransactionStoreFactory use @Produces annotated method createTransStore()
to produce for injection TransStore instance depending on the field 
named type. The type can be configured in application by config() method.
Interesting, the createTransStore() method do not create TransStore instances itself, but
receives those as qualified parameters from container.


