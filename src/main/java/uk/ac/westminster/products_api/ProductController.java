package uk.ac.westminster.products_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/all-products")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
        // id, name, price come from Product (parent class). Included in json response
        // by Spring boot's Jackson serializer using inherited getters.
    }

    @GetMapping("/from/{id}")
    public Product getProduct(@PathVariable Long id){
        return productService.getProductById(id).orElse(null);
    }

    @PostMapping("/add")
    public Product addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProductById(@PathVariable Long id){
        productService.deleteProductById(id);
    }

    @GetMapping("/search")
    public List<Product> search(@RequestParam String name){
        return productService.findProductByName(name);
    }

    @PostMapping("/new-digital")
    public Product newProduct(@RequestBody DigitalProduct newProduct){
        return productService.newProduct(newProduct);
    }
}
