package com.serdar.loans.controller;

import com.serdar.loans.constants.AppConstants;
import com.serdar.loans.dto.ErrorResponseDto;
import com.serdar.loans.dto.LoanContactInfoDto;
import com.serdar.loans.dto.LoanDto;
import com.serdar.loans.dto.ResponseDto;
import com.serdar.loans.service.ILoanService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Validated
public class LoanController {

    private ILoanService loanService;

    @Autowired
    private LoanContactInfoDto loanContactInfoDto;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createLoan(
            @RequestParam @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits!") String mobileNumber) {
        loanService.createLoan(mobileNumber);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(AppConstants.STATUS_201, AppConstants.MESSAGE_201));
    }

    @GetMapping("/fetch")
    public ResponseEntity<LoanDto> fetchLoanDetails(
            @RequestParam @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits!") String mobileNumber) {
        LoanDto loadDto = loanService.fetchLoan(mobileNumber);
        return ResponseEntity.status(HttpStatus.OK).body(loadDto);
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateLoanDetails(@Valid @RequestBody LoanDto loadDto) {
        boolean isUpdated = loanService.updateLoan(loadDto);
        if (isUpdated) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(AppConstants.STATUS_200, AppConstants.MESSAGE_200));
        } else {
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(AppConstants.STATUS_417,
                            AppConstants.MESSAGE_417_UPDATE));
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteLoanDetails(
            @RequestParam @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits!") String mobileNumber) {
        boolean isDeleted = loanService.deleteLoan(mobileNumber);
        if (isDeleted) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(AppConstants.STATUS_200, AppConstants.MESSAGE_200));
        } else {
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(AppConstants.STATUS_417,
                            AppConstants.MESSAGE_417_DELETE));
        }
    }

    @GetMapping("/contact-info")
    public ResponseEntity<LoanContactInfoDto> getContactInfo() {
        return ResponseEntity.status(HttpStatus.OK).body(loanContactInfoDto);
    }

}
