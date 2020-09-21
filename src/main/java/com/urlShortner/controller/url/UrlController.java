package com.urlShortner.controller.url;

import com.urlShortner.commandObject.url.UrlCO;
import com.urlShortner.enums.Enums;
import com.urlShortner.model.url.Url;
import com.urlShortner.service.urlService.UrlService;
import com.urlShortner.valueObject.response.ApiResponseVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping(value = "/url")
@Slf4j
public class UrlController {

    @Autowired
    private UrlService urlService;

    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody UrlCO urlCO) {
        log.info(urlCO.getOriginalUrl());
        return ResponseEntity.ok(new ApiResponseVO(Enums.ResponseType.SUCCESS, " fetched successfully", urlService.generateShortUrl(urlCO)));
    }

    @GetMapping("/{shortLink}")
    public ResponseEntity<?> fetch(@PathVariable String shortLink, HttpServletResponse response) throws IOException {
        if (StringUtils.isEmpty(shortLink)) {
            return ResponseEntity.ok(new ApiResponseVO(Enums.ResponseType.SUCCESS, "Url is not exist", null));
        }
        Url url = urlService.getEncodedUrl(shortLink);
        if (url == null) {
            return ResponseEntity.ok(new ApiResponseVO(Enums.ResponseType.SUCCESS, "Url is not exist or Exist", null));
        }
//        if (url.getDateCreated().isBefore(get)){
//            return ResponseEntity.ok(new ApiResponseVO(Enums.ResponseType.SUCCESS, "Url is expired and please go and create new Url", null));
//        }
        log.info(url.getOriginalUrl());
        log.info(url.getOriginalUrl());
        log.info(url.getOriginalUrl());
        log.info(url.getOriginalUrl());
        response.sendRedirect(url.getOriginalUrl());
        return null;

    }

}
