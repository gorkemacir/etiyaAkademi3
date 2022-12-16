package com.etiya.ecommercedemopair3.business.concrets;

import com.etiya.ecommercedemopair3.business.abstracts.CustomerService;
import com.etiya.ecommercedemopair3.business.constants.Messages;
import com.etiya.ecommercedemopair3.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair3.core.util.results.DataResult;
import com.etiya.ecommercedemopair3.core.util.results.SuccessDataResult;
import com.etiya.ecommercedemopair3.entities.concrets.Customer;
import com.etiya.ecommercedemopair3.repository.abstracts.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerManager implements CustomerService {
    CustomerRepository customerRepository;

    @Override
    public DataResult<Customer> getById(int id) {
        Customer response = customerRepository.findById(id).orElseThrow();
        return new SuccessDataResult<Customer>(response, Messages.Customer.customerGetAllSuccessMessage);
    }

    @Override
    public SuccessDataResult<List<Customer>> getAll() {
        List<Customer> response = customerRepository.findAll();
        return new SuccessDataResult<List<Customer>>(response, Messages.Customer.customerGetByIdSuccessMessage);
    }
}
