package com.etiya.ecommercedemopair3.business.concrets;

import com.etiya.ecommercedemopair3.business.abstracts.CountryService;
import com.etiya.ecommercedemopair3.business.dtos.requests.country.AddCountryRequest;
import com.etiya.ecommercedemopair3.business.dtos.responses.country.AddCountryResponse;
import com.etiya.ecommercedemopair3.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair3.entities.concrets.Country;
import com.etiya.ecommercedemopair3.repository.abstracts.CountryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CountryManager implements CountryService {
    private CountryRepository countryRepository;

    private ModelMapperService modelMapperService;

    @Override
    public Country getById(int id) {
        return countryRepository.findById(id).orElseThrow();
    }

    @Override
    public AddCountryResponse addCountry(AddCountryRequest addCountryRequest) {
//        Country country = new Country();
//        country.setName(addCountryRequest.getName());
        Country country=modelMapperService.getMapperRequest().map(addCountryRequest,Country.class);

        Country savedCountry = countryRepository.save(country);
        AddCountryResponse response=modelMapperService.getMapperResponse().map(savedCountry,AddCountryResponse.class);
//        AddCountryResponse response = new AddCountryResponse(savedCountry.getId(), savedCountry.getName());
        return response;
    }
}