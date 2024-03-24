package com.serdar.accounts.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

// APPLICATION.YML ICERISINDE TANIMLANAN ACCOUNT BILGILERINE ULASMAK ICIN ASAGIDAKI ANOTASYON KULLANILIR
// PREFIX YML DOSYASI ICERISINDEKI ALANDAN GELMEKTEDIR
// RECORD YAPISI KULLANIM KOLAYLIGI NEDENIYLE KULLANILDI
// SON OLARAK MAIN METODUNUN OLDUGU CLASS ICERISINDE BIR ANOTASYON DAHA KULLANILDI, BOYLECE ILGILI DEGERLERE ERISIM SAGLANABILMEKTEDIR
@ConfigurationProperties(prefix = "accounts")
//public record AccountContactInfoDto(String message, Map<String, String> contactDetails, List<String> onCallSupport) {};
@Getter
@Setter
public class AccountContactInfoDto {
    private String message;
    private Map<String, String> contactDetails;
    private List<String> onCallSupport;
}