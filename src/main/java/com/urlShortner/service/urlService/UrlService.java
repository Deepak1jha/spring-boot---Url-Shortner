package com.urlShortner.service.urlService;

import com.urlShortner.commandObject.url.UrlCO;
import com.urlShortner.model.url.Url;
import org.springframework.stereotype.Service;
@Service
public interface UrlService {

    public Url generateShortUrl(UrlCO urlCO);
    public Url getEncodedUrl(String url);
    public void deleteShortUrl(Url url);

}
