package com.urlShortner.model.url;

import com.urlShortner.enums.Enums;
import com.urlShortner.util.AppUtil;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "url")
@Data
@NoArgsConstructor

public class Url {

    @Id
    private String id;
    @CreatedDate
    private LocalDateTime dateCreated;
    @LastModifiedDate
    private LocalDateTime lastUpdated;
    private Enums.Status status = Enums.Status.CURRENT;
    private String uniqueId = AppUtil.generateRandomUniqueString();
    private String originalUrl;
    private String shortLink;
    private LocalDateTime expirationDate;

}
