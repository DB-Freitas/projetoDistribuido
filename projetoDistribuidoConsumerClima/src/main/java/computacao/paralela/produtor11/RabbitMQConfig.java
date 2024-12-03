package computacao.paralela.produtor11;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String FILA_CLIMA = "filaClima";
    public static final String EXCHANGE_CLIMA = "exchangeClima";
    public static final String ROUTING_KEY_CLIMA = "filaClima";

    @Bean
    public Queue filaClima() {
        return new Queue(FILA_CLIMA, true);
    }

    @Bean
    public  RabbitAdmin rabbitAdmin(org.springframework.amqp.rabbit.connection.ConnectionFactory connectionFactory){
        return new RabbitAdmin((org.springframework.amqp.rabbit.connection.ConnectionFactory) connectionFactory);
    }

    @Bean
    public ApplicationListener<ApplicationReadyEvent> applicationReadyEventApplicationListener (RabbitAdmin rabbitAdmin){
        return event -> rabbitAdmin.initialize();
    }

    @Bean
    public DirectExchange exchangeClima() {
        return new DirectExchange(EXCHANGE_CLIMA);
    }

    @Bean
    public Binding bindingClima(Queue filaClima, DirectExchange exchangeClima) {
        return BindingBuilder.bind(filaClima).to(exchangeClima).with(ROUTING_KEY_CLIMA);
    }
}
