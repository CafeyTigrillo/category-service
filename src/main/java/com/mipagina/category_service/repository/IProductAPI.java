package com.mipagina.category_service.repository;

import com.mipagina.category_service.dto.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "products-category-service")
public interface IProductAPI {
    @GetMapping("/products/{id_category}")
    public List<ProductDTO> getProductsByCategoryId(@PathVariable("id_category") Long id_category);
}
