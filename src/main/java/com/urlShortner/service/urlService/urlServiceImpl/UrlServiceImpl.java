package com.urlShortner.service.urlService.urlServiceImpl;

import com.urlShortner.commandObject.url.UrlCO;
import com.urlShortner.model.url.Url;
import com.urlShortner.service.urlService.UrlService;
import org.apache.commons.lang3.StringUtils;

public class UrlServiceImpl implements UrlService {

    @Override
    public Url generateShortUrl(UrlCO urlCO) {
        if (StringUtils.isNotEmpty(urlCO.getOriginalUrl())){
            String encodedUrl=en
        }
        return null;
    }

    @Override
    public Url persistShortLink(Url url) {
        return null;
    }

    @Override
    public Url getEncodedUrl(String url) {
        return null;
    }

    @Override
    public void deleteShortUrl(Url url) {

    }
}
