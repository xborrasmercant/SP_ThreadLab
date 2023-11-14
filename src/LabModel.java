import java.lang.reflect.Array;
import java.util.ArrayList;

public class LabModel{
    private Product productCounter, peCounter, pfCounter, ceCounter, cfCounter;
    private int producerAmount, consumerAmount, producerTime, consumerTime;
    private long agentElapsedTime, threadElapsedTime;

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
        long threadStartTime = 0, threadEndTime = 0, agentNotCreatedTime = 0, agentCreatedTime = 0;

        for (int i = 0; i < producerAmount; i++){

            Producer producer = new Producer(productCounter, peCounter, pfCounter, producerTime);

            // AGENT Creation
            agentNotCreatedTime = System.nanoTime();
            Thread productionThread = new Thread(producer);
            agentCreatedTime = System.nanoTime();

            // THREAD Starting
            threadStartTime = System.nanoTime();
            productionThread.start();
            threadEndTime = System.nanoTime();

            agentElapsedTime = agentElapsedTime + (agentCreatedTime - agentNotCreatedTime);
            threadElapsedTime = threadElapsedTime + (threadEndTime - threadStartTime);
        }

        for (int i = 0; i < consumerAmount; i++){
            Consumer consumer = new Consumer(productCounter, ceCounter, cfCounter, consumerTime);

            // AGENT Creation
            agentNotCreatedTime = System.nanoTime();
            Thread consumerThread = new Thread(consumer);
            agentCreatedTime = System.nanoTime();

            // THREAD Starting
            threadStartTime = System.nanoTime();
            consumerThread.start();
            threadEndTime = System.nanoTime();

            agentElapsedTime = agentElapsedTime + (agentCreatedTime - agentNotCreatedTime);
            threadElapsedTime = threadElapsedTime + (threadEndTime - threadStartTime);
        }

        System.out.println("Agent Total Time: " + agentElapsedTime + " ns");
        System.out.println("Thread Total Time: " + threadElapsedTime + " ns");

        System.out.println("Agent Average Time: " + agentElapsedTime / (producerAmount + consumerAmount) + " ns");
        System.out.println("Thread Average Time: " + threadElapsedTime / (producerAmount + consumerAmount) + " ns");
    }

    public long getAgentElapsedTime() {
        return agentElapsedTime;
    }

    public void setAgentElapsedTime(long agentElapsedTime) {
        this.agentElapsedTime = agentElapsedTime;
    }

    public long getThreadElapsedTime() {
        return threadElapsedTime;
    }

    public void setThreadElapsedTime(long threadElapsedTime) {
        this.threadElapsedTime = threadElapsedTime;
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
