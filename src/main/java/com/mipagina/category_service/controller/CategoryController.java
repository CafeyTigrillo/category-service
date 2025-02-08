package com.mipagina.category_service.controller;

import com.mipagina.category_service.dto.CategoryDTO;
import com.mipagina.category_service.model.Category;
import com.mipagina.category_service.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @PostMapping("/create")
    public void createCategory(@RequestBody Category category ){
        categoryService.saveCategory(category);
    }

    @GetMapping("/bring_all")
    public List<Category> bringAllCategory(){
        return categoryService.findAllCategory();
    }

    @GetMapping("/bring_category/{id_category}")
    public Category getCategoryById(@PathVariable Long id_category){
        return categoryService.getCategory(id_category);
    }

    @PutMapping("/edit/{id_category}")
    public String editCategory(@PathVariable Long id_category,
                                 @RequestBody Category category){
        categoryService.editCategory(id_category,category);
        return "Category edited Successfully";
    }

    @DeleteMapping("/delete/{id_category}")
    public String deleteCategory(@PathVariable Long id_category){
        categoryService.deleteCategory(id_category);
        return "Category deleted successfully";
    }

    @GetMapping("/products/{id_category}")
    public CategoryDTO getProductsAndCategory (@PathVariable Long id_category){
        return categoryService.getProductsAndCategory(id_category);
    }

}
