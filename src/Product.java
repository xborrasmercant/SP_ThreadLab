public class Product {
    private int valor;

    public Product() {
        this.valor = 0;
    }

    synchronized void produce() {
        this.valor++;
    }

    synchronized void consume() {
        this.valor--;
    }

    public int getValor() {
        return this.valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}
