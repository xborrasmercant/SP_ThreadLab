public class Counter {
    private int valor;

    public Counter() {
        this.valor = 0;
    }

    synchronized void inc() {
        this.valor++;
    }

    synchronized void desc() {
        this.valor--;
    }

    public int getValor() {
        return this.valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}
