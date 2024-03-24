package com.serdar.loans.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

@ConfigurationProperties(prefix = "loans")
//public record LoanContactInfoDto(String message, Map<String, String> contactDetails, List<String> onCallSupport) {
//}
@Getter
@Setter
public class LoanContactInfoDto {
    private String message;
    private Map<String, String> contactDetails;
    private List<String> onCallSupport;
}