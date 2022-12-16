package com.etiya.ecommercedemopair3.api.controllers;

import com.etiya.ecommercedemopair3.business.abstracts.CartService;
import com.etiya.ecommercedemopair3.business.constants.Paths;
import com.etiya.ecommercedemopair3.business.dtos.requests.cart.AddCartRequest;
import com.etiya.ecommercedemopair3.business.dtos.responses.cart.AddCartResponse;

import com.etiya.ecommercedemopair3.core.util.results.DataResult;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Paths.apiPrefix + "carts")
@AllArgsConstructor
public class CartsController {
    private CartService cartService;

    @PostMapping("/add")
    public ResponseEntity<DataResult<AddCartResponse>> addCart(@RequestBody AddCartRequest addCartRequest)
    {
        return new ResponseEntity<>(cartService.addCart(addCartRequest), HttpStatus.CREATED);
    }
}
