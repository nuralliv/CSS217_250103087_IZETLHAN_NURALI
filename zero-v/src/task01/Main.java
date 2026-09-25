package task01;

import   java.math.BigDecimal;

public class Main {
    public static void main(String[] args )  {
        PaymentGatewayAdapter gateway  = new PaymentGatewayAdapter ( new LegacyBillingSystem() ) ;
        gateway.processPayment( 1, new BigDecimal("10.50" ) ) ;

        try {
            gateway.processPayment( 2 , new  BigDecimal("-5.00" )) ;
        } catch ( IllegalArgumentException  e ) {
            System.out.println("Correctly rejectedd negative : " + e.getMessage() );
        }
    }
}
