import java.lang.reflect.Array;
import java.util.ArrayList;

public class ProductorConsumidorModel{
    private Product productCounter;
    private Product peCounter;
    private Product pfCounter;
    private Product ceCounter;
    private Product cfCounter;

    public ProductorConsumidorModel(Product productCounter, Product peCounter, Product pfCounter, Product ceCounter, Product cfCounter) {
        this.productCounter = productCounter;
        this.peCounter = peCounter;
        this.pfCounter = pfCounter;
        this.ceCounter = ceCounter;
        this.cfCounter = cfCounter;
    }

    public void play(){
        ArrayList<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 200; i++){
            Productor productor = new Productor(productCounter, peCounter, pfCounter);
            Thread hilo = new Thread(productor);
            hilo.start();
            threads.add(hilo);
        }

        for (int i = 0; i < 400; i++){
            Consumidor consumidor = new Consumidor(productCounter, ceCounter, cfCounter);
            Thread hilo = new Thread(consumidor);
            hilo.start();
            threads.add(hilo);
        }
    }
}
