import java.lang.reflect.Array;
import java.util.ArrayList;

public class LabModel{
    private Product productCounter, peCounter, pfCounter, ceCounter, cfCounter;
    private int producerAmount, consumerAmount, producerTime, consumerTime;

    public LabModel(Product productCounter, Product peCounter, Product pfCounter, Product ceCounter, Product cfCounter) {
        this.productCounter = productCounter;
        this.peCounter = peCounter;
        this.pfCounter = pfCounter;
        this.ceCounter = ceCounter;
        this.cfCounter = cfCounter;
        this.producerAmount = 100;
        this.consumerAmount = 100;
        this.producerTime = 50;
        this.consumerTime = 50;
    }

    public void play(){

        for (int i = 0; i < producerAmount; i++){
            Producer producer = new Producer(productCounter, peCounter, pfCounter, producerTime);
            Thread productionThread = new Thread(producer);
            productionThread.start();
        }

        for (int i = 0; i < consumerAmount; i++){
            Consumer consumer = new Consumer(productCounter, ceCounter, cfCounter, consumerTime);
            Thread consumerThread = new Thread(consumer);
            consumerThread.start();
        }
    }

    public Product getProductCounter() {
        return productCounter;
    }

    public void setProductCounter(Product productCounter) {
        this.productCounter = productCounter;
    }

    public Product getPeCounter() {
        return peCounter;
    }

    public void setPeCounter(Product peCounter) {
        this.peCounter = peCounter;
    }

    public Product getPfCounter() {
        return pfCounter;
    }

    public void setPfCounter(Product pfCounter) {
        this.pfCounter = pfCounter;
    }

    public Product getCeCounter() {
        return ceCounter;
    }

    public void setCeCounter(Product ceCounter) {
        this.ceCounter = ceCounter;
    }

    public Product getCfCounter() {
        return cfCounter;
    }

    public void setCfCounter(Product cfCounter) {
        this.cfCounter = cfCounter;
    }

    public int getProducerAmount() {
        return producerAmount;
    }

    public void setProducerAmount(int producerAmount) {
        this.producerAmount = producerAmount;
    }

    public int getConsumerAmount() {
        return consumerAmount;
    }

    public void setConsumerAmount(int consumerAmount) {
        this.consumerAmount = consumerAmount;
    }

    public int getProducerTime() {
        return producerTime;
    }

    public void setProducerTime(int producerTime) {
        this.producerTime = producerTime;
    }

    public int getConsumerTime() {
        return consumerTime;
    }

    public void setConsumerTime(int consumerTime) {
        this.consumerTime = consumerTime;
    }
}
