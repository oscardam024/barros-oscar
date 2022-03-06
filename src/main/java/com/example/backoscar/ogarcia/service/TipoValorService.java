package com.example.backoscar.ogarcia.service;

import com.example.backoscar.ogarcia.model.TipoValor;
import com.example.backoscar.ogarcia.repository.TipoValorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoValorService extends BaseService<TipoValor,Integer, TipoValorRepository>{

    @Autowired
    private TipoValorRepository tipoValorRepository;

    public TipoValor addTipoValor(TipoValor tipoValor){
        return tipoValorRepository.save(tipoValor);
    }


}
