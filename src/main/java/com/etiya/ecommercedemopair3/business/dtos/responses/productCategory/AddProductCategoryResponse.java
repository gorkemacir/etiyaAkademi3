package com.etiya.ecommercedemopair3.business.dtos.responses.productCategory;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AddProductCategoryResponse {
    private int id;
    private int categoryId;
    private int productId;
}
