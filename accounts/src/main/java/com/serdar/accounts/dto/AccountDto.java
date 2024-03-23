package com.serdar.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Schema(name = "Account", description = "Schema to hold account information")
public class AccountDto {

    @NotEmpty(message = "Account number can not be empty or null!")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Account number must be 10 digits!")
    @Schema(description = "Account number of bank account", example = "5658913374")
    private Long accountNumber;

    @NotEmpty(message = "Account type can not be empty or null!")
    @Schema(description = "Account type of bank account", example = "Savings")
    private String accountType;

    @NotEmpty(message = "Branch address can not be empty or null!")
    @Schema(description = "Branch address of bank", example = "123 New York")
    private String branchAddress;
}
