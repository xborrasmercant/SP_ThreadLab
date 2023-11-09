import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.awt.event.ItemListener;

public class ProductorConsumidorController {
    private ProductorConsumidorModel model;
    private ProductorConsumidorView view;
    private Contador mainCounter, peCounter, pfCounter, ceCounter, cfCounter;
    
    public ProductorConsumidorController() {
        this.mainCounter = new Contador();
        this.peCounter = new Contador();
        this.pfCounter = new Contador();
        this.ceCounter = new Contador();
        this.cfCounter = new Contador();

        this.model = new ProductorConsumidorModel(mainCounter, peCounter, pfCounter, ceCounter, cfCounter);
        this.view = new ProductorConsumidorView(this);
    }

    public static void main(String[] args){
        ProductorConsumidorController controller = new ProductorConsumidorController();

        Thread hilo = new Thread(controller.getView());
        hilo.start();
    }

    public void play(){
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

    public Contador getContador() {
        return mainCounter;
    }

    public void setContador(Contador mainCounter) {
        this.mainCounter = mainCounter;
    }
}
