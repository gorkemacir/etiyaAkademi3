package com.etiya.ecommercedemopair3.business.abstracts;

import com.etiya.ecommercedemopair3.business.dtos.requests.city.AddCityRequest;
import com.etiya.ecommercedemopair3.business.dtos.responses.city.AddCityResponse;
import com.etiya.ecommercedemopair3.entities.concrets.City;

public interface CityService {
    City getById(int id);
    AddCityResponse addCity(AddCityRequest addCityRequest);
}
