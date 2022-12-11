package com.etiya.ecommercedemopair3.business.abstracts;

import com.etiya.ecommercedemopair3.business.dtos.requests.address.AddAddressRequest;
import com.etiya.ecommercedemopair3.business.dtos.responses.address.AddAddressResponse;
import com.etiya.ecommercedemopair3.entities.concrets.Address;

import java.util.List;

public interface AddressService {
    List<Address> getAll();
    Address getById(int id);
    List<Address> getAllAddressByTitle(String title);
    Address findByDescription(String description);
    AddAddressResponse addAddress(AddAddressRequest addAddressRequest);
}
