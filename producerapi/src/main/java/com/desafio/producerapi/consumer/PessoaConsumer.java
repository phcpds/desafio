package com.desafio.producerapi.consumer;

import com.desafio.producerapi.domain.model.Pessoa;
import com.desafio.producerapi.service.PessoaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class PessoaConsumer {

    private final PessoaService pessoaService;

    public PessoaConsumer(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @KafkaListener(topics = "cadastro-pessoa", groupId = "grupo-consumidor", containerFactory = "pessoaListenerContainerFactory")
    public void consumir(Pessoa pessoa) {
        pessoaService.salvar(pessoa);
    }
}
