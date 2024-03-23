package com.serdar.loans.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

@Data
public class LoanDto {

        @NotEmpty(message = "Mobile number can not be a null or empty!")
        @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits!")
        private String mobileNumber;

        @NotEmpty(message = "Loan number can not be a null or empty!")
        @Pattern(regexp = "(^$|[0-9]{12})", message = "Loan number must be 12 digits!")
        private String loanNumber;

        @NotEmpty(message = "Loan type can not be a null or empty!")
        private String loanType;

        @Positive(message = "Total loan amount should be greater than zero!")
        private int totalLoan;

        @PositiveOrZero(message = "Total loan amount paid should be equal or greater than zero!")
        private int amountPaid;

        @PositiveOrZero(message = "Total outstanding amount should be equal or greater than zero!")
        private int outstandingAmount;

}
