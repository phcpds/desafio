package com.desafio.producerapi.controller;

import com.desafio.producerapi.domain.dto.PessoaDto;
import com.desafio.producerapi.domain.model.Pessoa;
import com.desafio.producerapi.service.PessoaProducerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pessoas")
@RequiredArgsConstructor
public class PessoaController {

    @Autowired
    private PessoaProducerService pessoaProducerService;

    private ModelMapper modelMapper = new ModelMapper();

    @PostMapping
    public ResponseEntity<String> cadastrarPessoa(@RequestBody @Valid PessoaDto pessoaDto) {
        Pessoa pessoa = modelMapper.map(pessoaDto, Pessoa.class);

        pessoaProducerService.enviarParaKafka(pessoa);
        return ResponseEntity.ok("Pessoa enviada com sucesso para a fila!");
    }
}
