package com.excecao.tratamento;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    public static final String FRASE = ". Seja muito bem vindo :)";
    @PostMapping("/home")
    public String get(@Valid @RequestBody FrontDto frontDto){

        return frontDto.getUsername() + FRASE;
    }


}
