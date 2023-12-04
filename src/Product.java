public class Product {
    private int stockValue;

    public Product() {
        this.stockValue = 0;
    }

    public void produce() {
        this.stockValue++;
    }

    public void consume() {
        this.stockValue--;
    }

    synchronized void produce_syncro() {
        this.stockValue++;
    }

    synchronized void consume_syncro() {
        this.stockValue--;
    }

    public int getStockValue() {
        return stockValue;
    }

    public void setStockValue(int stockValue) {
        this.stockValue = stockValue;
    }
}
