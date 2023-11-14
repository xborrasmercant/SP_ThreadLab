
public class LabController {
    private LabModel model;
    private LabView view;
    private Product productCounter, peCounter, pfCounter, ceCounter, cfCounter;

    public LabController() {
        this.productCounter = new Product();
        this.peCounter = new Product();
        this.pfCounter = new Product();
        this.ceCounter = new Product();
        this.cfCounter = new Product();

        this.model = new LabModel(productCounter, peCounter, pfCounter, ceCounter, cfCounter);
        this.view = new LabView(this);
    }

    public static void main(String[] args) {
        LabController controller = new LabController();

        Thread hilo = new Thread(controller.getView());
        hilo.start();
    }

    public void play() {
        resetCounters();
        model.play();
    }

    public void resetCounters() {
        productCounter.setValor(0);
        peCounter.setValor(0);
        ceCounter.setValor(0);
        pfCounter.setValor(0);
        cfCounter.setValor(0);
        model.setAgentElapsedTime(0);
        model.setThreadElapsedTime(0);
    }


    public LabModel getModel() {
        return model;
    }

    public void setModel(LabModel model) {
        this.model = model;
    }

    public LabView getView() {
        return view;
    }

    public void setView(LabView view) {
        this.view = view;
    }

    public void setProductCounter(Product productCounter) {
        this.productCounter = productCounter;
    }

    public Product getProductCounter() {
        return productCounter;
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
}
