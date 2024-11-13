package ProductSalesAnalysis;
class Product {
    int productId;
    int quantity;
    double price;
    public Product(int productId, int quantity, double price) {
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }
    
    public int getProductId() {
        return productId;
    }
    public int getQuantity() {
        return quantity;
    }
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product [productId=" + productId + ", quantity=" + quantity + ", price=" + price + "]";
    }

    
}