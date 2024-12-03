package computacao.paralela.produtor11.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import computacao.paralela.produtor11.dto.DadosProducao;
import computacao.paralela.produtor11.RabbitMQConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ProducerController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private final ObjectMapper mapper = new ObjectMapper();

    @PostMapping("/sendDadosProducao")
    public ResponseEntity<String> sendAgricultureData(@RequestBody DadosProducao dadosProducao) throws JsonProcessingException {
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_PRODUCAO, RabbitMQConfig.ROUTING_KEY_PRODUCAO, mapper.writeValueAsString(dadosProducao));
        return ResponseEntity.ok("Dados enviados com sucesso!");
    }

}