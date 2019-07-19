package br.com.cwi.crescer.melevaai.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ExceptionVeiculo extends RuntimeException {

    public ExceptionVeiculo(String message) {
        super(message);
    }

}
