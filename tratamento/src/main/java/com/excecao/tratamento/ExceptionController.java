package com.excecao.tratamento;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ExceptionController {

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ErrorHandler> handle( MethodArgumentNotValidException exception) {

        /* O exception.getBindingResult().getFieldErrors() retorna o campo e a mensagem
        * que estão com erro e isso vem da propria classe MethodArgumentNotValidException
        * do springframework. */
        //As classes FieldError e MethodArgumentNotValidException vem do springframework
        //A variavel fieldErrorList retorna uma lista com os erros ocorridos
        List<FieldError> fieldErrorList = exception.getBindingResult().getFieldErrors();


        //Cria uma nova lista vazia
        List<ErrorHandler> list = new ArrayList<>();

        //Cria um foreach para adicionar os errors fieldErrorList na nova lista criada(list)
        fieldErrorList.forEach(error ->
                list.add(new ErrorHandler(error.getField(), error.getDefaultMessage())));

        return list;
    }
}
