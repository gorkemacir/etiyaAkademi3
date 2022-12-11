package com.etiya.ecommercedemopair3.business.concrets;

import com.etiya.ecommercedemopair3.business.abstracts.CategoryService;
import com.etiya.ecommercedemopair3.business.constants.Messages;
import com.etiya.ecommercedemopair3.business.dtos.requests.category.AddCategoryRequest;
import com.etiya.ecommercedemopair3.business.dtos.responses.category.AddCategoryResponse;
import com.etiya.ecommercedemopair3.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair3.entities.concrets.Category;
import com.etiya.ecommercedemopair3.repository.abstracts.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryManager implements CategoryService {
    private CategoryRepository categoryRepository;

    private ModelMapperService modelMapperService;

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getById(int id) {
        return categoryRepository.findById(id).orElseThrow();
    }

    @Override
    public AddCategoryResponse addCategory(AddCategoryRequest addCategoryRequest) {
//        Category category = new Category();
//        category.setName(addCategoryRequest.getName());
        categoryCanNotExistWithSameName(addCategoryRequest.getName());

        Category category=modelMapperService.getMapperRequest().map(addCategoryRequest,Category.class);
        Category savedCategory = categoryRepository.save(category);

        AddCategoryResponse response= modelMapperService.getMapperResponse().map(savedCategory,AddCategoryResponse.class);
//                new AddCategoryResponse(savedCategory.getId(), savedCategory.getName());
        return response;
    }

    private void categoryCanNotExistWithSameName(String name){
        // Exception fırlatma
        boolean isExists = categoryRepository.existsCategoryByName(name);
        if(isExists)
            throw new RuntimeException(Messages.Category.CategoryExistWithSameName);
    }

}
