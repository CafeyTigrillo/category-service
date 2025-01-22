package com.mipagina.category_service.dto;

import java.util.List;

public class CategoryDTO {
    private Long id_category;
    private String name;
    private List<ProductDTO> listProducts;

    public Long getId_category() {
        return id_category;
    }

    public void setId_category(Long id_category) {
        this.id_category = id_category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ProductDTO> getListProducts() {
        return listProducts;
    }

    public void setListProducts(List<ProductDTO> listProducts) {
        this.listProducts = listProducts;
    }

    public CategoryDTO() {
    }

    public CategoryDTO(Long id_category, String name, List<ProductDTO> listProducts) {
        this.id_category = id_category;
        this.name = name;
        this.listProducts = listProducts;
    }
}
