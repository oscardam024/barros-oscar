package com.example.backoscar.ogarcia.controller;


import com.example.backoscar.ogarcia.model.TipoValor;
import com.example.backoscar.ogarcia.service.TipoValorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tipovalor")
public class TipoValorController {

    @Autowired
    private TipoValorService tipoValorService;

    @GetMapping("/add")
    public ResponseEntity<TipoValor> addTipoValor(@RequestBody TipoValor tipoValor){
        TipoValor addTipoValor = tipoValorService.addTipoValor(tipoValor);
        return new ResponseEntity<>(addTipoValor, HttpStatus.OK);
    }
}
