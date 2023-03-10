package com.bookStore.demo.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @NotBlank
    private String title;

    @NonNull
    @NotBlank
    private String author;

    @NonNull
    @NotNull
    @DecimalMin(value = "0.5", message = "The price must be greater than or equal to 0.5")
    private float price;

    @NonNull
    @NotNull
    @Min(1)
    private int available;

}
