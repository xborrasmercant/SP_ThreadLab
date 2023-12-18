public class Product {
    private int stockValue;

    public Product() {
        this.stockValue = 0;
    }

    public void produce() {
        this.stockValue++;
    }

    public void consume(boolean isStockNegative){
        if (isStockNegative) {
            this.stockValue--;
        }
        else {
            try {
                while (stockValue <= 0) {
                    System.out.println("Stock is empty.");
                    wait(); // Wait for producers to increase the stock
                }

                this.stockValue--;
                notifyAll();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    synchronized void produce_syncro() {
        this.stockValue++;
    }

    synchronized void consume_syncro(boolean isStockNegative) {
        if (isStockNegative) {
            this.stockValue--;
        }
        else {
            try {
                while (stockValue <= 0) {
                    System.out.println("Stock is empty.");
                    wait(); // Wait for producers to increase the stock
                }

                this.stockValue--;
                notifyAll();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public int getStockValue() {
        return stockValue;
    }

    public void setStockValue(int stockValue) {
        this.stockValue = stockValue;
    }
}
