package com.etiya.ecommercedemopair3.business.abstracts;

import com.etiya.ecommercedemopair3.business.dtos.requests.cart.AddCartRequest;
import com.etiya.ecommercedemopair3.business.dtos.responses.cart.AddCartResponse;
import com.etiya.ecommercedemopair3.core.util.results.DataResult;

public interface CartService {
    DataResult<AddCartResponse> addCart(AddCartRequest addCartRequest);}