package com.urlShortner.repository.url;

import com.urlShortner.model.url.Url;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UrlRepository extends MongoRepository<Url,String> {

    public Url findByShortLink(String url);
}
