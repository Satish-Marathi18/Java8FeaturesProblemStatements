package ProductSalesAnalysis;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;

public class ProductSalesAnalysis {
    public static List<Product> filterProduct(List<Product> products) {
        return products.stream().filter((product) -> product.getQuantity() > 10).toList();
    }

    public static List<ProductSales> transform(List<Product> products) {
        return products.stream().map(product -> new ProductSales(product.getProductId(),product.getQuantity()*product.getPrice())).toList();
    }

    public static List<ProductSales> sortProductOnTotalRevenue(List<ProductSales> productSales){
        return productSales.stream().sorted(Comparator.comparingDouble(ProductSales::getTotalRevenue).reversed()).toList();
    }

    public static List<ProductSales> topTotalRevenueProducts(List<ProductSales> productSales, int topN) {
        return productSales.stream().sorted((x,y) -> Double.compare(y.getTotalRevenue(),x.getTotalRevenue())).limit(topN).toList();
    }

    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product(101,5,3700.0));
        products.add(new Product(102,13,4500.0));
        products.add(new Product(103,18,9900.0));
        products.add(new Product(104,7,2100.0));

        List<Product> filteredProduct = filterProduct(products);
        for(Product product : filteredProduct) {
            System.out.println(product);
        }
        System.out.println();

        List<ProductSales> productSales = transform(products);
        for(ProductSales prod : productSales){
            System.out.println(prod);
        }
        System.out.println();

        List<ProductSales> sortedSales = sortProductOnTotalRevenue(productSales);
        for(ProductSales sortProduct : sortedSales) {
            System.out.println(sortProduct);
        }
        System.out.println();

        List<ProductSales> topProducts = topTotalRevenueProducts(productSales, 2);
        for(ProductSales product : topProducts) {
            System.out.println(product);
        }
    }
}
