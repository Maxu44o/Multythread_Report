import java.util.concurrent.atomic.LongAdder;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        final int WORKINGTIME = 3000;

        LongAdder totalProfit = new LongAdder();

        ThreadGroup shops = new ThreadGroup("Shops");

        new Thread(shops, new Shop(totalProfit), "На Ленина").start();
        new Thread(shops, new Shop(totalProfit), "На Мира").start();
        new Thread(shops, new Shop(totalProfit), "На Фрунзе").start();

        Thread.sleep(WORKINGTIME);

        shops.interrupt();
        System.out.println("Выручка по всем магазинам составила: " + totalProfit.sum() + " $");


    }
}
