package com.etiya.ecommercedemopair3.business.concrets;

import com.etiya.ecommercedemopair3.business.abstracts.CustomerService;
import com.etiya.ecommercedemopair3.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair3.entities.concrets.Customer;
import com.etiya.ecommercedemopair3.repository.abstracts.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerManager implements CustomerService {
    CustomerRepository customerRepository;

    private ModelMapperService modelMapperService;

//    @Override
//    public AddCustomerResponse addCustomer(AddCustomerRequest addCustomerRequest) {
////        Customer customer =new Customer();
////        customer.setCustomerNumber(addCustomerRequest.getCustomerNumber());
////        customer.setCart(addCustomerRequest.getCart());
//        Customer customer=modelMapperService.getMapperRequest().map(addCustomerRequest,Customer.class);
//
//        Customer savedCustomer=customerRepository.save(customer);
//        AddCustomerResponse response=modelMapperService.getMapperResponse().map(savedCustomer,AddCustomerResponse.class);
////        AddCustomerResponse response=new AddCustomerResponse(savedCustomer.getId(),savedCustomer.getCustomerNumber(),savedCustomer.getCart());
//        return  response;
//    }

    @Override
    public Customer getById(int id) {
        return customerRepository.findById(id).orElseThrow();
    }
}
