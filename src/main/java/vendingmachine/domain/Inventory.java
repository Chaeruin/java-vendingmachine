package vendingmachine.domain;

public class Inventory {
    private final Product product;
    private int stock;

    public Inventory(Product product, int stock) {
        this.product = product;
        this.stock = stock;
    }

    public Product getProduct() {
        return this.product;
    }

    public int getStock() {
        return this.stock;
    }
}
