package dao;

import model.Product;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Laptop", 50000));
        products.add(new Product(2, "Phone", 20000));
        products.add(new Product(3, "Book", 500));
        return products;
    }
}
