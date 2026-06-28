package week1.codes;
import java.util.ArrayList;

interface Stock {
    void registerObserver(Observer observer);
    void deregisterObserver(Observer observer);
    void notifyObservers();
}

interface Observer {
    void update(double price);
}

class StockMarket implements Stock {
    private ArrayList<Observer> observers = new ArrayList<>();
    private double stockPrice;

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void deregisterObserver(Observer observer) {
        observers.remove(observer);
    }

    public void setStockPrice(double price) {
        stockPrice = price;
        notifyObservers();
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(stockPrice);
        }
    }
}

class MobileApp implements Observer {
    public void update(double price) {
        System.out.println("Mobile App: Stock price updated to Rs." + price);
    }
}

class WebApp implements Observer {
    public void update(double price) {
        System.out.println("Web App: Stock price updated to Rs." + price);
    }
}

public class ObserverPatternExample {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();

        Observer mobile = new MobileApp();
        Observer web = new WebApp();

        stockMarket.registerObserver(mobile);
        stockMarket.registerObserver(web);

        stockMarket.setStockPrice(1500);

        System.out.println();

        stockMarket.deregisterObserver(web);

        stockMarket.setStockPrice(1700);
    }
}