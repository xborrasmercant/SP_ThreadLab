import java.lang.reflect.Array;
import java.util.ArrayList;

public class LabModel{
    private Product productCounter;
    private Product peCounter;
    private Product pfCounter;
    private Product ceCounter;
    private Product cfCounter;

    public LabModel(Product productCounter, Product peCounter, Product pfCounter, Product ceCounter, Product cfCounter) {
        this.productCounter = productCounter;
        this.peCounter = peCounter;
        this.pfCounter = pfCounter;
        this.ceCounter = ceCounter;
        this.cfCounter = cfCounter;
    }

    public void play(){
        ArrayList<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 200; i++){
            Producer productor = new Producer(productCounter, peCounter, pfCounter);
            Thread hilo = new Thread(productor);
            hilo.start();
            threads.add(hilo);
        }

        for (int i = 0; i < 400; i++){
            Consumer consumidor = new Consumer(productCounter, ceCounter, cfCounter);
            Thread hilo = new Thread(consumidor);
            hilo.start();
            threads.add(hilo);
        }
    }
}
