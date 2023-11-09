import java.util.Random;

public class Productor implements Runnable{

    private Contador contador;

    public Productor(Contador contador) {
        this.contador = contador;
    }

    public void run() {
        for (int i = 0; i < 100; i++){
            this.contador.inc();
            try {
                Random rand = new Random();
                int sleepTime = rand.nextInt(75);
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
