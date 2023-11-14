import java.util.Random;

public class Producer implements Runnable{
    private Product productCounter;
    private Product peCounter;
    private Product pfCounter;
    private int producerTime;

    public Producer(Product productCounter, Product peProduct, Product pfProduct, int producerTime) {
        this.productCounter = productCounter;
        this.peCounter = peProduct;
        this.pfCounter = pfProduct;
        this.producerTime = producerTime;
    }

    public void run() {
        peCounter.produce();

        for (int i = 0; i < 100; i++){
            productCounter.produce();

            try {
                Random rand = new Random();
                int sleepTime = rand.nextInt(producerTime);
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        pfCounter.produce();
    }
}