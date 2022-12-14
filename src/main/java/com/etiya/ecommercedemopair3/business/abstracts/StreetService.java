package com.etiya.ecommercedemopair3.business.abstracts;

import com.etiya.ecommercedemopair3.business.dtos.requests.street.AddStreetRequest;
import com.etiya.ecommercedemopair3.business.dtos.responses.street.AddStreetResponse;
import com.etiya.ecommercedemopair3.core.util.results.DataResult;
import com.etiya.ecommercedemopair3.entities.concrets.Street;

public interface StreetService {
    DataResult<Street> getById(int id);
    DataResult<AddStreetResponse> addStreet(AddStreetRequest addStreetRequest);
    DataResult<List<GetAllStreetsResponse>> getAllDto();}
