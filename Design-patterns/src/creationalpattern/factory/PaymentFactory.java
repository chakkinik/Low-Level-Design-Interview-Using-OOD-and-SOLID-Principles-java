package creationalpattern.factory;

public class PaymentFactory {
    public static PaymentService getPaymentService(String type) {
        if ("CREDIT_CARD".equalsIgnoreCase(type)) {
            return new CreditPayement();
        } else if ("WALLET".equalsIgnoreCase(type)) {
            return new WalletPayment();
        }
        throw new IllegalArgumentException("Unknown payment service type.");
    }
}
