package com.etiya.ecommercedemopair3.business.concrets;

import com.etiya.ecommercedemopair3.business.abstracts.IndividualCustomerService;
import com.etiya.ecommercedemopair3.entities.concrets.IndividualCustomer;
import com.etiya.ecommercedemopair3.repository.abstracts.IndividualCustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class IndividualCustomerManager implements IndividualCustomerService {
    IndividualCustomerRepository individualCustomerRepository;
    @Override
    public List<IndividualCustomer> getAll() {
        return individualCustomerRepository.findAll();
    }

    @Override
    public IndividualCustomer getById(int id) {
        return individualCustomerRepository.findById(id).orElseThrow();
    }

    @Override
    public IndividualCustomer getIndividualCustomerBynationalIdentity(String nationalIdentity) {
        return individualCustomerRepository.findIndividualCustomerBynationalIdentity(nationalIdentity);
    }

    @Override
    public List<IndividualCustomer> getIndividualCustomerByFirstName(String firstName) {
        return individualCustomerRepository.findIndividualCustomerByFirstName(firstName);
    }
}
