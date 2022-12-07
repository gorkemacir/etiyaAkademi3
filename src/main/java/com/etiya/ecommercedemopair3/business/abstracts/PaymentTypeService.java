package com.etiya.ecommercedemopair3.business.abstracts;

import com.etiya.ecommercedemopair3.business.dtos.requests.paymentType.AddPaymentTypeRequest;
import com.etiya.ecommercedemopair3.business.dtos.responses.paymentType.AddPaymentTypeResponse;
import com.etiya.ecommercedemopair3.entities.concrets.PaymentType;

import java.util.List;

public interface PaymentTypeService {
    List<PaymentType> getAll();
    PaymentType getById(int id);
    PaymentType getByName(String name);
    PaymentType getByDescription(String description);
    AddPaymentTypeResponse addPaymentType(AddPaymentTypeRequest addPaymentTypeRequest);
}
