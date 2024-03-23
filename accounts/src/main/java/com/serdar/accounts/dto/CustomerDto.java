package com.serdar.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(name = "Customer", description = "Schema to hold customer and account information")
public class CustomerDto {

    @NotEmpty(message = "Name can not be null or empty!")
    @Size(min = 5, max = 30, message = "The length of the customer name should be between 5 and 30 characters!")
    @Schema(description = "Name of the customer", example = "Serdar Korkmaz")
    private String name;

    @NotEmpty(message = "Email address can not be null or empty!")
    @Email(message = "Please provide a valid email adress!")
    @Schema(description = "Email address of the customer", example = "serdar@mail.com")
    private String email;

    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits!")
    @Schema(description = "Mobile number of the customer", example = "5449210035")
    private String mobileNumber;

    @Schema(description = "Account details of the customer")
    private AccountDto accountDto;
}
