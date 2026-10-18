package uk.ac.westminster.products_api;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.spi.ToolProvider.findFirst;

@Service
public class ProductService {

    private static List<Product> products = new ArrayList<>();
    private long nextId = 1L;

    public List<Product> getAllProducts() {
        return products;
    }

    public Product addProducts(Product product){
        product.setId(nextId++);
        product.add(product);
        return product;
    }

    public static Optional<Product> getProductById(Long id) {
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

    public Product addProduct(Product product) {
        return product;
    }

    public void deleteProduct(Long id) {
        products.removeIf(p -> p.getId().equals(id));
    }

    public List<Product> findByName(String name){
        return products.stream()
                .filter(p -> p.getName().contains(name))
                .toList();
    }
}