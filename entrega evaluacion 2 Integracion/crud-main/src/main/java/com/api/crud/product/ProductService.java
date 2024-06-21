package com.api.crud.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Método para obtener todos los productos
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    // Método para registrar un nuevo producto
    public ResponseEntity<Object> createProduct(Product product) {
        HashMap<String, Object> datos = new HashMap<>();

        // Verificar si el producto ya existe por nombre
        Optional<Product> existingProduct = productRepository.findProductByName(product.getName());
        if (existingProduct.isPresent()) {
            datos.put("ERROR", true);
            datos.put("MESSAGE", "Este producto ya existe.");
            return new ResponseEntity<>(datos, HttpStatus.CONFLICT);
        }

        // Guardar el nuevo producto
        Product savedProduct = productRepository.save(product);

        // Preparar la respuesta
        datos.put("MESSAGE", "Producto creado.");
        datos.put("data", savedProduct);

        return new ResponseEntity<>(datos, HttpStatus.CREATED);
    }

    // Método para actualizar un producto existente
    public ResponseEntity<Object> updateProduct(Product product) {
        HashMap<String, Object> datos = new HashMap<>();

        // Verificar si el producto existe
        Optional<Product> existingProduct = productRepository.findById(product.getId());
        if (existingProduct.isEmpty()) {
            datos.put("ERROR", true);
            datos.put("MESSAGE", "Producto no encontrado para actualizar.");
            return new ResponseEntity<>(datos, HttpStatus.NOT_FOUND);
        }

        // Actualizar el producto
        Product updatedProduct = productRepository.save(product);

        // Preparar la respuesta
        datos.put("MESSAGE", "Producto actualizado.");
        datos.put("data", updatedProduct);

        return new ResponseEntity<>(datos, HttpStatus.OK);
    }

    // Método para eliminar un producto por su ID
    public ResponseEntity<Object> deleteProduct(Long id) {
        HashMap<String, Object> datos = new HashMap<>();

        // Verificar si el producto existe
        if (!productRepository.existsById(id)) {
            datos.put("ERROR", true);
            datos.put("MESSAGE", "El producto no existe.");
            return new ResponseEntity<>(datos, HttpStatus.NOT_FOUND);
        }

        // Eliminar el producto
        productRepository.deleteById(id);

        datos.put("MESSAGE", "Producto eliminado.");
        return new ResponseEntity<>(datos, HttpStatus.ACCEPTED);
    }
}
