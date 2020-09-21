package com.urlShortner.service.urlService;

import com.urlShortner.commandObject.url.UrlCO;
import com.urlShortner.model.url.Url;

public interface UrlService {

    public Url generateShortUrl(UrlCO urlCO);
    public Url persistShortLink(Url url);
    public Url getEncodedUrl(String url);
    public void deleteShortUrl(Url url);

}
