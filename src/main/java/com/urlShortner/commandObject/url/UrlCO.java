package com.urlShortner.commandObject.url;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UrlCO {

    private String originalUrl;
    private String expirationDate;

}
