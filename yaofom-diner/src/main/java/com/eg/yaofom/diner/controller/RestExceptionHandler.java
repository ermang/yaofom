package com.eg.yaofom.diner.controller;


import com.eg.yaofom.common.Constant;
import com.eg.yaofom.common.ErrorResp;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestControllerAdvice
public class RestExceptionHandler {
    Logger logger = LoggerFactory.getLogger(RestExceptionHandler.class);

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = Exception.class)
    public ErrorResp defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        logger.error(e.getMessage(), e);
        return new ErrorResp(Constant.OOPS_SOMETHING_UNEXPECTED_HAPPENED, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = { RuntimeException.class })
    protected ErrorResp handleRuntimeException(RuntimeException ex, WebRequest request) {
        logger.error(ex.getMessage(), ex);
        return new ErrorResp(Constant.OOPS_SOMETHING_UNEXPECTED_HAPPENED, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = { NoSuchElementException.class })
    protected ErrorResp handleNoSuchElementException(NoSuchElementException ex, WebRequest request) {

        return new ErrorResp(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = { IllegalArgumentException.class })
    protected ErrorResp handleIllegalArgumentException(IllegalArgumentException ex, WebRequest request) {

        return new ErrorResp(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = { MethodArgumentNotValidException.class })
    protected ErrorResp handleMethodArgumentNotValidException(MethodArgumentNotValidException ex, WebRequest request) {

        String validationErrors = String.join(", ",
                ex.getBindingResult().getAllErrors().stream().map(ObjectError::getDefaultMessage).collect(Collectors.toList()));

        return new ErrorResp(validationErrors, HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = { HttpMessageNotReadableException.class })
    protected ErrorResp handleUnAuthorizedException(HttpMessageNotReadableException ex, WebRequest request) {

        return new ErrorResp(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = { HttpRequestMethodNotSupportedException.class })
    protected ErrorResp handleUnAuthorizedException(HttpRequestMethodNotSupportedException ex, WebRequest request) {

        return new ErrorResp(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
