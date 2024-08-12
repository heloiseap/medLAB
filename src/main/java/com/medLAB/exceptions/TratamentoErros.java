package com.medLAB.exceptions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class TratamentoErros {

    private static final Logger LOGGER = LogManager.getLogger(TratamentoErros.class);

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> trataNoSuchElement(NoSuchElementException exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErroResponse>> trataErroValidacao(
            MethodArgumentNotValidException exception) {
        List<FieldError> fieldErrors = exception.getFieldErrors();

        List<ErroResponse> responseList = fieldErrors.stream().map(ErroResponse::new).toList();

        responseList.forEach(
                errorResponse -> LOGGER.warn("campo inválido: {} ", errorResponse.getCampo()));

        return ResponseEntity.badRequest().body(responseList);
    }

}
