
public class ProductorConsumidorController {
    private ProductorConsumidorModel model;
    private ProductorConsumidorView view;
    private Product productCounter, peCounter, pfCounter, ceCounter, cfCounter;

    public ProductorConsumidorController() {
        this.productCounter = new Product();
        this.peCounter = new Product();
        this.pfCounter = new Product();
        this.ceCounter = new Product();
        this.cfCounter = new Product();

        this.model = new ProductorConsumidorModel(productCounter, peCounter, pfCounter, ceCounter, cfCounter);
        this.view = new ProductorConsumidorView(this);
    }

    public static void main(String[] args) {
        ProductorConsumidorController controller = new ProductorConsumidorController();

        Thread hilo = new Thread(controller.getView());
        hilo.start();
    }

    public void play() {
        this.productCounter.setValor(0);
        this.model.play();
    }

    public ProductorConsumidorModel getModel() {
        return model;
    }

    public void setModel(ProductorConsumidorModel model) {
        this.model = model;
    }

    public ProductorConsumidorView getView() {
        return view;
    }

    public void setView(ProductorConsumidorView view) {
        this.view = view;
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
