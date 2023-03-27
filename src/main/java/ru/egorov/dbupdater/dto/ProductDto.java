package ru.egorov.dbupdater.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import ru.egorov.dbupdater.model.StoreType;

@Getter
public class ProductDto {

    @NotEmpty
    private String name;

    @NotEmpty
    private String sku;

    private String category;

    private String brand;

    private String image;

    private String color;

    private Double price;

    private String priceCurrency;

    private String country;

    private String size;

    private String gender;

    @NotEmpty
    private String url;

    @NotNull
    private StoreType storeType;

    private String composition;

    private String coloring;
}