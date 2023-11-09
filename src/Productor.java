import java.util.Random;

public class Productor implements Runnable{

    private Counter mainCounter;
    private Counter peCounter;
    private Counter pfCounter;

    public Productor(Counter mainCounter, Counter peCounter, Counter pfCounter) {
        this.mainCounter = mainCounter;
        this.peCounter = peCounter;
        this.pfCounter = pfCounter;
    }

    public void run() {
        peCounter.inc();

        for (int i = 0; i < 100; i++){
            mainCounter.inc();

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