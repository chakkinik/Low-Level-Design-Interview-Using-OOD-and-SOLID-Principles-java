package creationalpattern.factory;

public class PaymentApplication {

    /*
      FIVE WHY

      1) Why factory is used.
      -- When you need to create instances of classes that share a common interface or superclass but differ in implementation
      2) why we use only for common interface.
      --The factory will have to deal with very different types, potentially leading to methods that aren’t easily maintainable.
      3)


     */

    public static void main(String[] args) {
        PaymentService paymentService = PaymentFactory.getPaymentService("CREDIT_CARD");
        paymentService.processPayment(); // This will print "Processing credit card payment."

        paymentService = PaymentFactory.getPaymentService("WALLET");
        paymentService.processPayment(); // This will print "Processing PayPal payment."
    }
}
