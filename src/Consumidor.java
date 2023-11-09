import java.util.Random;

public class Consumidor implements Runnable{
    private Counter mainCounter;
    private Counter ceCounter;
    private Counter cfCounter;

    public Consumidor(Counter mainCounter, Counter ceCounter, Counter cfCounter) {
        this.mainCounter = mainCounter;
        this.ceCounter = ceCounter;
        this.cfCounter = cfCounter;
    }

    public void run() {
        ceCounter.inc();

        for (int i = 0; i < 100; i++){
            this.mainCounter.desc();
            try {
                Random rand = new Random();
                int sleepTime = rand.nextInt(100);
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        cfCounter.inc();
    }
}
