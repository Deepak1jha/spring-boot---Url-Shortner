package com.urlShortner.util;

import com.google.common.hash.Hashing;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class AppUtil {

    public static String generateRandomUniqueString() {
        return UUID.randomUUID().toString();
    }

    public static Map<String, String> errorFields(BindingResult result) {
        Map<String, String> fieldErrorMap = new HashMap<>();
        List<FieldError> fieldErrorList = result.getFieldErrors();
        for (FieldError fieldError : fieldErrorList) {
            fieldErrorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return fieldErrorMap;
    }

    public static String encodeUrl(String url) {
        String encodedUrl = "";
        LocalDateTime time = LocalDateTime.now();
        encodedUrl = Hashing.murmur3_32()
                .hashString(url.concat(time.toString()), StandardCharsets.UTF_8).toString();
        return encodedUrl;
    }

}