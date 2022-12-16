package com.etiya.ecommercedemopair3.business.concrets;

import com.etiya.ecommercedemopair3.business.abstracts.ProductService;
import com.etiya.ecommercedemopair3.business.constants.Messages;
import com.etiya.ecommercedemopair3.business.dtos.requests.product.AddProductRequest;
import com.etiya.ecommercedemopair3.business.dtos.responses.product.AddProductResponse;
import com.etiya.ecommercedemopair3.business.dtos.responses.product.GetProductResponse;
import com.etiya.ecommercedemopair3.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair3.core.util.results.DataResult;
import com.etiya.ecommercedemopair3.core.util.results.SuccessDataResult;
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
    public DataResult<List<Product>> getAll() {
        List<Product> response =productRepository.findAll();
        return new SuccessDataResult<List<Product>>(response, Messages.Product.productAddSuccesMessage);
    }

    @Override
    public DataResult<Product> getById(int id) {
        Product response = productRepository.findById(id).orElseThrow();
        return new SuccessDataResult<Product>(response,Messages.Product.productGetByIdSuccesMessage) ;
    }

    @Override
    public DataResult<List<Product>> getAllByStockGreaterThan(int stock) {
        List<Product> response =productRepository.findAllProductsByStockGreaterThanOrderByStockDesc(stock);
        return new SuccessDataResult<List<Product>>(response,Messages.Product.productAllByStockGreaterThanSuccesMessage) ;
    }

    @Override
    public DataResult<Product> getByName(String name) {
        Product response = productRepository.findByName(name);
        return new SuccessDataResult<Product>(response, Messages.Product.productGetByNameSuccesMessage) ;
    }

    @Override
    public DataResult<AddProductResponse> addProduct(AddProductRequest addProductRequest) {
//        Product product = new Product();
//        product.setName(addProductRequest.getName());
//        product.setStock(addProductRequest.getStock());
//        product.setUnit_price(addProductRequest.getUnit_price());
        Product product = modelMapperService.getMapperRequest().map(addProductRequest, Product.class);
        Product savedProduct = productRepository.save(product);
//        AddProductResponse response = new AddProductResponse(savedProduct.getId(), savedProduct.getName(), savedProduct.getUnit_price(), savedProduct.getStock());
        AddProductResponse response=modelMapperService.getMapperResponse().map(savedProduct,AddProductResponse.class);
        return new SuccessDataResult<AddProductResponse>(response,Messages.Product.productAddSuccesMessage);
    }

    @Override
    public DataResult<List<GetProductResponse>> getProductsByCategoryId(int identity) {
        List<GetProductResponse> response = productRepository.getProductByCategoryId(identity);
        return new SuccessDataResult<List<GetProductResponse>>(response, "Kategori id getirildi");
    }

}
