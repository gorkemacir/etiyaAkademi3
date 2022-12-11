package com.etiya.ecommercedemopair3.business.abstracts;

import com.etiya.ecommercedemopair3.business.dtos.requests.category.AddCategoryRequest;
import com.etiya.ecommercedemopair3.business.dtos.responses.category.AddCategoryResponse;
import com.etiya.ecommercedemopair3.entities.concrets.Category;

import java.util.List;
import java.util.Locale;

public interface CategoryService {
    List<Category> getAll();
    Category getById(int id);
    AddCategoryResponse addCategory(AddCategoryRequest addCategoryRequest);
}