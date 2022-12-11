package com.etiya.ecommercedemopair3.business.abstracts;

import com.etiya.ecommercedemopair3.entities.concrets.Customer;

public interface CustomerService {
    //    AddCustomerResponse addCustomer(AddCustomerRequest addCustomerRequest);
    Customer getById(int id);
}
