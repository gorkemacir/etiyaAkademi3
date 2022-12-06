package com.etiya.ecommercedemopair3.api.controllers;

import com.etiya.ecommercedemopair3.business.abstracts.CityService;
import com.etiya.ecommercedemopair3.business.dtos.requests.city.AddCityRequest;
import com.etiya.ecommercedemopair3.business.dtos.responses.city.AddCityResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cities")
@AllArgsConstructor
public class CitiesController {
    CityService cityService;

    @PostMapping("/add")
    public ResponseEntity<AddCityResponse> addCity(@RequestBody AddCityRequest addCityRequest) {
        return new ResponseEntity<AddCityResponse>(cityService.addCity(addCityRequest), HttpStatus.CREATED);
    }
}