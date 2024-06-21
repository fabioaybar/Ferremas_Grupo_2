package com.api.crud.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/Product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getProducts(){
        return productService.getProducts();
    }

    @PostMapping
    public ResponseEntity<Object> registrarProducto(@RequestBody Product product){
        return productService.createProduct(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> actualizarProducto(@PathVariable Long id, @RequestBody Product product){
        return productService.updateProduct(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminar(@PathVariable Long id){
        return productService.deleteProduct(id);
    }
}
