package com.example.lms.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {

    @NotEmpty(message = "id should not be empty")
    private String id;
    @NotEmpty(message = "name should not be empty")
    @Size(min = 4,max = 15,message = "name should be between 4 and 15 characters")
    private String name;
    @NotNull(message = "age must not be null")
    @Positive(message = "age must be positive")
    private int age;
    @Email(message = "email should be with @")
    private String email;
    @AssertTrue(message = "regular should be true")
    private boolean isRegular;
}
