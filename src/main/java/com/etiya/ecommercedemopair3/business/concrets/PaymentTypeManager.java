package com.etiya.ecommercedemopair3.business.concrets;

import com.etiya.ecommercedemopair3.business.abstracts.PaymentTypeService;
import com.etiya.ecommercedemopair3.business.dtos.requests.paymentType.AddPaymentTypeRequest;
import com.etiya.ecommercedemopair3.business.dtos.responses.paymentType.AddPaymentTypeResponse;
import com.etiya.ecommercedemopair3.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair3.entities.concrets.PaymentType;
import com.etiya.ecommercedemopair3.repository.abstracts.PaymentTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PaymentTypeManager implements PaymentTypeService {
    private PaymentTypeRepository paymentTypeRepository;

    private ModelMapperService modelMapperService;

    @Override
    public List<PaymentType> getAll() {
        return paymentTypeRepository.findAll();
    }

    @Override
    public PaymentType getById(int id) {
        return paymentTypeRepository.findById(id).orElseThrow();
    }

    @Override
    public PaymentType getByName(String name) {
        return paymentTypeRepository.findByName(name);
    }

    @Override
    public PaymentType getByDescription(String description) {
        return paymentTypeRepository.findPaymentTypeByDescription(description);
    }

    @Override
    public AddPaymentTypeResponse addPaymentType(AddPaymentTypeRequest addPaymentTypeRequest) {
//        PaymentType paymentType=new PaymentType();
//        paymentType.setDescription(addPaymentTypeRequest.getDescription());
//        paymentType.setName(addPaymentTypeRequest.getName());
        PaymentType paymentType=modelMapperService.getMapperRequest().map(addPaymentTypeRequest,PaymentType.class);

        PaymentType savedPaymentType=paymentTypeRepository.save(paymentType);

        AddPaymentTypeResponse response=modelMapperService.getMapperResponse().map(savedPaymentType,AddPaymentTypeResponse.class);
//        AddPaymentTypeResponse response=new AddPaymentTypeResponse(savedPaymentType.getId(),savedPaymentType.getDescription(),savedPaymentType.getName());
        return  response;
    }
}
