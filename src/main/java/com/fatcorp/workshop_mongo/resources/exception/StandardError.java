package com.fatcorp.workshop_mongo.resources.exception;

import java.io.Serial;
import java.io.Serializable;

public class StandardError implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String message;
    private Integer statusCode;
    private String error;
    private Long timestamp;
    private String path;

    public String getMessage() {
        return message;
    }

    public String getError() {
        return error;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public String getPath() {
        return path;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setError(String error) {
        this.error = error;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public StandardError(String message, Integer statusCode, String error, Long timestamp, String path) {
        super();
        this.message = message;
        this.statusCode = statusCode;
        this.error = error;
        this.timestamp = timestamp;
        this.path = path;
    }
}
