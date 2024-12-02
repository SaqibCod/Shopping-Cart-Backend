package com.Saq.fashionZShop.dto;

import com.Saq.fashionZShop.model.Category;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class ProductDto {
    private long id;
    private String name;
    private String brand;
    private BigDecimal price;
    private String description;
    private int inventory;
    private Category category;
    private List<ImageDto> images;
}
