package com.etiya.ecommercedemopair3.business.abstracts;

import com.etiya.ecommercedemopair3.core.util.results.DataResult;
import com.etiya.ecommercedemopair3.core.util.results.SuccessDataResult;
import com.etiya.ecommercedemopair3.entities.concrets.Customer;

import java.util.List;

public interface CustomerService {
    //    AddCustomerResponse addCustomer(AddCustomerRequest addCustomerRequest);
    DataResult<Customer> getById(int id);
    SuccessDataResult<List<Customer>> getAll();
}
