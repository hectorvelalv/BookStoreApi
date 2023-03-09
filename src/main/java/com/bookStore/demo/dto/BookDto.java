package com.bookStore.demo.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class BookDto {

    @NonNull
    private long id;
    @NotBlank
    private String author;
    @NotBlank
    private String title;
    @DecimalMin(value = "0.5", message = "The price must be greater than or equal to 0.5")
    private float price;
    @Min(1)
    private int available;




}
