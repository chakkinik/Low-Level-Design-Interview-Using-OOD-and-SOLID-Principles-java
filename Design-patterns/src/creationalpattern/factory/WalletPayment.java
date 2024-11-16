package creationalpattern.factory;

public class WalletPayment implements PaymentService{
    @Override
    public void processPayment() {
        System.out.println("use any wallet to do payment");
    }
}
