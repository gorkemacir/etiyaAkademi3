package com.etiya.ecommercedemopair3.business.concrets;

import com.etiya.ecommercedemopair3.business.abstracts.IndividualCustomerService;
import com.etiya.ecommercedemopair3.business.dtos.requests.individualCustomer.AddIndividualCustomerRequest;
import com.etiya.ecommercedemopair3.business.dtos.responses.individualCustomer.AddIndividualCustomerResponse;
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
    public IndividualCustomer getIndividualCustomerByNationalIdentity(String nationalIdentity) {
        return individualCustomerRepository.findIndividualCustomerBynationalIdentity(nationalIdentity);
    }

    @Override
    public List<IndividualCustomer> getIndividualCustomerByFirstName(String firstName) {
        return individualCustomerRepository.findIndividualCustomerByFirstName(firstName);
    }

    @Override
    public AddIndividualCustomerResponse addIndividualCustomer(AddIndividualCustomerRequest addIndividualCustomerRequest) {
        IndividualCustomer individualCustomer = new IndividualCustomer();
        individualCustomer.setFirstName(addIndividualCustomerRequest.getFirstName());
        individualCustomer.setLastName(addIndividualCustomerRequest.getLastName());
        individualCustomer.setNationalIdentity(addIndividualCustomerRequest.getNationalIdentity());
        individualCustomer.setCustomerNumber(addIndividualCustomerRequest.getCustomerNumber());

        IndividualCustomer savedIndividualCustomer = individualCustomerRepository.save(individualCustomer);

        AddIndividualCustomerResponse response = new AddIndividualCustomerResponse(savedIndividualCustomer.getId(), savedIndividualCustomer.getFirstName(), savedIndividualCustomer.getLastName(), savedIndividualCustomer.getNationalIdentity());


        return response;
    }
}
