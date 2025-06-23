package com.mycompany.property.management.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)

public class UserDTO {

    private Long id;
    private String ownerName;
    @NotNull(message = "Owner email is manidatory")
    @NotEmpty(message = "Owner email cannot be empty")
    @Size(min = 1, max = 50, message = "owner email ahould be between 1 to 50 characters in length  ")
    private String ownerEmail;
    private String phone;
    @NotNull(message = "Password Cannot be null")
    @NotEmpty(message = "Password Cannot be empty")
    private String password;
}
