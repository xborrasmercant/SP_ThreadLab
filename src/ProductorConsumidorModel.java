import java.lang.reflect.Array;
import java.util.ArrayList;

public class ProductorConsumidorModel{
    private Contador mainCounter;
    private Contador peCounter;
    private Contador pfCounter;
    private Contador ceCounter;
    private Contador cfCounter;

    public ProductorConsumidorModel(Contador mainCounter, Contador peCounter, Contador pfCounter, Contador ceCounter, Contador cfCounter) {
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
