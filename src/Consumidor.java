import java.util.Random;

public class Consumidor implements Runnable{
    private Contador contador;

    public Consumidor(Contador contador) {
        this.contador = contador;
    }

    public void run() {
        for (int i = 0; i < 100; i++){
            this.contador.desc();
            try {
                Random rand = new Random();
                int sleepTime = rand.nextInt(100);
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
