package com.etiya.ecommercedemopair3.business.abstracts;

import com.etiya.ecommercedemopair3.business.dtos.requests.street.AddStreetRequest;
import com.etiya.ecommercedemopair3.business.dtos.responses.street.AddStreetResponse;
import com.etiya.ecommercedemopair3.entities.concrets.Street;

public interface StreetService {
    Street getById(int id);
    AddStreetResponse addStreet(AddStreetRequest addStreetRequest);
}
