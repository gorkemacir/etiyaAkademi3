package com.etiya.ecommercedemopair3.business.concrets;

import com.etiya.ecommercedemopair3.business.abstracts.StreetService;
import com.etiya.ecommercedemopair3.business.dtos.requests.street.AddStreetRequest;
import com.etiya.ecommercedemopair3.business.dtos.responses.street.AddStreetResponse;
import com.etiya.ecommercedemopair3.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair3.entities.concrets.Street;
import com.etiya.ecommercedemopair3.repository.abstracts.StreetRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StreetManager implements StreetService {
    private StreetRepository streetRepository;

    private ModelMapperService modelMapperService;

    @Override
    public Street getById(int id) {
        return streetRepository.findById(id).orElseThrow();
    }

    @Override
    public AddStreetResponse addStreet(AddStreetRequest addStreetRequest) {
//        Street street = new Street();
//        street.setName(addStreetRequest.getName());
        Street street=modelMapperService.getMapperRequest().map(addStreetRequest,Street.class);
        Street savedStreet = streetRepository.save(street);
        AddStreetResponse response=modelMapperService.getMapperResponse().map(savedStreet,AddStreetResponse.class);
        //AddStreetResponse response = new AddStreetResponse(savedStreet.getId(),savedStreet.getName());
        return response;
    }
}