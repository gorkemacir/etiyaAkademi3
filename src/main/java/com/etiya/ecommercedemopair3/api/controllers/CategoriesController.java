package com.etiya.ecommercedemopair3.api.controllers;

import com.etiya.ecommercedemopair3.business.abstracts.CategoryService;
import com.etiya.ecommercedemopair3.business.dtos.requests.category.AddCategoryRequest;
import com.etiya.ecommercedemopair3.business.dtos.responses.category.AddCategoryResponse;
import com.etiya.ecommercedemopair3.entities.concrets.Category;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoriesController {
    private CategoryService categoryService;

    @GetMapping("/getAll")
    public List<Category> getAll(){
        return categoryService.getAll();
    }

    @PostMapping("/add")
    public ResponseEntity<AddCategoryResponse> addCategory(@RequestBody AddCategoryRequest addCategoryRequest)
    {
        return  new ResponseEntity<AddCategoryResponse>(categoryService.addCategory(addCategoryRequest), HttpStatus.CREATED);
    }
}
