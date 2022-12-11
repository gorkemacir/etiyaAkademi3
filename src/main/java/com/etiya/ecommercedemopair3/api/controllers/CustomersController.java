package com.etiya.ecommercedemopair3.api.controllers;

import com.etiya.ecommercedemopair3.business.abstracts.CustomerService;
import com.etiya.ecommercedemopair3.business.constants.Paths;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Paths.apiPrefix+"customers")
@AllArgsConstructor
public class CustomersController {
    private CustomerService customerService;
//    @PostMapping("/add")
//    public ResponseEntity<AddCustomerResponse> addCustomer(@RequestBody AddCustomerRequest addCustomerRequest)
//    {
//        return new ResponseEntity<AddCustomerResponse>(customerService.addCustomer(addCustomerRequest), HttpStatus.CREATED);
//    }
}
