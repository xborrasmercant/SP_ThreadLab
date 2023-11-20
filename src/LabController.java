
public class LabController {
    private LabModel model;
    private LabView view;
    private Product productStock, peCounter, pfCounter, ceCounter, cfCounter;

    public LabController() {
        this.productStock = new Product();
        this.peCounter = new Product();
        this.pfCounter = new Product();
        this.ceCounter = new Product();
        this.cfCounter = new Product();

        this.model = new LabModel(productStock, peCounter, pfCounter, ceCounter, cfCounter);
        this.view = new LabView(this);
    }

    public static void main(String[] args) {
        LabController controller = new LabController();

        Thread hilo = new Thread(controller.getView());
        hilo.start();
    }

    public void play() {
        model.play();
    }

    public void resetCounters() {
        productStock.setStockValue(0);
        peCounter.setStockValue(0);
        ceCounter.setStockValue(0);
        pfCounter.setStockValue(0);
        cfCounter.setStockValue(0);
        model.setTotalThreadsCreationTime(0);
        model.setTotalThreadsStartingTime(0);
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

    public Product getProductStock() {
        return productStock;
    }

    public void setProductStock(Product productStock) {
        this.productStock = productStock;
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
