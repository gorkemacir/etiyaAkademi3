package com.etiya.ecommercedemopair3.business.concrets;

import com.etiya.ecommercedemopair3.business.abstracts.ProductService;
import com.etiya.ecommercedemopair3.business.dtos.requests.product.AddProductRequest;
import com.etiya.ecommercedemopair3.business.dtos.responses.product.AddProductResponse;
import com.etiya.ecommercedemopair3.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair3.entities.concrets.Product;
import com.etiya.ecommercedemopair3.repository.abstracts.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductManager implements ProductService {
    private ProductRepository productRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product getById(int id) {
        return productRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Product> getAllByStockGreaterThan(int stock) {
        return productRepository.findAllProductsByStockGreaterThanOrderByStockDesc(stock);
    }

    @Override
    public Product getByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public AddProductResponse addProduct(AddProductRequest addProductRequest) {
//        Product product = new Product();
//        product.setName(addProductRequest.getName());
//        product.setStock(addProductRequest.getStock());
//        product.setUnit_price(addProductRequest.getUnit_price());
        Product product=modelMapperService.getMapperRequest().map(addProductRequest,Product.class);
        Product savedProduct = productRepository.save(product);
        AddProductResponse response=modelMapperService.getMapperResponse().map(savedProduct,AddProductResponse.class);
        // AddProductResponse response = new AddProductResponse(savedProduct.getId(), savedProduct.getName(), savedProduct.getUnit_price(), savedProduct.getStock());
        return response;
    }

}
