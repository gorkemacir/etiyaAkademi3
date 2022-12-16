package com.etiya.ecommercedemopair3.api.controllers;

import com.etiya.ecommercedemopair3.business.abstracts.StreetService;
import com.etiya.ecommercedemopair3.business.constants.Paths;
import com.etiya.ecommercedemopair3.business.dtos.requests.street.AddStreetRequest;
import com.etiya.ecommercedemopair3.business.dtos.responses.street.AddStreetResponse;

import com.etiya.ecommercedemopair3.business.dtos.responses.street.GetAllStreetsResponse;
import com.etiya.ecommercedemopair3.core.util.results.DataResult;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Paths.apiPrefix + "streets")
@AllArgsConstructor
public class StreetsController {
    private StreetService streetService;

    @PostMapping("/add")
    public ResponseEntity<DataResult<AddStreetResponse>> addStreet(@RequestBody AddStreetRequest addStreetRequest)
    {
        return new ResponseEntity<>(streetService.addStreet(addStreetRequest), HttpStatus.CREATED);
    }

    @GetMapping("/getAllCitiesDto")
    public DataResult<List<GetAllStreetsResponse>> getAllDto(){
        return this.streetService.getAllDto();
    }
}