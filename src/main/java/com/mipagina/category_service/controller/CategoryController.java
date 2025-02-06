package com.mipagina.category_service.controller;

import com.mipagina.category_service.dto.CategoryDTO;
import com.mipagina.category_service.model.Category;
import com.mipagina.category_service.service.ICategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@CrossOrigin(origins = "http://localhost:3000")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @Operation(summary = "Create a new category", description = "Adds a new category to the system.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Category created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid category data")
    })
    @PostMapping("/create")
    public void createCategory(
            @Parameter(description = "Category object to be created", required = true)
            @RequestBody Category category) {
        categoryService.saveCategory(category);
    }

    @Operation(summary = "Retrieve all categories", description = "Returns a list of all categories in the system.")
    @ApiResponse(responseCode = "200", description = "Categories retrieved successfully")
    @GetMapping("/bring_all")
    public List<Category> bringAllCategory() {
        return categoryService.findAllCategory();
    }

    @Operation(summary = "Retrieve a category by ID", description = "Returns a category based on the provided category ID.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Category found successfully"),
            @ApiResponse(responseCode = "404", description = "Category not found")
    })
    @GetMapping("/bring_category/{id_category}")
    public Category getCategoryById(
            @Parameter(description = "ID of the category to retrieve", example = "1", required = true)
            @PathVariable Long id_category) {
        return categoryService.getCategory(id_category);
    }

    @Operation(summary = "Edit category details", description = "Updates the information of an existing category.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Category edited successfully"),
            @ApiResponse(responseCode = "404", description = "Category not found")
    })
    @PutMapping("/edit/{id_category}")
    public String editCategory(
            @Parameter(description = "ID of the category to edit", example = "1", required = true)
            @PathVariable Long id_category,
            @Parameter(description = "Updated category data", required = true)
            @RequestBody Category category) {
        categoryService.editCategory(id_category, category);
        return "Category edited successfully";
    }

    @Operation(summary = "Delete a category", description = "Removes a category from the system using the provided ID.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Category deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Category not found")
    })
    @DeleteMapping("/delete/{id_category}")
    public String deleteCategory(
            @Parameter(description = "ID of the category to delete", example = "1", required = true)
            @PathVariable Long id_category) {
        categoryService.deleteCategory(id_category);
        return "Category deleted successfully";
    }

    @Operation(summary = "Retrieve category with products", description = "Returns a category along with its associated products.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Category and products retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "Category not found")
    })
    @GetMapping("/products/{id_category}")
    public CategoryDTO getProductsAndCategory(
            @Parameter(description = "ID of the category", example = "1", required = true)
            @PathVariable Long id_category) {
        return categoryService.getProductsAndCategory(id_category);
    }
}
