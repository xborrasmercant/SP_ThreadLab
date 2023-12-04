import java.util.Random;

public class Producer implements Runnable{
    private Product productStock;
    private Product peCounter;
    private Product pfCounter;
    private int producerTime;
    private int productionAmount;
    private boolean sync;

    public Producer(Product productStock, Product peProduct, Product pfProduct, int producerTime, int productionAmount, boolean sync) {
        this.productStock = productStock;
        this.peCounter = peProduct;
        this.pfCounter = pfProduct;
        this.producerTime = producerTime;
        this.productionAmount = productionAmount;
        this.sync = sync;
    }

    public void run() {
        if (sync) {
            peCounter.produce_syncro();

            for (int i = 0; i < productionAmount; i++) {
                productStock.produce_syncro();

                try {
                    Random rand = new Random();
                    int sleepTime = rand.nextInt(producerTime);
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            pfCounter.produce_syncro();
        }
        else {
            peCounter.produce();

            for (int i = 0; i < productionAmount; i++) {
                productStock.produce();

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
}