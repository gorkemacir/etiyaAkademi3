package com.etiya.ecommercedemopair3.business.abstracts;

import com.etiya.ecommercedemopair3.business.dtos.requests.productCategory.AddProductCategoryRequest;
import com.etiya.ecommercedemopair3.business.dtos.responses.productCategory.AddProductCategoryResponse;

public interface ProductCategoryService {
    AddProductCategoryResponse addProductCategory(AddProductCategoryRequest addProductCategoryRequest);
}
