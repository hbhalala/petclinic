package com.project.petclinic.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class UserRequest {
    @NotNull(message = "firstname cannot be null")
    private String firstName;
    @NotNull(message = "lastname cannot be null")
    private String lastName;
    @Email (message = "email address is not valid")
    private String email;
    @Pattern(regexp = "^\\d{10}$", message = "phone number is not valid" )
    private String phone;
}
