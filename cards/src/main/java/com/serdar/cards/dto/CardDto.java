package com.serdar.cards.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
public class CardDto {

    @NotEmpty(message = "Mobile number can not be empty!")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits!")
    private String mobileNumber;

    @NotEmpty(message = "Card number can not be empty!")
    @Pattern(regexp = "(^$|[0-9]{12})", message = "Card number must be 12 digits!")
    private String cardNumber;

    @NotEmpty(message = "Card type can not be empty!")
    private String cardType;

    @Positive(message = "Total card limit should be greater than zero!")
    private int totalLimit;

    @PositiveOrZero(message = "Total amount used should be greater or equal than zero!")
    private int amountUsed;

    @PositiveOrZero(message = "Total available amount should be greater or equal than zero!")
    private int availableAmount;
}
