package week1.codes;

interface PaymentProcessor {
    void processPayment(double amount);
}

class PayPalGateway {
    public void makePayment(double amount) {
        System.out.println("Payment of Rs." + amount + " processed using PayPal.");
    }
}

class StripeGateway {
    public void pay(double amount) {
        System.out.println("Payment of Rs." + amount + " processed using Stripe.");
    }
}

class RazorpayGateway {
    public void completeTransaction(double amount) {
        System.out.println("Payment of Rs." + amount + " processed using Razorpay.");
    }
}

class PayPalAdapter implements PaymentProcessor {
    private PayPalGateway paypal;

    public PayPalAdapter(PayPalGateway paypal) {
        this.paypal = paypal;
    }

    public void processPayment(double amount) {
        paypal.makePayment(amount);
    }
}

class StripeAdapter implements PaymentProcessor {
    private StripeGateway stripe;

    public StripeAdapter(StripeGateway stripe) {
        this.stripe = stripe;
    }

    public void processPayment(double amount) {
        stripe.pay(amount);
    }
}

class RazorpayAdapter implements PaymentProcessor {
    private RazorpayGateway razorpay;

    public RazorpayAdapter(RazorpayGateway razorpay) {
        this.razorpay = razorpay;
    }

    public void processPayment(double amount) {
        razorpay.completeTransaction(amount);
    }
}

public class AdapterPatternExample {
    public static void main(String[] args) {
        PaymentProcessor paypal = new PayPalAdapter(new PayPalGateway());
        PaymentProcessor stripe = new StripeAdapter(new StripeGateway());
        PaymentProcessor razorpay = new RazorpayAdapter(new RazorpayGateway());

        paypal.processPayment(1000);
        stripe.processPayment(2500);
        razorpay.processPayment(5000);
    }
}