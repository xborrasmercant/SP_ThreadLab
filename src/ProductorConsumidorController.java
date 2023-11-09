import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.awt.event.ItemListener;

public class ProductorConsumidorController {
    private ProductorConsumidorModel model;

    private ProductorConsumidorView view;

    private Contador contador;

    public ProductorConsumidorController() {
        this.contador = new Contador();
        this.model = new ProductorConsumidorModel(contador);
        this.view = new ProductorConsumidorView(this);
    }

    public static void main(String[] args){
        ProductorConsumidorController controller = new ProductorConsumidorController();

        Thread hilo = new Thread(controller.getView());
        hilo.start();
    }

    public void play(){
        this.contador.setValor(0);

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
        return contador;
    }

    public void setContador(Contador contador) {
        this.contador = contador;
    }
}
