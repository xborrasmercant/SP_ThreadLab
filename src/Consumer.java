import java.util.Random;

public class Consumer implements Runnable{
    private Product productCounter;
    private Product ceCounter;
    private Product cfCounter;

    public Consumer(Product productCounter, Product ceCounter, Product cfCounter) {
        this.productCounter = productCounter;
        this.ceCounter = ceCounter;
        this.cfCounter = cfCounter;
    }

    public void run() {
        ceCounter.produce();

        for (int i = 0; i < 100; i++){
            this.productCounter.consume();
            try {
                Random rand = new Random();
                int sleepTime = rand.nextInt(100);
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        cfCounter.produce();
    }
}
