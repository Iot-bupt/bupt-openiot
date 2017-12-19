package com.bupt.openiot.exception;

import org.springframework.http.HttpStatus;

import java.util.Date;

/**
 * Created by dy on 2017/4/23.
 */
public class OpenIoTErrorResponse {

    // HTTP Response Status Code
    private final HttpStatus status;

    // General Error message
    private final String message;

    // Error code
    private final OpenIoTErrorCode errorCode;

    private final Date timestamp;

    protected OpenIoTErrorResponse(final String message, final OpenIoTErrorCode errorCode, HttpStatus status) {
        this.message = message;
        this.errorCode = errorCode;
        this.status = status;
        this.timestamp = new Date();
    }

    public static OpenIoTErrorResponse of(final String message, final OpenIoTErrorCode errorCode, HttpStatus status) {
        return new OpenIoTErrorResponse(message, errorCode, status);
    }

    public Integer getStatus() {
        return status.value();
    }

    public String getMessage() {
        return message;
    }

    public OpenIoTErrorCode getErrorCode() {
        return errorCode;
    }

    public Date getTimestamp() {
        return timestamp;
    }
}
