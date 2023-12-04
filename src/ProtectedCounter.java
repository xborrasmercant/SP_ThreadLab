public class ProtectedCounter {
    private int value;

    public ProtectedCounter() {
        this.value = 0;
    }

    synchronized void inc_syncro() {
        value++;
    }

    synchronized void dec_syncro() {
        value--;
    }

    public void inc() {
        value++;
    }

    public void dec() {
        value--;
    }

    public int getValue() {
        return value;
    }
}
