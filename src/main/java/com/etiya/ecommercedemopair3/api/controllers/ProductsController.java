package com.etiya.ecommercedemopair3.api.controllers;

import com.etiya.ecommercedemopair3.business.abstracts.ProductService;
import com.etiya.ecommercedemopair3.business.constants.Paths;
import com.etiya.ecommercedemopair3.business.dtos.requests.product.AddProductRequest;
import com.etiya.ecommercedemopair3.business.dtos.responses.product.AddProductResponse;
import com.etiya.ecommercedemopair3.entities.concrets.Product;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(Paths.apiPrefix+"products")
@AllArgsConstructor
public class ProductsController {
    //dependency incejtion
    ProductService productService;

    @GetMapping("/getAll")
    public List<Product> getAll(){
        return productService.getAll();
    }

    @GetMapping("{id}")
    public Product getById(@PathVariable int id){
        return productService.getById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<AddProductResponse> addProduct(@RequestBody @Valid AddProductRequest addProductRequest)
    {
        return  new ResponseEntity<AddProductResponse>(productService.addProduct(addProductRequest), HttpStatus.CREATED);
    }
}
