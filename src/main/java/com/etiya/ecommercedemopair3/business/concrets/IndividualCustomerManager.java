package com.etiya.ecommercedemopair3.business.concrets;

import com.etiya.ecommercedemopair3.business.abstracts.IndividualCustomerService;
import com.etiya.ecommercedemopair3.business.dtos.requests.individualCustomer.AddIndividualCustomerRequest;
import com.etiya.ecommercedemopair3.business.dtos.responses.individualCustomer.AddIndividualCustomerResponse;
import com.etiya.ecommercedemopair3.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair3.entities.concrets.IndividualCustomer;
import com.etiya.ecommercedemopair3.repository.abstracts.IndividualCustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class IndividualCustomerManager implements IndividualCustomerService {
    private IndividualCustomerRepository individualCustomerRepository;

    private ModelMapperService modelMapperService;

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
//        IndividualCustomer individualCustomer = new IndividualCustomer();
//        individualCustomer.setFirstName(addIndividualCustomerRequest.getFirstName());
//        individualCustomer.setLastName(addIndividualCustomerRequest.getLastName());
//        individualCustomer.setNationalIdentity(addIndividualCustomerRequest.getNationalIdentity());
//        individualCustomer.setCustomerNumber(addIndividualCustomerRequest.getCustomerNumber());

        IndividualCustomer individualCustomer=modelMapperService.getMapperRequest().map(addIndividualCustomerRequest,IndividualCustomer.class);

        IndividualCustomer savedIndividualCustomer = individualCustomerRepository.save(individualCustomer);

        AddIndividualCustomerResponse response=modelMapperService.getMapperResponse().map(savedIndividualCustomer,AddIndividualCustomerResponse.class);

        //AddIndividualCustomerResponse response = new AddIndividualCustomerResponse(savedIndividualCustomer.getId(), savedIndividualCustomer.getFirstName(), savedIndividualCustomer.getLastName(), savedIndividualCustomer.getNationalIdentity());


        return response;
    }
}
