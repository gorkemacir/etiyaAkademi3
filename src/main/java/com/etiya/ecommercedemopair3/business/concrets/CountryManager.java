package com.etiya.ecommercedemopair3.business.concrets;

import com.etiya.ecommercedemopair3.business.abstracts.CountryService;
import com.etiya.ecommercedemopair3.business.constants.Messages;
import com.etiya.ecommercedemopair3.business.dtos.requests.country.AddCountryRequest;
import com.etiya.ecommercedemopair3.business.dtos.responses.country.AddCountryResponse;
import com.etiya.ecommercedemopair3.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair3.core.util.results.DataResult;
import com.etiya.ecommercedemopair3.core.util.results.SuccessDataResult;
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
    public DataResult<Country> getById(int id) {
        Country response  = countryRepository.findById(id).orElseThrow();
        return new SuccessDataResult<Country>(response, Messages.Country.countryGetByIdSuccesMessage);
    }

    @Override
    public DataResult<AddCountryResponse> addCountry(AddCountryRequest addCountryRequest) {
//        Country country = new Country();
//        country.setName(addCountryRequest.getName());
        Country country = modelMapperService.getMapperRequest().map(addCountryRequest, Country.class);
        Country savedCountry = countryRepository.save(country);
//        AddCountryResponse response = new AddCountryResponse(savedCountry.getId(), savedCountry.getName());
        AddCountryResponse response = modelMapperService.getMapperResponse().map(savedCountry, AddCountryResponse.class);
        return  new SuccessDataResult<AddCountryResponse>(response, Messages.Country.countryAddSuccesMessage);
    }
}