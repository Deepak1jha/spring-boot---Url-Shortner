package com.urlShortner.util.exception;

public class UrlErrorResponse extends RuntimeException {

    public UrlErrorResponse(String message) {
        super(message);
    }
}
