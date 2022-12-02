package com.etiya.ecommercedemopair3.business.abstracts;

import com.etiya.ecommercedemopair3.entities.concrets.IndividualCustomer;
import com.etiya.ecommercedemopair3.entities.concrets.Product;

import java.util.List;

public interface IndividualCustomerService {
    List<IndividualCustomer> getAll();
    IndividualCustomer getById(int id);
    IndividualCustomer getIndividualCustomerBynationalIdentity(String nationalIdentity);
    List<IndividualCustomer> getIndividualCustomerByFirstName(String firstName);
}
