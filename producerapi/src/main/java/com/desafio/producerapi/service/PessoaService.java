package com.desafio.producerapi.service;

import com.desafio.producerapi.domain.model.Pessoa;
import com.desafio.producerapi.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PessoaService {

    @Autowired
    private PessoaRepository repository;

    public void salvar(Pessoa pessoa) {
        repository.save(pessoa);
    }
}

