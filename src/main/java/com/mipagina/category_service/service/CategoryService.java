package com.mipagina.category_service.service;
import com.mipagina.category_service.dto.CategoryDTO;
import com.mipagina.category_service.dto.ProductDTO;
import com.mipagina.category_service.model.Category;
import com.mipagina.category_service.repository.ICategoryRepository;
import com.mipagina.category_service.repository.IProductAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService{

    @Autowired
    private ICategoryRepository categoryRepository;

    @Autowired
    private IProductAPI productAPI;

    @Override
    public void saveCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public List<Category> findAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategory(Long id_category) {
        return categoryRepository.findById(id_category).orElse(null);
    }

    @Override
    public void editCategory(Long id_category, Category category) {
        Category category1=this.getCategory(id_category);
        category1.setId_category(id_category);
        category1.setName(category.getName());
        this.saveCategory(category1);
    }

    @Override
    public void deleteCategory(Long id_category) {
        categoryRepository.deleteById(id_category);
    }

    @Override
    public CategoryDTO getProductsAndCategory(Long id_category) {
        Category category = categoryRepository.findById(id_category).orElse(null);
        List<ProductDTO> listProducts = productAPI.getProductsByCategoryId(id_category);

        CategoryDTO categoryDTO = new CategoryDTO(category.getId_category(), category.getName(), listProducts);
        return categoryDTO;
    }
}
