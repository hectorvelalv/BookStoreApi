package com.bookStore.demo.models.dtos;

import jakarta.validation.constraints.Min;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class PageDto {
    @NonNull
    private Long id;
    @NonNull
    private String content;
    @NonNull
    @Min(1)
    private int numberPage;

}
