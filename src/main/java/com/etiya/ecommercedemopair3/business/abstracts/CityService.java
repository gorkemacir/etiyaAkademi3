package com.etiya.ecommercedemopair3.business.abstracts;

import com.etiya.ecommercedemopair3.business.dtos.requests.city.AddCityRequest;
import com.etiya.ecommercedemopair3.business.dtos.responses.city.AddCityResponse;

public interface CityService {

    AddCityResponse addCity(AddCityRequest addCityRequest);

}
