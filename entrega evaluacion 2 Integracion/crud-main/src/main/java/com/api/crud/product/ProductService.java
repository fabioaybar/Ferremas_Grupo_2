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

    HashMap<String,Object>datos;

    private final ProductRepository productRepository;
    @Autowired
    public ProductService(ProductRepository productRepository){this.productRepository=productRepository;}

    public List<Product> getProduct(){




        return this.productRepository. findAll();



    }

    public ResponseEntity<Object> newProduct(Product product) {
        Optional<Product> res = productRepository.findProductByName(product.getName());
        datos=new HashMap<>();



        if(res.isPresent() && product.getId()==null){
            datos.put("ERROR",true);
            datos.put("MESSAGE","ESTE PRODUCTO YA EXISTE ");


            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CONFLICT
            );
        }
        datos.put("MESSAGE","ACTUALIZADO ");
        if (product.getId()!=null){
            datos.put("MESSAGE","ACTUALIZADO ");
        }
        productRepository.save(product);
        datos.put("data",product);
        datos.put("MESSAGE","SE GUARDO");
        return new ResponseEntity<>(
                datos,
                HttpStatus.CREATED
        );


    }
    public ResponseEntity<Object>DeleteProduct(Long id){
        datos=new HashMap<>();

      boolean existe=  this.productRepository.existsById(id);
      if(!existe){
          datos.put("ERROR",true);
          datos.put("MESSAGE","ESTE PRODUCTO NO EXISTTE");


          return new ResponseEntity<>(
                  datos,
                  HttpStatus.CONFLICT
          );

      }
        productRepository.deleteById(id);

        datos.put("data ","producto eliminado");



        return new ResponseEntity<>(
                datos,
                HttpStatus.ACCEPTED
        );


    }
}
