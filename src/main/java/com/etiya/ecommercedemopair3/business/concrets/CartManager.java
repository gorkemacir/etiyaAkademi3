package com.etiya.ecommercedemopair3.business.concrets;

import com.etiya.ecommercedemopair3.business.abstracts.CartService;
import com.etiya.ecommercedemopair3.business.dtos.requests.cart.AddCartRequest;
import com.etiya.ecommercedemopair3.business.dtos.responses.cart.AddCartResponse;
import com.etiya.ecommercedemopair3.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair3.entities.concrets.Cart;
import com.etiya.ecommercedemopair3.repository.abstracts.CartRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CartManager implements CartService {
    private CartRepository cartRepository;
    private ModelMapperService modelMapperService;
    @Override
    public AddCartResponse addCart(AddCartRequest addCartRequest) {
//        Cart cart = new Cart();
//        cart.setTotalPrice(addCartRequest.getTotalPrice());

        Cart cart=modelMapperService.getMapperRequest().map(addCartRequest,Cart.class);
        Cart savedCart = cartRepository.save(cart);
        AddCartResponse response= modelMapperService.getMapperResponse().map(savedCart,AddCartResponse.class);
//        AddCartResponse response = new AddCartResponse(savedCart.getId(), savedCart.getTotalPrice());
        return response;
    }
}
