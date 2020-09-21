package com.urlShortner.service.urlService.urlServiceImpl;

import com.urlShortner.commandObject.url.UrlCO;
import com.urlShortner.model.url.Url;
import com.urlShortner.repository.url.UrlRepository;
import com.urlShortner.service.urlService.UrlService;
import com.urlShortner.util.AppUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
@Service
public class UrlServiceImpl implements UrlService {

    @Autowired
    private UrlRepository urlRepository;

    @Override
    public Url generateShortUrl(UrlCO urlCO) {
        if (StringUtils.isNotEmpty(urlCO.getOriginalUrl())) {
            String encodedUrl = AppUtil.encodeUrl(urlCO.getOriginalUrl());
            Url url = new Url();
            url.setDateCreated(LocalDateTime.now());
            url.setOriginalUrl(urlCO.getOriginalUrl());
            url.setShortLink(encodedUrl);
            url.setExpirationDate(getExpirationDate(urlCO.getExpirationDate(), url.getDateCreated()));
            urlRepository.save(url);
            return url;
        }
        return null;
    }

    private LocalDateTime getExpirationDate(String expirationDate, LocalDateTime dateCreated) {
        if (StringUtils.isBlank(expirationDate)) {
            return dateCreated.plusSeconds(120);
        } else {
            return LocalDateTime.parse(expirationDate);
        }
    }

    @Override
    public Url getEncodedUrl(String url) {
        return urlRepository.findByShortLink(url);
    }

    @Override
    public void deleteShortUrl(Url url) {
        urlRepository.delete(url);
    }
}
