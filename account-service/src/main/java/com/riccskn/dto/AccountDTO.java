package com.riccskn.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class AccountDTO {

    @NotBlank
    @Size(max = 18)
    private String username;

    @NotBlank
    @Size(max = 45)
    private String name;

    @NotBlank
    private String password;

    @Email
    private String email;

}
