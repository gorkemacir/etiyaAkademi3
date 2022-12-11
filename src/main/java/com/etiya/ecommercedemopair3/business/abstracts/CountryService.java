package com.etiya.ecommercedemopair3.business.abstracts;

import com.etiya.ecommercedemopair3.business.dtos.requests.country.AddCountryRequest;
import com.etiya.ecommercedemopair3.business.dtos.responses.country.AddCountryResponse;
import com.etiya.ecommercedemopair3.entities.concrets.Country;

public interface CountryService {
    Country getById(int id);
    AddCountryResponse addCountry(AddCountryRequest addCountryRequest);
}
