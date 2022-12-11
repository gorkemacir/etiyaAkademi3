package com.etiya.ecommercedemopair3.business.abstracts;

import com.etiya.ecommercedemopair3.business.dtos.requests.cart.AddCartRequest;
import com.etiya.ecommercedemopair3.business.dtos.responses.cart.AddCartResponse;

public interface CartService {
    AddCartResponse addCart(AddCartRequest addCartRequest);
}