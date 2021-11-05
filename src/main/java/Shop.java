import java.util.concurrent.atomic.LongAdder;

public class Shop extends Thread {
private final int BILLVALUEMULTiPLYER = 100;
private final int BILLTIMEMULTiPLYER = 50;

private LongAdder total;

    public Shop(LongAdder shopTotal) {
        this.total = shopTotal;
    }

    @Override
    public void run() {
        try {
            while (!interrupted()) {
                int bill = (int) (Math.random() * BILLVALUEMULTiPLYER);
                total.add(bill);
                Thread.sleep((long) (Math.random() * BILLTIMEMULTiPLYER));
            }
        } catch (InterruptedException e) {
        } finally {

            System.out.println("Магазин " + Thread.currentThread().getName() + " закрылся");

        }
    }
}


