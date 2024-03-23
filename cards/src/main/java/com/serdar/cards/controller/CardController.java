package com.serdar.cards.controller;

import com.serdar.cards.dto.CardContactInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.serdar.cards.constants.AppConstants;
import com.serdar.cards.dto.CardDto;
import com.serdar.cards.dto.ResponseDto;
import com.serdar.cards.service.ICardService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Validated
public class CardController {

    private ICardService cardService;

    @Autowired
    private CardContactInfoDto cardContactInfoDto;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createCard(
            @Valid @RequestParam @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits!") String mobileNumber) {
        cardService.createCard(mobileNumber);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(AppConstants.STATUS_201, AppConstants.MESSAGE_201));
    }

    @GetMapping("/fetch")
    public ResponseEntity<CardDto> fetchCardDetails(
            @RequestParam @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits!") String mobileNumber) {
        CardDto cardsDto = cardService.fetchCard(mobileNumber);
        return ResponseEntity.status(HttpStatus.OK).body(cardsDto);
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateCardDetails(@Valid @RequestBody CardDto cardsDto) {
        boolean isUpdated = cardService.updateCard(cardsDto);
        if (isUpdated) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(AppConstants.STATUS_200, AppConstants.MESSAGE_200));
        } else {
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(AppConstants.STATUS_417, AppConstants.MESSAGE_417_UPDATE));
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteCardDetails(
            @RequestParam @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits!") String mobileNumber) {
        boolean isDeleted = cardService.deleteCard(mobileNumber);
        if (isDeleted) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(AppConstants.STATUS_200, AppConstants.MESSAGE_200));
        } else {
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(AppConstants.STATUS_417, AppConstants.MESSAGE_417_DELETE));
        }
    }

    @GetMapping("/contact-info")
    public ResponseEntity<CardContactInfoDto> getContactInfo() {
        return ResponseEntity.status(HttpStatus.OK).body(cardContactInfoDto);
    }

}
