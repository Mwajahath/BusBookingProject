package com.upgrad.bookmyticket.exception;

public class UnauthorizedException extends RestException {

    public UnauthorizedException(final ErrorCode errorCode, final Object... parameters){
        super(errorCode, parameters);
    }

}
