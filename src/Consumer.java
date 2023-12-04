import java.util.Random;

public class Consumer implements Runnable{
    private Product productStock;
    private Product ceCounter;
    private Product cfCounter;
    private int consumerTime;
    private int productionAmount;
    private boolean sync;


    public Consumer(Product productStock, Product ceCounter, Product cfCounter, int consumerTime, int productionAmount, boolean sync) {
        this.productStock = productStock;
        this.ceCounter = ceCounter;
        this.cfCounter = cfCounter;
        this.consumerTime = consumerTime;
        this.productionAmount = productionAmount;
        this.sync = sync;
    }

    public void run() {
        if (sync) {
            ceCounter.produce_syncro();

            for (int i = 0; i < productionAmount; i++){
                productStock.consume_syncro();
                try {
                    Random rand = new Random();
                    int sleepTime = rand.nextInt(consumerTime);
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            cfCounter.produce_syncro();
        }
        else {
            ceCounter.produce_syncro();

            for (int i = 0; i < productionAmount; i++){
                this.productStock.consume();
                try {
                    Random rand = new Random();
                    int sleepTime = rand.nextInt(consumerTime);
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            cfCounter.produce();
        }
    }
}
