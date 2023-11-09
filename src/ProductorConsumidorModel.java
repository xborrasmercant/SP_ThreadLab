import java.lang.reflect.Array;
import java.util.ArrayList;

public class ProductorConsumidorModel{
    Contador contador;

    public ProductorConsumidorModel(Contador contador) {
        this.contador = contador;
    }

    public void play(){
        ArrayList<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 200; i++){
            Productor productor = new Productor(this.contador);
            Thread hilo = new Thread(productor);
            hilo.start();
            threads.add(hilo);
        }

        for (int i = 0; i < 400; i++){
            Consumidor consumidor = new Consumidor(this.contador);
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

    public int getValor(){
        return this.contador.getValor();
    }
}
