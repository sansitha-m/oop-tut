package uk.ac.westminster.products_api;

import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private List<Product> products = new ArrayList<>();
    private Long nextId = 1L;

    public ProductService() {
        Product dp1 = new DigitalProduct(nextId++,"ebooks",150.5,"ebooks.com",10.5);
        products.add(dp1);
        Product pp1 = new PhysicalProduct(nextId++,"pens",50.50,0.05,"10x10");
        products.add(pp1);
    }

    public List<Product> getAllProducts(){
        return products;
    }

    public Optional<Product> getProductById(Long id){
        return products.stream().filter(p -> p.getId().equals(id)).findFirst();
        /*for(Product product : products){
            if (products.getId.equals(id)){

            }
        }*/
    }

    public Product addProduct(Product product){
        product.setId(nextId++);
        products.add(product);
        return product;
    }
    public void deleteProductById(Long id){
        products.removeIf(p -> p.getId().equals(id));
    }

    public List<Product>  findProductByName(String name){
        return products.stream().
                filter(p -> p.getName().contains(name)).toList();
    }

    public DigitalProduct newProduct(DigitalProduct newProduct){
        newProduct.setId(nextId++);
        products.add(newProduct);
        return newProduct;
    }

}
