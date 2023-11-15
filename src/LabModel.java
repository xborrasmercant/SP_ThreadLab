import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class LabModel{
    private Product productCounter, peCounter, pfCounter, ceCounter, cfCounter;
    private int producerAmount, consumerAmount, producerProductionAmount, consumerProductionAmount, producerTime, consumerTime;
    private long totalThreadsCreationTime, totalThreadsStartingTime, totalElapsedTime;

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
        this.producerProductionAmount = 100;
        this.consumerProductionAmount = 100;
    }

    public void play(){
        long threadCreationTime, threadStartingTime;

        totalElapsedTime = System.currentTimeMillis();
        for (int i = 0; i < producerAmount; i++){
            Producer producer = new Producer(productCounter, peCounter, pfCounter, producerTime, producerProductionAmount);

            // AGENT Creation
            threadCreationTime = System.nanoTime();
            Thread productionThread = new Thread(producer);
            threadCreationTime = System.nanoTime() - threadCreationTime;

            // THREAD Starting
            threadStartingTime = System.nanoTime();
            productionThread.start();
            threadStartingTime = System.nanoTime() - threadStartingTime;

            // Thread and Creation times added to the Total
            totalThreadsCreationTime = totalThreadsCreationTime + threadCreationTime;
            totalThreadsStartingTime = totalThreadsStartingTime + threadStartingTime;
        }

        for (int i = 0; i < consumerAmount; i++){
            Consumer consumer = new Consumer(productCounter, ceCounter, cfCounter, consumerTime, consumerProductionAmount);

            // AGENT Creation
            threadCreationTime = System.nanoTime();
            Thread consumerThread = new Thread(consumer);
            threadCreationTime = System.nanoTime() - threadCreationTime;

            // THREAD Starting
            threadStartingTime = System.nanoTime();
            consumerThread.start();
            threadStartingTime = System.nanoTime() - threadStartingTime;

            // Thread and Creation times added to the Total
            totalThreadsCreationTime = totalThreadsCreationTime + threadCreationTime;
            totalThreadsStartingTime = totalThreadsStartingTime + threadStartingTime;
        }

        totalElapsedTime = System.currentTimeMillis() - totalElapsedTime;
    }


    public int getProducerProductionAmount() {
        return producerProductionAmount;
    }

    public void setProducerProductionAmount(int producerProductionAmount) {
        this.producerProductionAmount = producerProductionAmount;
    }

    public int getConsumerProductionAmount() {
        return consumerProductionAmount;
    }

    public void setConsumerProductionAmount(int consumerProductionAmount) {
        this.consumerProductionAmount = consumerProductionAmount;
    }

    public long getTotalElapsedTime() {
        return totalElapsedTime;
    }

    public void setTotalElapsedTime(long totalElapsedTime) {
        this.totalElapsedTime = totalElapsedTime;
    }

    public long getTotalThreadsCreationTime() {
        return totalThreadsCreationTime;
    }

    public void setTotalThreadsCreationTime(long totalThreadsCreationTime) {
        this.totalThreadsCreationTime = totalThreadsCreationTime;
    }

    public long getTotalThreadsStartingTime() {
        return totalThreadsStartingTime;
    }

    public void setTotalThreadsStartingTime(long totalThreadsStartingTime) {
        this.totalThreadsStartingTime = totalThreadsStartingTime;
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
