import java.util.Random;

public class Consumidor implements Runnable{
    private Contador counter;
    private Contador ceCounter;
    private Contador cfCounter;

    public Consumidor(Contador counter, Contador ceCounter, Contador cfCounter) {
        this.counter = counter;
        this.ceCounter = ceCounter;
        this.cfCounter = cfCounter;
    }

    public void run() {
        ceCounter.inc();

        for (int i = 0; i < 100; i++){
            this.counter.desc();
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
