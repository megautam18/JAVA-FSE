package week1.codes;
interface PaymentStrategy {
    void pay(double amount);
}

class CreditCardPayment implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Paid Rs." + amount + " using Credit Card.");
    }
}

class PayPalPayment implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Paid Rs." + amount + " using PayPal.");
    }
}

class PaymentContext {
    private PaymentStrategy strategy;

    public PaymentContext(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void executePayment(double amount) {
        strategy.pay(amount);
    }
}

public class StrategyPatternExample {
    public static void main(String[] args) {
        PaymentContext payment = new PaymentContext(new CreditCardPayment());

        payment.executePayment(1000);

        payment.setStrategy(new PayPalPayment());

        payment.executePayment(2500);
    }
}