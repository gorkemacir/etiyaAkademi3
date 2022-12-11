package com.etiya.ecommercedemopair3.business.concrets;

import com.etiya.ecommercedemopair3.business.abstracts.CityService;
import com.etiya.ecommercedemopair3.business.dtos.requests.city.AddCityRequest;
import com.etiya.ecommercedemopair3.business.dtos.responses.city.AddCityResponse;
import com.etiya.ecommercedemopair3.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair3.entities.concrets.City;
import com.etiya.ecommercedemopair3.repository.abstracts.CityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CityManager implements CityService {
    private CityRepository cityRepository;

    private ModelMapperService modelMapperService;

    @Override
    public City getById(int id) {
        return cityRepository.findById(id).orElseThrow();
    }

    @Override
    public AddCityResponse addCity(AddCityRequest addCityRequest) {
//        City city = new City();
//        city.setName(addCityRequest.getName());
        City city= modelMapperService.getMapperRequest().map(addCityRequest,City.class);
        City savedCity = cityRepository.save(city);
        AddCityResponse response=modelMapperService.getMapperResponse().map(savedCity,AddCityResponse.class);
//        AddCityResponse response = new AddCityResponse(savedCity.getId(), savedCity.getName());
        return response;
    }
}

