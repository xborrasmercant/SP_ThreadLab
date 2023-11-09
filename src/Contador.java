public class Contador {
    private int valor;

    public Contador() {
        this.valor = 0;
    }

    public void inc() {
        this.valor++;
    }

    public void desc() {
        this.valor--;
    }

    public int getValor() {
        return this.valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}
