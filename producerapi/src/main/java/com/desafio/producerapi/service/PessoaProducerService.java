package com.desafio.producerapi.service;

import com.desafio.producerapi.domain.model.Pessoa;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PessoaProducerService {

    @Autowired
    private KafkaTemplate<String, Pessoa> kafkaTemplate;

    private static final String TOPICO = "cadastro-pessoa";

    public void enviarParaKafka(Pessoa pessoa) {
        kafkaTemplate.send(TOPICO, pessoa);
    }
}