import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.awt.event.ItemListener;

public class ProductorConsumidorController {
    private ProductorConsumidorModel model;
    private ProductorConsumidorView view;
    private Counter mainCounter, peCounter, pfCounter, ceCounter, cfCounter;

    public ProductorConsumidorController() {
        this.mainCounter = new Counter();
        this.peCounter = new Counter();
        this.pfCounter = new Counter();
        this.ceCounter = new Counter();
        this.cfCounter = new Counter();

        this.model = new ProductorConsumidorModel(mainCounter, peCounter, pfCounter, ceCounter, cfCounter);
        this.view = new ProductorConsumidorView(this);
    }

    public static void main(String[] args) {
        ProductorConsumidorController controller = new ProductorConsumidorController();

        Thread hilo = new Thread(controller.getView());
        hilo.start();
    }

    public void play() {
        this.mainCounter.setValor(0);

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

    public Counter getMainCounter() {
        return mainCounter;
    }

    public Counter getPeCounter() {
        return peCounter;
    }

    public Counter getPfCounter() {
        return pfCounter;
    }

    public Counter getCeCounter() {
        return ceCounter;
    }

    public Counter getCfCounter() {
        return cfCounter;
    }

}
