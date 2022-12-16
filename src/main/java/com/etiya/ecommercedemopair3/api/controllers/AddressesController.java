package com.etiya.ecommercedemopair3.api.controllers;

import com.etiya.ecommercedemopair3.business.abstracts.AddressService;
import com.etiya.ecommercedemopair3.business.constants.Paths;
import com.etiya.ecommercedemopair3.business.dtos.requests.address.AddAddressRequest;
import com.etiya.ecommercedemopair3.business.dtos.responses.address.AddAddressResponse;
import com.etiya.ecommercedemopair3.core.util.results.DataResult;
import com.etiya.ecommercedemopair3.entities.concrets.Address;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(Paths.apiPrefix + "addresses")
@AllArgsConstructor
public class AddressesController {
    AddressService addressService;

    @GetMapping("/getAll")
    public DataResult<List<Address>> getAll() {
        return addressService.getAll();
    }

    @GetMapping("{id}")
    public DataResult<Address> getById(@PathVariable int id) {
        return addressService.getById(id);
    }

    @GetMapping("/title")
    public List<Address> getAllAddressByTitle(@RequestParam("title") String title) {
        return addressService.getAllAddressByTitle(title);
    }

    @GetMapping("/description")
    public Address findByDescription(@RequestParam("description") String description) {
        return addressService.findByDescription(description);
    }

    @PostMapping("/add")
    public ResponseEntity<DataResult<AddAddressResponse>> addAddress(@RequestBody @Valid AddAddressRequest addAddressRequest) {
        return new ResponseEntity<>(addressService.addAddress(addAddressRequest), HttpStatus.CREATED);
    }
}
