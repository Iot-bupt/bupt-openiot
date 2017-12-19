package com.bupt.openiot.exception;

/**
 * Created by dy on 2017/4/28.
 */
public class OpenIoTException extends Exception {

    private static final long serialVersionUID = 1L;

    private OpenIoTErrorCode errorCode;

    public OpenIoTException() {
        super();
    }

    public OpenIoTException(OpenIoTErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public OpenIoTException(String message, OpenIoTErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public OpenIoTException(String message, Throwable cause, OpenIoTErrorCode errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public OpenIoTException(Throwable cause, OpenIoTErrorCode errorCode) {
        super(cause);
        this.errorCode = errorCode;
    }

    public OpenIoTErrorCode getErrorCode() {
        return errorCode;
    }

}
