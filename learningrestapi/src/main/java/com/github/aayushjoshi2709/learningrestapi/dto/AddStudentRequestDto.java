package com.github.aayushjoshi2709.learningrestapi.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddStudentRequestDto {
    @NotBlank(message="Name is required")
    @Size(min=3, max=30, message="Name must be of length 3 to 30 characters")
    private String name;
    @Email
    @NotBlank(message= "Email is required")
    private String email;
}
