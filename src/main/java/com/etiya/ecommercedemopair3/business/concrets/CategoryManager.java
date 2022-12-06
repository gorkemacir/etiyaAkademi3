package com.etiya.ecommercedemopair3.business.concrets;

import com.etiya.ecommercedemopair3.business.abstracts.CategoryService;
import com.etiya.ecommercedemopair3.business.dtos.requests.category.AddCategoryRequest;
import com.etiya.ecommercedemopair3.business.dtos.responses.category.AddCategoryResponse;
import com.etiya.ecommercedemopair3.entities.concrets.Category;
import com.etiya.ecommercedemopair3.repository.abstracts.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryManager implements CategoryService {
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public AddCategoryResponse addCategory(AddCategoryRequest addCategoryRequest) {
        Category category=new Category();
        category.setName(addCategoryRequest.getName());
        Category savedCategory=categoryRepository.save(category);
        AddCategoryResponse response=new AddCategoryResponse(savedCategory.getId(),savedCategory.getName());
        return  response;
    }
}
