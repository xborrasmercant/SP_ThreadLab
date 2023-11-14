import java.util.Random;

public class Producer implements Runnable{
    private Product productCounter;
    private Product peCounter;
    private Product pfCounter;

    public Producer(Product productCounter, Product peProduct, Product pfProduct) {
        this.productCounter = productCounter;
        this.peCounter = peProduct;
        this.pfCounter = pfProduct;
    }

    public void run() {
        peCounter.produce();

        for (int i = 0; i < 100; i++){
            productCounter.produce();

            try {
                Random rand = new Random();
                int sleepTime = rand.nextInt(75);
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        pfCounter.produce();
    }
}