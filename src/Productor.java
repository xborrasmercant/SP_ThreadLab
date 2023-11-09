import java.util.Random;

public class Productor implements Runnable{

    private Contador counter;
    private Contador peCounter;
    private Contador pfCounter;

    public Productor(Contador counter, Contador peCounter, Contador pfCounter) {
        this.counter = counter;
        this.peCounter = peCounter;
        this.pfCounter = pfCounter;
    }

    public void run() {
        peCounter.inc();

        for (int i = 0; i < 100; i++){
            counter.inc();

            try {
                Random rand = new Random();
                int sleepTime = rand.nextInt(75);
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        pfCounter.inc();
    }
}
