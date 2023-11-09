import java.lang.reflect.Array;
import java.util.ArrayList;

public class ProductorConsumidorModel{
    private Counter mainCounter;
    private Counter peCounter;
    private Counter pfCounter;
    private Counter ceCounter;
    private Counter cfCounter;

    public ProductorConsumidorModel(Counter mainCounter, Counter peCounter, Counter pfCounter, Counter ceCounter, Counter cfCounter) {
        this.mainCounter = mainCounter;
        this.peCounter = peCounter;
        this.pfCounter = pfCounter;
        this.ceCounter = ceCounter;
        this.cfCounter = cfCounter;
    }

    public void play(){
        ArrayList<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 200; i++){
            Productor productor = new Productor(mainCounter, peCounter, pfCounter);
            Thread hilo = new Thread(productor);
            hilo.start();
            threads.add(hilo);
        }

        for (int i = 0; i < 400; i++){
            Consumidor consumidor = new Consumidor(mainCounter, ceCounter, cfCounter);
            Thread hilo = new Thread(consumidor);
            hilo.start();
            threads.add(hilo);
        }

//        for (Thread hilo : threads) {
//            try {
//                hilo.join();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
    }
}
