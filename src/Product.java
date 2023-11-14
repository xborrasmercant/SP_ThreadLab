public class Product {
    private int stockValue;

    public Product() {
        this.stockValue = 0;
    }

    synchronized void produce() {
        this.stockValue++;
    }

    synchronized void consume() {
        this.stockValue--;
    }

    public int getStockValue() {
        return stockValue;
    }

    public void setStockValue(int stockValue) {
        this.stockValue = stockValue;
    }
}
