package com.mipagina.category_service.service;

import com.mipagina.category_service.dto.CategoryDTO;
import com.mipagina.category_service.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ICategoryService {

    public void saveCategory(Category category);
    public List<Category> findAllCategory();
    public Category getCategory(Long id_category);
    public void editCategory(Long id_category,Category category);
    public void deleteCategory(Long id_category);

    public CategoryDTO getProductsAndCategory(Long id_category);

}
