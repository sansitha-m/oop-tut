package uk.ac.westminster.products_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id){
        return productService.getProductById(id).orElse(null);
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable Long id){
        productService.deleteProductById(id);
    }

    @GetMapping("/search")
    public List<Product> search(@RequestParam String name){
        return productService.findProductByName(name);
    }
}
