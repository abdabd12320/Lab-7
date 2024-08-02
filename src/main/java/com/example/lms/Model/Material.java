package com.example.lms.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Material {

    @NotEmpty(message = "id should not be empty")
    private String id;
    @NotEmpty(message = "name should not be empty")
    @Size(min = 2,max = 20,message = "name should be between 2 and 20 characters")
    private String name;
    @NotEmpty(message = "level should not be empty")
    @Pattern(regexp = "low|high")
    private String level;
    @NotEmpty(message = "type should not be empty")
    private String type;

}
