package com.dicapisar.SearchManagerAPI.exceptions;

import com.dicapisar.SearchManagerAPI.dtos.ErrorDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

@EqualsAndHashCode(callSuper = true)
@Data
public class SearchManagerException extends Exception {
    private final ErrorDTO error;
    private final HttpStatus status;

    public SearchManagerException(String message, HttpStatus status) {
        this.error = new ErrorDTO();
        this.error.setMessage(message);
        this.error.setErrorName(this.getClass().getName());
        this.status = status;
    }
}
